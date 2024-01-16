package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 操作ログレコードテーブル oper_log
 * 
 * @author ruoyi
 */
public class SysOperLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ログプライマリキー */
    @Excel(name = "操作シリアル番号", cellType = ColumnType.NUMERIC)
    private Long operId;

    /** 動作モジュール */
    @Excel(name = "動作モジュール")
    private String title;

    /** 事業の種類（0他の 1増加 2改訂 3消去） */
    @Excel(name = "事業の種類", readConverterExp = "0=他の,1=増加,2=改訂,3=消去,4=ライセンス,5=出力,6=入力,7=力,8=コードを生成します,9=データをクリアします")
    private Integer businessType;

    /** 事業の種類数组 */
    private Integer[] businessTypes;

    /** 要求の方法 */
    @Excel(name = "要求の方法")
    private String method;

    /** リクエスト方法 */
    @Excel(name = "リクエスト方法")
    private String requestMethod;

    /** 操作カテゴリ（0他の 1バックグラウンドユーザー 2携帯電話ユーザー） */
    @Excel(name = "操作カテゴリ", readConverterExp = "0=他の,1=バックグラウンドユーザー,2=携帯電話ユーザー")
    private Integer operatorType;

    /** オペレーター */
    @Excel(name = "オペレーター")
    private String operName;

    /** 部署名 */
    @Excel(name = "部署名")
    private String deptName;

    /** 聞くurl */
    @Excel(name = "聞く地址")
    private String operUrl;

    /** 操作アドレス */
    @Excel(name = "操作アドレス")
    private String operIp;

    /** 場所 */
    @Excel(name = "場所")
    private String operLocation;

    /** 聞く参数 */
    @Excel(name = "聞く参数")
    private String operParam;

    /** パラメーターを返します */
    @Excel(name = "パラメーターを返します")
    private String jsonResult;

    /** 操作ステータス（0普通 1異常な） */
    @Excel(name = "州", readConverterExp = "0=普通,1=異常な")
    private Integer status;

    /** 間違った情報 */
    @Excel(name = "間違った情報")
    private String errorMsg;

    /** 稼働時間 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "稼働時間", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date operTime;

    /** 消費 */
    @Excel(name = "消費", suffix = "ミリ秒")
    private Long costTime;

    public Long getOperId()
    {
        return operId;
    }

    public void setOperId(Long operId)
    {
        this.operId = operId;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Integer getBusinessType()
    {
        return businessType;
    }

    public void setBusinessType(Integer businessType)
    {
        this.businessType = businessType;
    }

    public Integer[] getBusinessTypes()
    {
        return businessTypes;
    }

    public void setBusinessTypes(Integer[] businessTypes)
    {
        this.businessTypes = businessTypes;
    }

    public String getMethod()
    {
        return method;
    }

    public void setMethod(String method)
    {
        this.method = method;
    }

    public String getRequestMethod()
    {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod)
    {
        this.requestMethod = requestMethod;
    }

    public Integer getOperatorType()
    {
        return operatorType;
    }

    public void setOperatorType(Integer operatorType)
    {
        this.operatorType = operatorType;
    }

    public String getOperName()
    {
        return operName;
    }

    public void setOperName(String operName)
    {
        this.operName = operName;
    }

    public String getDeptName()
    {
        return deptName;
    }

    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
    }

    public String getOperUrl()
    {
        return operUrl;
    }

    public void setOperUrl(String operUrl)
    {
        this.operUrl = operUrl;
    }

    public String getOperIp()
    {
        return operIp;
    }

    public void setOperIp(String operIp)
    {
        this.operIp = operIp;
    }

    public String getOperLocation()
    {
        return operLocation;
    }

    public void setOperLocation(String operLocation)
    {
        this.operLocation = operLocation;
    }

    public String getOperParam()
    {
        return operParam;
    }

    public void setOperParam(String operParam)
    {
        this.operParam = operParam;
    }

    public String getJsonResult()
    {
        return jsonResult;
    }

    public void setJsonResult(String jsonResult)
    {
        this.jsonResult = jsonResult;
    }

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public String getErrorMsg()
    {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg)
    {
        this.errorMsg = errorMsg;
    }

    public Date getOperTime()
    {
        return operTime;
    }

    public void setOperTime(Date operTime)
    {
        this.operTime = operTime;
    }

    public Long getCostTime()
    {
        return costTime;
    }

    public void setCostTime(Long costTime)
    {
        this.costTime = costTime;
    }
}
