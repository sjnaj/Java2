
/**
 * @Author: fengsc
 * @Date: 2022-04-10 22:27:50
 * @LastEditTime: 2022-04-11 05:35:11
 */
import java.util.stream.*;

public class NumericStreamInfo {
    public static void main(String[] args) {
        System.out.println(RandInts.rands().average().getAsDouble());
        System.out.println(RandInts.rands().max().getAsInt());
        System.out.println(RandInts.rands().min().getAsInt());
        // 后面两个不用解包
        System.out.println(RandInts.rands().sum());
        System.out.println(RandInts.rands().summaryStatistics());
        Byte i=0xf,j=0xf;
        System.out.println(Long.toHexString((i&0xff)<<8|(j&0xff)));
    }
}
/*
 * 52.17
 * 99
 * 1
 * 5217
 * IntSummaryStatistics{count=100, sum=5217, min=1, average=52.170000, max=99}
 */