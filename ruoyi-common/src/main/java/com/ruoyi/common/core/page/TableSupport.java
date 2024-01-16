package com.ruoyi.common.core.page;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.ServletUtils;

/**
 * テーブルデータ処理
 * 
 * @author ruoyi
 */
public class TableSupport
{
    /**
     * 現在のレコード開始インデックス
     */
    public static final String PAGE_NUM = "pageNum";

    /**
     * ページごとにレコード番号を表示します
     */
    public static final String PAGE_SIZE = "pageSize";

    /**
     * 排出
     */
    public static final String ORDER_BY_COLUMN = "orderByColumn";

    /**
     * ソート "desc" または "asc".
     */
    public static final String IS_ASC = "isAsc";

    /**
     * パグリングパラメーターの合理化
     */
    public static final String REASONABLE = "reasonable";

    /**
     * パッケージングページネーションオブジェクト
     */
    public static PageDomain getPageDomain()
    {
        PageDomain pageDomain = new PageDomain();
        pageDomain.setPageNum(Convert.toInt(ServletUtils.getParameter(PAGE_NUM), 1));
        pageDomain.setPageSize(Convert.toInt(ServletUtils.getParameter(PAGE_SIZE), 10));
        pageDomain.setOrderByColumn(ServletUtils.getParameter(ORDER_BY_COLUMN));
        pageDomain.setIsAsc(ServletUtils.getParameter(IS_ASC));
        pageDomain.setReasonable(ServletUtils.getParameterToBool(REASONABLE));
        return pageDomain;
    }

    public static PageDomain buildPageRequest()
    {
        return getPageDomain();
    }
}
