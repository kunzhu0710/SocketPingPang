/*
 * File Name��PublicAccountMenu.java
 * Copyright��Copyright 2008-2014 CiWong.Inc. All Rights Reserved.
 * Description�� PublicAccountMenu.java
 * Modify By��RES-KUNZHU
 * Modify Date��2014-7-30
 * Modify Type��Add
 */


import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * ���ںŲ˵�
 * 
 * @author RES-KUNZHU
 * @version ciwong v.1.0 2014-7-30
 * @since ciwong v.1.0
 */
public class PublicAccountMenu implements Serializable
{
    /**
     * TODO field comment
     */
    private static final long serialVersionUID = 8931816744499026755L;

    /**
     * �˵�KEYֵ��������Ϣ�ӿ����ͣ�������128�ֽ�
     */
    private String key;

    /**
     * �˵����⣬������16���ֽڣ��Ӳ˵�������40���ֽ�
     */
    private String name;

    /**
     * �˵�����Ӧ�������ͣ�Ŀǰ��click��view��������
     */
    private String type;

    /**
     * ���ط���
     */
    private String nativeMethod;

    /**
     * ��ҳ���ӣ��û�����˵��ɴ����ӣ�������256�ֽ�
     */
    private String url;

    private List<PublicAccountMenu> subButton;

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getNativeMethod()
    {
        return nativeMethod;
    }

    public void setNativeMethod(String nativeMethod)
    {
        this.nativeMethod = nativeMethod;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public List<PublicAccountMenu> getSubButton()
    {
        return subButton;
    }

    public void setSubButton(List<PublicAccountMenu> subButton)
    {
        this.subButton = subButton;
    }

    /**
     * ����json�ַ�����ȡ���ںŲ˵�
     * 
     * @param str
     *            json�ַ���
     * @return ���ںŲ˵�
     */
    public static List<PublicAccountMenu> getAccountMenuByJsonStr(String str)
    {
        if (str == null)
        {
            return null;
        }
        Gson gson = new Gson();
        Type typeToken = new TypeToken<List<PublicAccountMenu>>()
        {
        }.getType();
        return gson.fromJson(str, typeToken);
    }

    /**
     * ���ںŲ˵�
     * 
     * @author RES-KUNZHU
     * 
     */
    public static class PublicAccountMenuType
    {
        /**
         * ���
         */
        public static final String MENU_TYPE_CLICK = "click";

        /**
         * �����ҳ
         */
        public static final String MENU_TYPE_VIEW = "view";
    }

    /**
     * ���ںŵ��ñ��ط���key
     * 
     * @author RES-KUNZHU
     * 
     */
    public static class PublicAccountNative
    {
        /**
         * ������һ��
         */
        public static final String NATIVI_METHOD_PAIPAI = "paiyipai";
    }

}
