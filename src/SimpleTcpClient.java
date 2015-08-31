import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/*
 * File Name��SimpleTcpClient.java
 * Copyright��Copyright 2008-2014 CiWong.Inc. All Rights Reserved.
 * Description�� SimpleTcpClient.java
 * Modify By��RES-KUNZHU
 * Modify Date��2014-6-20
 * Modify Type��Add
 */

/**
 * 
 * 
 * @author RES-KUNZHU
 * @version ciwong v.1.0 2014-6-20
 * @since ciwong v.1.0
 */
public class SimpleTcpClient
{
    public static void main(String[] args)
    {
        Socket socket = null;
        try
        {
            InetAddress address = InetAddress.getLocalHost();
            socket = new Socket("127.0.0.1", SimpleTcpServer.PORT);
            OutputStream os = socket.getOutputStream();
            os.write("���".getBytes());
            socket.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                socket.close();
            }
            catch (Exception e2)
            {
                e2.printStackTrace();
            }
        }
    }
}
