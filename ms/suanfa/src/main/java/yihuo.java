/**
 * 数组实现队列
 */
public class yihuo {
    static class MyQueue{
        int[] arr;
        int pushi;
        int pulli;
        int size;
        final int limit;
        MyQueue(int limit){
            arr = new int[limit];
            pushi=0;
            pulli=0;
            size=0;
            this.limit=limit;

        }
         void push(int value){
            if(size==limit){
                throw new RuntimeException("队列满了,不能再加了");
            }
            size++;
            arr[pushi]=value;
            pushi=nextIndex(pushi);
        }
        int pop(){
            if(size==0){
                throw new RuntimeException("队列空了,不能再拿了");
            }
            size--;
            int ant=arr[pulli];
            pulli=nextIndex(pulli);
            return ant;

        }

        private int nextIndex(int i) {
            return i<limit-1?i+1:0;
        }
    }

    public static void main(String[] args) {
      int[] arr=new int[5];

    }
}
