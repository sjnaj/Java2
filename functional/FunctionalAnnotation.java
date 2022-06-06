/**
 * @Author: fengsc
 * @Date: 2022-04-02 22:28:25
 * @LastEditTime: 2022-04-03 08:47:29
 */
@FunctionalInterface//保证只有一个抽象方法
interface Functional{
    String goodBye(String args);
}
interface FunctionNoAnn{
    String goodBye(String args);
}
public class FunctionalAnnotation {
    public String goodBye(String args){
        return "GoodBye, "+args;
    }
    public static void main(String[] args){
        FunctionalAnnotation fa=new FunctionalAnnotation();
        Functional f=fa::goodBye;
        FunctionNoAnn fna=fa::goodBye;
        Functional f1=a->"Goodbye, "+a;
        FunctionNoAnn fna1=a->"Goodbye, "+a;
    }
}
