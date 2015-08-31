import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class MainCls
{
    public static void main(String[] args)
    {

        String str = "[     {            \"type\":\"click\",          \"name\":\"今日歌曲\",          \"key\":\"V1001_TODAY_MUSIC\"      },      {           \"type\":\"local\",           \"name\":\"我要提问\",           \"key\":\"V1001_TODAY_SINGER\",           \"nativeMethod\":\"paiyipai\"      },      {           \"name\":\"菜单\",           \"subButton\":[           {                   \"type\":\"view\",               \"name\":\"搜索\",               \"url\":\"http://www.soso.com/\"            },            {               \"type\":\"view\",               \"name\":\"视频\",               \"url\":\"http://v.qq.com/\"            },            {               \"type\":\"click\",               \"name\":\"赞一下我们\",               \"key\":\"V1001_GOOD\"            }]       }]";

        str = str.replace("\"", "\\\"")
                .replace("'", "\"")
                .replace("result:", "\"result\":")
                .replace("msg:", "\"msg\":");
        str = str.replace("}{", "},{");
        
        Gson gson = new Gson();
        PublicAccountMenu menu = gson.fromJson(str, PublicAccountMenu.class);
        
//        try
//        {
//            Enumeration<NetworkInterface> networks = NetworkInterface
//                    .getNetworkInterfaces();
//            while (networks.hasMoreElements())
//            {
//                NetworkInterface nk = networks.nextElement();
//                Enumeration<InetAddress> addresses = nk.getInetAddresses();
//                while (addresses.hasMoreElements())
//                {
//                    InetAddress ia = addresses.nextElement();
//                    System.out.println(ia.getHostAddress());
//                }
//            }
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }

    }
}
