import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.nio.ByteBuffer;


public class TcpServer
{

    public static void main(String[] args)
    {
        ServerSocket ss = null;
        try
        {
            ss = new ServerSocket(8888);
            while (true)
            {
                Socket socket = ss.accept();
                new AcceptThread(socket).start();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            
        }

    }

    private static class AcceptThread extends Thread
    {
        private Socket socket;

        public AcceptThread(Socket sk)
        {
            socket = sk;
        }

        @Override
        public void run()
        {
            try
            {
                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();
                byte[] datas = new byte[1024];
                ByteBuffer bb = ByteBuffer.allocate(TcpClient.BUFFER_LENGTH);
                int totalSize = 0;
                while (true)
                {
                    int size = is.read(datas, 0, 1024);
                    if (size == -1)
                    {
                        throw new SocketException("connection exception");
                    }
                    bb.put(datas, 0, size);
                    totalSize += size;
                    boolean readSuccess = readMsg(bb, totalSize);
                    if (readSuccess)
                    {
                        handMsg(os);
                        totalSize -= TcpClient.MSG_LENGTH;
                    }
                }
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

        /**
         * 读取消息
         * 
         * @param bb
         *            消息流
         */
        private static boolean readMsg(ByteBuffer bb, int totalSize)
        {
            if (totalSize >= TcpClient.MSG_LENGTH)
            {
                bb.flip();
                byte[] msg = new byte[TcpClient.MSG_LENGTH];
                bb.get(msg);
                System.out.println("Server receive msg :" + new String(msg));
                bb.flip();
                return true;
            }
            return false;
        }

        /**
         * 处理消息
         * 
         * @param os
         *            输出流
         * @throws Exception
         *             异常
         */
        private static void handMsg(OutputStream os) throws Exception
        {

            os.write(TcpClient.MESSAGE.getBytes());
        }
    }

}
