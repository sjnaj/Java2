
/**
 * @Author: fengsc
 * @Date: 2022-04-06 10:21:40
 * @LastEditTime: 2022-04-06 13:56:44
 */
import java.util.function.*;

public class Currying {

  static class Sum {

    int sum = 0;

    Sum() {
    }

    Sum(int x) {
      sum = x;
    }
        
    Sum add(int x) {
      return new Sum(sum + x);
    }

    @Override
    public String toString() {
      return sum + "";
    }
  }

  public static void main(String[] args) {
    Sum s = new Sum();
    System.out.println(s.add(1).add(2).add(3));
  }
}
