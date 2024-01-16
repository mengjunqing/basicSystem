package com.ruoyi.system.domain.vo;

import com.ruoyi.common.utils.StringUtils;

/**
 * ルーティングディスプレイ情報
 * 
 * @author ruoyi
 */
public class MetaVo
{
    /**
     * サイドバーとパンのふけに表示される名前を設定します
     */
    private String title;

    /**
     * このルーティングのアイコンを設定します，対応するパスsrc/assets/icons/svg
     */
    private String icon;

    /**
     * として設定されtrue，いいえ。 <keep-alive>キャッシュ
     */
    private boolean noCache;

    /**
     * 内部リンクアドレス（http(s)://始まり）
     */
    private String link;

    public MetaVo()
    {
    }

    public MetaVo(String title, String icon)
    {
        this.title = title;
        this.icon = icon;
    }

    public MetaVo(String title, String icon, boolean noCache)
    {
        this.title = title;
        this.icon = icon;
        this.noCache = noCache;
    }

    public MetaVo(String title, String icon, String link)
    {
        this.title = title;
        this.icon = icon;
        this.link = link;
    }

    public MetaVo(String title, String icon, boolean noCache, String link)
    {
        this.title = title;
        this.icon = icon;
        this.noCache = noCache;
        if (StringUtils.ishttp(link))
        {
            this.link = link;
        }
    }

    public boolean isNoCache()
    {
        return noCache;
    }

    public void setNoCache(boolean noCache)
    {
        this.noCache = noCache;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getIcon()
    {
        return icon;
    }

    public void setIcon(String icon)
    {
        this.icon = icon;
    }

    public String getLink()
    {
        return link;
    }

    public void setLink(String link)
    {
        this.link = link;
    }
}
