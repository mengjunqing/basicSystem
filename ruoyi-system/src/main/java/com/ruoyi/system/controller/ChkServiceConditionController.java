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
import com.ruoyi.system.domain.ChkServiceCondition;
import com.ruoyi.system.service.IChkServiceConditionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * service_conditionController
 * 
 * @author jc.men
 * @date 2024-03-04
 */
@RestController
@RequestMapping("/system/service/condition")
public class ChkServiceConditionController extends BaseController
{
    @Autowired
    private IChkServiceConditionService chkServiceConditionService;

    /**
     * 查询service_condition列表
     */
    @PreAuthorize("@ss.hasPermi('system:condition:list')")
    @GetMapping("/list")
    public TableDataInfo list(ChkServiceCondition chkServiceCondition)
    {
        startPage();
        List<ChkServiceCondition> list = chkServiceConditionService.selectChkServiceConditionList(chkServiceCondition);
        return getDataTable(list);
    }

    /**
     * 导出service_condition列表
     */
    @PreAuthorize("@ss.hasPermi('system:condition:export')")
    @Log(title = "service_condition", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ChkServiceCondition chkServiceCondition)
    {
        List<ChkServiceCondition> list = chkServiceConditionService.selectChkServiceConditionList(chkServiceCondition);
        ExcelUtil<ChkServiceCondition> util = new ExcelUtil<ChkServiceCondition>(ChkServiceCondition.class);
        util.exportExcel(response, list, "service_condition数据");
    }

    /**
     * 获取service_condition详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:condition:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(chkServiceConditionService.selectChkServiceConditionById(id));
    }

    /**
     * 新增service_condition
     */
    @PreAuthorize("@ss.hasPermi('system:condition:add')")
    @Log(title = "service_condition", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChkServiceCondition chkServiceCondition)
    {
        return toAjax(chkServiceConditionService.insertChkServiceCondition(chkServiceCondition));
    }

    /**
     * 修改service_condition
     */
    @PreAuthorize("@ss.hasPermi('system:condition:edit')")
    @Log(title = "service_condition", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChkServiceCondition chkServiceCondition)
    {
        return toAjax(chkServiceConditionService.updateChkServiceCondition(chkServiceCondition));
    }

    /**
     * 删除service_condition
     */
    @PreAuthorize("@ss.hasPermi('system:condition:remove')")
    @Log(title = "service_condition", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(chkServiceConditionService.deleteChkServiceConditionByIds(ids));
    }
}
