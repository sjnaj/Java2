
/**
 * @Author: fengsc
 * @Date: 2022-04-10 16:58:25
 * @LastEditTime: 2022-04-10 17:04:14
 */
import java.util.*;
import java.util.stream.*;

public class StreamOfOptionals {
    public static void main(String[] args) {
        Signal.stream()
                .limit(10)
                .forEach(System.out::println);
        Signal.stream()
                .limit(10)
                // .filter(Optional::isPresent)//去除空值
                // .map(Optional::get)//解包
                .flatMap(Optional::stream)//*java9中上面两句可合并为这一句(解包生成流的同时去空)
                .forEach(System.out::println);
    }
}
/*
 * Optional[Signal(dash)]
 * Optional[Signal(dot)]
 * Optional[Signal(dash)]
 * Optional.empty
 * Optional.empty
 * Optional[Signal(dash)]
 * Optional.empty
 * Optional[Signal(dot)]
 * Optional[Signal(dash)]
 * Optional[Signal(dash)]
 * Signal(dot)
 * Signal(dot)
 * Signal(dash)
 * Signal(dash)
 */