import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.nio.ByteBuffer;

/*
 * File Name：TcpClient.java
 * Copyright：Copyright 2008-2014 CiWong.Inc. All Rights Reserved.
 * Description： TcpClient.java
 * Modify By：RES-KUNZHU
 * Modify Date：2014-6-20
 * Modify Type：Add
 */

/**
 * 
 * 
 * @author RES-KUNZHU
 * @version ciwong v.1.0 2014-6-20
 * @since ciwong v.1.0
 */
public class TcpClient
{

    /**
     * 消息内容
     */
    public static final String MESSAGE = "PINGPONG";

    /**
     * 缓冲区大小
     */
    public static final int BUFFER_LENGTH = 1024 * 10;

    /**
     * 消息长度
     */
    public static final int MSG_LENGTH = MESSAGE.getBytes().length;

    public static void main(String[] args)
    {
        sendPingpong();
    }

    private static void sendPingpong()
    {
        Socket socket = null;
        try
        {
            byte[] data = MESSAGE.getBytes();
            socket = new Socket("127.0.0.1", 8888);
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            os.write(data);

            byte[] receiveData = new byte[10];
            ByteBuffer bb = ByteBuffer.allocate(BUFFER_LENGTH);
            int totalSize = 0;
            while (true)
            {
                int size = is.read(receiveData, 0, 10);
                if (size == -1)
                {
                    throw new SocketException("connection exception");
                }
                bb.put(receiveData, 0, size);
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
            System.out.println("Client receive msg :" + new String(msg));
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
        Thread.sleep(1000);
    }
}
