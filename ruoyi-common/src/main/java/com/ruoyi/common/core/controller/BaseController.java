package com.ruoyi.common.core.controller;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.page.PageDomain;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.page.TableSupport;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.PageUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.sql.SqlUtil;

/**
 * webレイヤーシップデータ処理
 * 
 * @author ruoyi
 */
public class BaseController
{
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * フロントデスクを通過した日付形式の文字列，に自動的に変換されますDateタイプ
     */
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        // Date タイプ转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport()
        {
            @Override
            public void setAsText(String text)
            {
                setValue(DateUtils.parseDate(text));
            }
        });
    }

    /**
     * リクエストページネーションデータを設定します
     */
    protected void startPage()
    {
        PageUtils.startPage();
    }

    /**
     * リクエストソートデータを設定します
     */
    protected void startOrderBy()
    {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        if (StringUtils.isNotEmpty(pageDomain.getOrderBy()))
        {
            String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
            PageHelper.orderBy(orderBy);
        }
    }

    /**
     * ページングスレッド変数を清掃します
     */
    protected void clearPage()
    {
        PageUtils.clearPage();
    }

    /**
     * 応答要求ページングデータ
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected TableDataInfo getDataTable(List<?> list)
    {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(HttpStatus.SUCCESS);
        rspData.setMsg("成功して検索します");
        rspData.setRows(list);
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }

    /**
     * 成功に戻ります
     */
    public AjaxResult success()
    {
        return AjaxResult.success();
    }

    /**
     * 失敗に戻ります
     */
    public AjaxResult error()
    {
        return AjaxResult.error();
    }

    /**
     * 成功に戻ります消息
     */
    public AjaxResult success(String message)
    {
        return AjaxResult.success(message);
    }
    
    /**
     * 成功に戻ります消息
     */
    public AjaxResult success(Object data)
    {
        return AjaxResult.success(data);
    }

    /**
     * 失敗に戻ります
     */
    public AjaxResult error(String message)
    {
        return AjaxResult.error(message);
    }

    /**
     * 警告メッセージに戻ります
     */
    public AjaxResult warn(String message)
    {
        return AjaxResult.warn(message);
    }

    /**
     * 応答リターン結果
     * 
     * @param rows 影響力に影響します
     * @return 操作結果
     */
    protected AjaxResult toAjax(int rows)
    {
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 応答リターン結果
     * 
     * @param result 結果
     * @return 操作結果
     */
    protected AjaxResult toAjax(boolean result)
    {
        return result ? success() : error();
    }

    /**
     * ページジャンプ
     */
    public String redirect(String url)
    {
        return StringUtils.format("redirect:{}", url);
    }

    /**
     * ユーザーキャッシュ情報を取得します
     */
    public LoginUser getLoginUser()
    {
        return SecurityUtils.getLoginUser();
    }

    /**
     * ログインユーザーを取得しますid
     */
    public Long getUserId()
    {
        return getLoginUser().getUserId();
    }

    /**
     * ログイン部門を取得しますid
     */
    public Long getDeptId()
    {
        return getLoginUser().getDeptId();
    }

    /**
     * ログインユーザーを取得します名
     */
    public String getUsername()
    {
        return getLoginUser().getUsername();
    }
}
