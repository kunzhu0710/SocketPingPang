import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/*
 * File Name£ºSimpleTcpClient.java
 * Copyright£ºCopyright 2008-2014 CiWong.Inc. All Rights Reserved.
 * Description£º SimpleTcpClient.java
 * Modify By£ºRES-KUNZHU
 * Modify Date£º2014-6-20
 * Modify Type£ºAdd
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
            os.write("ÄãºÃ".getBytes());
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
