
/**
 * @Author: fengsc
 * @Date: 2022-04-10 12:58:13
 * @LastEditTime: 2022-04-10 13:01:28
 */

public class FileToWordsTest {
    public static void main(String[] args) throws Exception {
        FileToWords.stream("/home/fengsc/Desktop/Java2/stream/chess.dat")
                .limit(7)
                .forEach(s -> System.out.format("%s ", s));
        System.out.println();
        FileToWords.stream("/home/fengsc/Desktop/Java2/stream/chess.dat")
                .skip(7)
                .limit(2)
                .forEach(s -> System.out.format("%s ", s));
    }

}
// Not much of a cheese shop really 
// is it 
