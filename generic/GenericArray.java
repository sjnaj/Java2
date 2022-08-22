
/**
 * @Author: fengsc
 * @Date: 2022-08-09 08:29:40
 * @LastEditTime: 2022-08-09 08:43:40
 */
public class GenericArray<T> {
    private T[] array;
    @SuppressWarnings("unchecked")
    public GenericArray(int sz){
        array=(T[]) new Object[sz];
    }
    public void put(int index,T item) {
        array[index] = item;
    }
    public T get(int index){
        return array[index];
    }
    public T[] rep(){
        return array;
    }
    public static void main(String[] args){
        GenericArray<Integer> gai=new GenericArray<>(10);
        try{
            Integer[] ia=(Integer[])gai.rep();//class [Ljava.lang.Object; cannot be cast to class [Ljava.lang.Integer;
        }catch(ClassCastException e){
            System.out.println(e.getMessage());
        }
        Object[] oa=gai.rep();
    }

}