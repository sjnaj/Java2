
/**
 * @Author: fengsc
 * @Date: 2022-04-07 09:51:33
 * @LastEditTime: 2022-04-07 10:00:00
 */
import java.util.*;
import java.util.stream.*;

public class RandomGenerator {
    public static <T> void show(Stream<T> stream) {
        stream
                .limit(4)
                .forEach(System.out::println);
        System.out.println("++++++++++++++++");
    }

    public static void main(String[] args) {
        Random rand = new Random(47);

        show(rand.ints().boxed());//装箱为对象使得能被流接收
        show(rand.longs().boxed());
        show(rand.doubles().boxed());

        show(rand.ints(10, 20).boxed());//限制上下限
        show(rand.longs(50, 100).boxed());
        show(rand.doubles(20, 30).boxed());

        show(rand.ints(3).boxed());//限制数量
        show(rand.longs(3).boxed());
        show(rand.doubles(3).boxed());

        show(rand.ints(3, 10, 20).boxed());
        show(rand.longs(3, 10, 20).boxed());
        show(rand.doubles(3, 10, 20).boxed());

    }
}
/*-1172028779
1717241110
-2014573909
229403722
++++++++++++++++
2955289354441303771
3476817843704654257
-8917117694134521474
4941259272818818752
++++++++++++++++
0.2613610344283964
0.0508673570556899
0.8037155449603999
0.7620665811558285
++++++++++++++++
16
10
11
12
++++++++++++++++
65
99
54
58
++++++++++++++++
29.86777681078574
24.83968447804611
20.09247112332014
24.046793846338723
++++++++++++++++
1169976606
1947946283
691554276
++++++++++++++++
-4313673043051624580
8249504221436716963
1208921558810358757
++++++++++++++++
0.7775491010186331
0.5131426094910703
0.7591309941379213
++++++++++++++++
14
16
12
++++++++++++++++
13
16
19
++++++++++++++++
14.281271203182389
19.09606498840713
12.121296591277185
++++++++++++++++*/