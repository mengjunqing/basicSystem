package com.ruoyi.common.core.page;

import java.io.Serializable;
import java.util.List;

/**
 * ページングデータオブジェクトを形成します
 * 
 * @author ruoyi
 */
public class TableDataInfo implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 合計 */
    private long total;

    /** データをリストします */
    private List<?> rows;

    /** メッセージステータスコード */
    private int code;

    /** メッセージコンテンツ */
    private String msg;

    /**
     * テーブルデータオブジェクト
     */
    public TableDataInfo()
    {
    }

    /**
     * ページネーション
     * 
     * @param list データをリストします
     * @param total 合計
     */
    public TableDataInfo(List<?> list, int total)
    {
        this.rows = list;
        this.total = total;
    }

    public long getTotal()
    {
        return total;
    }

    public void setTotal(long total)
    {
        this.total = total;
    }

    public List<?> getRows()
    {
        return rows;
    }

    public void setRows(List<?> rows)
    {
        this.rows = rows;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }
}
