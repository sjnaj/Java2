/**
 * @Author: fengsc
 * @Date: 2022-06-06 20:00:32
 * @LastEditTime: 2022-06-08 18:38:02
 */
package chatting;

import java.net.*;
import java.io.*;

public class UserClient {
    public static void main(String[] args) throws Exception {
        String serverName = InetAddress.getLocalHost().getHostAddress();
        int serverPort = 12000;

        try (Socket clientSocket = new Socket(serverName, serverPort);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));) {

            String question;
            try {
                while (!(question = in.readLine()).equals("登录成功")) {
                    System.out.println(question);
                    out.write(input.readLine() + '\n');
                    out.flush();
                }
                System.out.println(question);

            } catch (Exception e) {
                System.exit(-1);
            }

            //开启线程接收并输出服务器消息
            new Thread(() -> {

                while (true) {
                    try {

                        String msg = in.readLine();
                        if (msg == null) {
                            System.exit(0);
                        }
                        System.out.println(msg);

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();
            //main线程发送消息
            while (true) {
                String msg = input.readLine();

                out.write(msg + "\n");
                out.flush();

            }

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
