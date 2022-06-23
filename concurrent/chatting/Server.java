/**
 * @Author: fengsc
 * @Date: 2022-06-06 18:15:26
 * @LastEditTime: 2022-06-08 20:15:58
 */
package chatting;

import java.net.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.nio.file.*;

class User {
    String username;
    String password;
    BufferedReader in;
    BufferedWriter out;
    AtomicBoolean flag = new AtomicBoolean(false);
    String recentMsg;
    Socket userSocket;

    User(String username, String password, BufferedReader in, BufferedWriter out, Socket userSocket) {
        this.username = username;
        this.password = password;
        this.in = in;
        this.out = out;
        this.userSocket = userSocket;
    }

    synchronized boolean isUpdated() {
        return flag.get();
    }

    synchronized String getRecentMsg() {
        flag.set(false);
        return recentMsg;
    }

    void recvMsg() {
        try {
            recentMsg = in.readLine();
            flag.set(false);

            if (recentMsg == null) {
                return;
            }
            if (recentMsg.equals("@list")) {
                out.write(Server.onlineUsers.stream().map(
                        user -> user.username).collect(Collectors.toList()).toString() + "\n");
                out.flush();

            } else if (recentMsg.equals("@quit")) {
                Server.onlineUsers.remove(this);
                in.close();
                out.close();
                userSocket.close();
                System.out.println(username + " quit");

            } else {
                System.out.println(username + ":" + recentMsg + "[" + new Date() + "]");
                flag.set(true);
            }

        } catch (IOException e) {
        }
    }

}

public class Server {
    final static int MAX_USER_NUM = 12;
    final static String PATH="concurrent/chatting/user_password.txt";
    private static Map<String,String> usersMap = new HashMap<>();
    
    static{//静态初始化用户信息
        try {
            usersMap=Files.readAllLines(Paths.get(PATH)).stream().map(line->line.split(" ")).collect(Collectors.toMap(line->line[0],line->line[1]));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     

    static String verify(BufferedReader in, BufferedWriter out) throws IOException {

        if (onlineUsers.size() == MAX_USER_NUM) {// 超过标定容量,返回信号并return
            out.write("人数已满,下次再来\n");
            out.flush();
            return null;
        }
        out.write("请输入用户名\n");
        out.flush();

        String userName = in.readLine();

        while (!usersMap.containsKey(userName)) {
            out.write("此用户名未注册，请重新输入用户名\n");
            out.flush();

            userName = in.readLine();
        }
        final String USER_NAME = userName;
        if (onlineUsers.stream().anyMatch(user -> user.username.equals(USER_NAME))) {
            out.write("你的帐号已登录，请勿重复登录\n");
            out.flush();
            return null;
        }
        out.write("请输入密码\n");
        out.flush();

        String password = in.readLine();
        while (!usersMap.get(userName).equals(password)) {
            out.write("密码错误，请重新输入\n");
            out.flush();

            password = in.readLine();
        }
        out.write("登录成功\n");
        out.flush();

        System.out.println("用户:" + userName + "登录成功" + "[" + new Date() + "]");
        return userName;

    }

    public static void sendMessage(User user, String msg) {

        try {
            user.out.write(user.username + ":" + msg + "[" + new Date() + "]" + "\n");
            user.out.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static List<User> onlineUsers = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws Exception {
        try (
                ServerSocket serverSocket = new ServerSocket(12000);) {
            ExecutorService exec = Executors.newCachedThreadPool();
            System.out.println("Ready to get access");
            exec.execute(() -> {
                while (true) {
                    try {
                        Socket userSocket = serverSocket.accept();
                        exec.execute(() -> {
                            try {
                                BufferedReader in = new BufferedReader(
                                        new InputStreamReader(userSocket.getInputStream()));
                                BufferedWriter out = new BufferedWriter(
                                        new OutputStreamWriter(userSocket.getOutputStream()));
                                String userName;

                                //登录验证
                                if ((userName = verify(in, out)) == null) {
                                    in.close();
                                    out.close();
                                    userSocket.close();
                                    return;
                                }
                                User user = new User(userName, usersMap.get(userName), in, out, userSocket);

                                //加入在线用户列表，开始接收消息
                                onlineUsers.add(user);
                                exec.execute(() -> {
                                    while (true) {
                                        user.recvMsg();
                                    }
                                });
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        });
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

            // 监听输入退出服务器
            exec.execute(() -> {
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();// 输入任意字符退出
                onlineUsers.forEach(user -> {
                    try {
                        user.userSocket.close();
                        user.in.close();
                        user.out.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
                scanner.close();
                exec.shutdownNow();
                System.exit(0);
            });

            // main线程获取并向在线客户发送最新的消息
            while (true) {

                Optional<User> opt = onlineUsers
                        .stream().filter(user -> user.isUpdated()).findAny();

                if (opt.isPresent()) {
                    User recentUser = opt.get();
                    onlineUsers
                            .stream().parallel().filter(user -> !user.equals(recentUser))
                            .forEach(user -> sendMessage(user, recentUser.getRecentMsg()));

                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
