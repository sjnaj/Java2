
/**
 * @Author: fengsc
 * @Date: 2022-04-10 12:18:41
 * @LastEditTime: 2022-04-10 12:21:45
 */
import java.util.stream.*;

public class StreamOfStreams {
    public static void main(String[] args) {
        Stream.of(1, 2, 3)
                .map(i -> Stream.of("Gonzo", "Kermit", "Beaker"))
                .forEach(System.out::println);
    }
}
// java.util.stream.ReferencePipeline$Head@2f0e140b
// java.util.stream.ReferencePipeline$Head@7440e464
// java.util.stream.ReferencePipeline$Head@49476842