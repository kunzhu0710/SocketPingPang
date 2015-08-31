import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;


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
