
/**
 * @Author: fengsc
 * @Date: 2022-04-02 14:10:37
 * @LastEditTime: 2022-04-02 14:13:43
 */
import java.util.*;

public class EnvironmentVariables {
    public static void main(String[] args) {//Map没有实现可迭代接口，通过返回一个entrySet实现迭代，除了map的collection都可迭代
        for (Map.Entry entry : System.getenv().entrySet()) {// 打印所有环境变量
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}