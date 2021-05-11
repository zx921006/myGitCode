package netWork;


import java.util.LinkedList;
import java.util.List;

public class Client {
    public static void main(String[] args){
        List<byte[]> list =  new LinkedList<>();
        for(;;){
            byte[] b =new byte[1024*1024];
            list.add(b);
        }
    }
}
