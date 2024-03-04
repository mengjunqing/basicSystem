package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.ChkServiceInfo;
import com.ruoyi.system.service.IChkServiceInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * service_infoController
 * 
 * @author jc.men
 * @date 2024-03-04
 */
@RestController
@RequestMapping("/system/service/info")
public class ChkServiceInfoController extends BaseController
{
    @Autowired
    private IChkServiceInfoService chkServiceInfoService;

    /**
     * 查询service_info列表
     */
    @PreAuthorize("@ss.hasPermi('system:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(ChkServiceInfo chkServiceInfo)
    {
        startPage();
        List<ChkServiceInfo> list = chkServiceInfoService.selectChkServiceInfoList(chkServiceInfo);
        return getDataTable(list);
    }

    /**
     * 导出service_info列表
     */
    @PreAuthorize("@ss.hasPermi('system:info:export')")
    @Log(title = "service_info", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ChkServiceInfo chkServiceInfo)
    {
        List<ChkServiceInfo> list = chkServiceInfoService.selectChkServiceInfoList(chkServiceInfo);
        ExcelUtil<ChkServiceInfo> util = new ExcelUtil<ChkServiceInfo>(ChkServiceInfo.class);
        util.exportExcel(response, list, "service_info数据");
    }

    /**
     * 获取service_info详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(chkServiceInfoService.selectChkServiceInfoById(id));
    }

    /**
     * 新增service_info
     */
    @PreAuthorize("@ss.hasPermi('system:info:add')")
    @Log(title = "service_info", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChkServiceInfo chkServiceInfo)
    {
        return toAjax(chkServiceInfoService.insertChkServiceInfo(chkServiceInfo));
    }

    /**
     * 修改service_info
     */
    @PreAuthorize("@ss.hasPermi('system:info:edit')")
    @Log(title = "service_info", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChkServiceInfo chkServiceInfo)
    {
        return toAjax(chkServiceInfoService.updateChkServiceInfo(chkServiceInfo));
    }

    /**
     * 删除service_info
     */
    @PreAuthorize("@ss.hasPermi('system:info:remove')")
    @Log(title = "service_info", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(chkServiceInfoService.deleteChkServiceInfoByIds(ids));
    }
}
