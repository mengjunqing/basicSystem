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
import com.ruoyi.system.domain.ChkService;
import com.ruoyi.system.service.IChkServiceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * serviceController
 * 
 * @author jc.men
 * @date 2024-03-04
 */
@RestController
@RequestMapping("/system/service")
public class ChkServiceController extends BaseController
{
    @Autowired
    private IChkServiceService chkServiceService;

    /**
     * 查询service列表
     */
    @PreAuthorize("@ss.hasPermi('system:service:list')")
    @GetMapping("/list")
    public TableDataInfo list(ChkService chkService)
    {
        startPage();
        List<ChkService> list = chkServiceService.selectChkServiceList(chkService);
        return getDataTable(list);
    }

    /**
     * 导出service列表
     */
    @PreAuthorize("@ss.hasPermi('system:service:export')")
    @Log(title = "service", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ChkService chkService)
    {
        List<ChkService> list = chkServiceService.selectChkServiceList(chkService);
        ExcelUtil<ChkService> util = new ExcelUtil<ChkService>(ChkService.class);
        util.exportExcel(response, list, "service数据");
    }

    /**
     * 获取service详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:service:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(chkServiceService.selectChkServiceById(id));
    }

    /**
     * 新增service
     */
    @PreAuthorize("@ss.hasPermi('system:service:add')")
    @Log(title = "service", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChkService chkService)
    {
        return toAjax(chkServiceService.insertChkService(chkService));
    }

    /**
     * 修改service
     */
    @PreAuthorize("@ss.hasPermi('system:service:edit')")
    @Log(title = "service", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChkService chkService)
    {
        return toAjax(chkServiceService.updateChkService(chkService));
    }

    /**
     * 删除service
     */
    @PreAuthorize("@ss.hasPermi('system:service:remove')")
    @Log(title = "service", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(chkServiceService.deleteChkServiceByIds(ids));
    }
}
