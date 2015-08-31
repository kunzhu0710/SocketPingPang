import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * File Name：SimpleTcpServer.java
 * Copyright：Copyright 2008-2014 CiWong.Inc. All Rights Reserved.
 * Description： SimpleTcpServer.java
 * Modify By：RES-KUNZHU
 * Modify Date：2014-6-20
 * Modify Type：Add
 */

/**
 * 
 * @author RES-KUNZHU
 * @version ciwong v.1.0 2014-6-20
 * @since ciwong v.1.0
 */
public class SimpleTcpServer
{
    public static final int PORT = 8888;

    public static void main(String[] args)
    {
        try
        {
            //建立服务
            ServerSocket ss = new ServerSocket(PORT);
            
            //接受
            Socket socket = ss.accept();
            InputStream is = socket.getInputStream();
            
            
            byte[] datas = new byte[1];
            int size = is.read(datas);
            System.out.println(new String(datas));
            socket.close();
            ss.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
