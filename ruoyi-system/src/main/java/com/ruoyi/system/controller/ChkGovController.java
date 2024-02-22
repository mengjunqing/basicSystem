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
import com.ruoyi.system.domain.ChkGov;
import com.ruoyi.system.service.IChkGovService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【関数名に記入してください】Controller
 * 
 * @author ruoyi
 * @date 2024-02-22
 */
@RestController
@RequestMapping("/system/gov")
public class ChkGovController extends BaseController
{
    @Autowired
    private IChkGovService chkGovService;

    /**
     * 查询【関数名に記入してください】列表
     */
    @PreAuthorize("@ss.hasPermi('system:gov:list')")
    @GetMapping("/list")
    public TableDataInfo list(ChkGov chkGov)
    {
        startPage();
        List<ChkGov> list = chkGovService.selectChkGovList(chkGov);
        return getDataTable(list);
    }

    /**
     * 导出【関数名に記入してください】列表
     */
    @PreAuthorize("@ss.hasPermi('system:gov:export')")
    @Log(title = "【関数名に記入してください】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ChkGov chkGov)
    {
        List<ChkGov> list = chkGovService.selectChkGovList(chkGov);
        ExcelUtil<ChkGov> util = new ExcelUtil<ChkGov>(ChkGov.class);
        util.exportExcel(response, list, "【関数名に記入してください】数据");
    }

    /**
     * 获取【関数名に記入してください】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:gov:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(chkGovService.selectChkGovById(id));
    }

    /**
     * 新增【関数名に記入してください】
     */
    @PreAuthorize("@ss.hasPermi('system:gov:add')")
    @Log(title = "【関数名に記入してください】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChkGov chkGov)
    {
        return toAjax(chkGovService.insertChkGov(chkGov));
    }

    /**
     * 修改【関数名に記入してください】
     */
    @PreAuthorize("@ss.hasPermi('system:gov:edit')")
    @Log(title = "【関数名に記入してください】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChkGov chkGov)
    {
        return toAjax(chkGovService.updateChkGov(chkGov));
    }

    /**
     * 删除【関数名に記入してください】
     */
    @PreAuthorize("@ss.hasPermi('system:gov:remove')")
    @Log(title = "【関数名に記入してください】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(chkGovService.deleteChkGovByIds(ids));
    }
}
