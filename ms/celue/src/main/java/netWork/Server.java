package netWork;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(8000);
        //等着客户端发来的信息
        Socket accept = ss.accept();
        InputStream inputStream = accept.getInputStream();
    }
}
