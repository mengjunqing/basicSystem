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
import com.ruoyi.system.domain.ChkApplication;
import com.ruoyi.system.service.IChkApplicationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * applicationController
 * 
 * @author jc.men
 * @date 2024-03-04
 */
@RestController
@RequestMapping("/system/application")
public class ChkApplicationController extends BaseController
{
    @Autowired
    private IChkApplicationService chkApplicationService;

    /**
     * 查询application列表
     */
    @PreAuthorize("@ss.hasPermi('system:application:list')")
    @GetMapping("/list")
    public TableDataInfo list(ChkApplication chkApplication)
    {
        startPage();
        List<ChkApplication> list = chkApplicationService.selectChkApplicationList(chkApplication);
        return getDataTable(list);
    }

    /**
     * 导出application列表
     */
    @PreAuthorize("@ss.hasPermi('system:application:export')")
    @Log(title = "application", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ChkApplication chkApplication)
    {
        List<ChkApplication> list = chkApplicationService.selectChkApplicationList(chkApplication);
        ExcelUtil<ChkApplication> util = new ExcelUtil<ChkApplication>(ChkApplication.class);
        util.exportExcel(response, list, "application数据");
    }

    /**
     * 获取application详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:application:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(chkApplicationService.selectChkApplicationById(id));
    }

    /**
     * 新增application
     */
    @PreAuthorize("@ss.hasPermi('system:application:add')")
    @Log(title = "application", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChkApplication chkApplication)
    {
        return toAjax(chkApplicationService.insertChkApplication(chkApplication));
    }

    /**
     * 修改application
     */
    @PreAuthorize("@ss.hasPermi('system:application:edit')")
    @Log(title = "application", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChkApplication chkApplication)
    {
        return toAjax(chkApplicationService.updateChkApplication(chkApplication));
    }

    /**
     * 删除application
     */
    @PreAuthorize("@ss.hasPermi('system:application:remove')")
    @Log(title = "application", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(chkApplicationService.deleteChkApplicationByIds(ids));
    }
}
