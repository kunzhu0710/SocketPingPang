/*
 * File Name：PublicAccountMenu.java
 * Copyright：Copyright 2008-2014 CiWong.Inc. All Rights Reserved.
 * Description： PublicAccountMenu.java
 * Modify By：RES-KUNZHU
 * Modify Date：2014-7-30
 * Modify Type：Add
 */


import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * 公众号菜单
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
     * 菜单KEY值，用于消息接口推送，不超过128字节
     */
    private String key;

    /**
     * 菜单标题，不超过16个字节，子菜单不超过40个字节
     */
    private String name;

    /**
     * 菜单的响应动作类型，目前有click、view两种类型
     */
    private String type;

    /**
     * 本地方法
     */
    private String nativeMethod;

    /**
     * 网页链接，用户点击菜单可打开链接，不超过256字节
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
     * 根据json字符串获取公众号菜单
     * 
     * @param str
     *            json字符串
     * @return 公众号菜单
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
     * 公众号菜单
     * 
     * @author RES-KUNZHU
     * 
     */
    public static class PublicAccountMenuType
    {
        /**
         * 点击
         */
        public static final String MENU_TYPE_CLICK = "click";

        /**
         * 浏览网页
         */
        public static final String MENU_TYPE_VIEW = "view";
    }

    /**
     * 公众号调用本地方法key
     * 
     * @author RES-KUNZHU
     * 
     */
    public static class PublicAccountNative
    {
        /**
         * 调用拍一拍
         */
        public static final String NATIVI_METHOD_PAIPAI = "paiyipai";
    }

}
