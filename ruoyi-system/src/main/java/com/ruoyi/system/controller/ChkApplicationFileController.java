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
import com.ruoyi.system.domain.ChkApplicationFile;
import com.ruoyi.system.service.IChkApplicationFileService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * application_fileController
 * 
 * @author jc.men
 * @date 2024-03-04
 */
@RestController
@RequestMapping("/system/application/file")
public class ChkApplicationFileController extends BaseController
{
    @Autowired
    private IChkApplicationFileService chkApplicationFileService;

    /**
     * 查询application_file列表
     */
    @PreAuthorize("@ss.hasPermi('system:file:list')")
    @GetMapping("/list")
    public TableDataInfo list(ChkApplicationFile chkApplicationFile)
    {
        startPage();
        List<ChkApplicationFile> list = chkApplicationFileService.selectChkApplicationFileList(chkApplicationFile);
        return getDataTable(list);
    }

    /**
     * 导出application_file列表
     */
    @PreAuthorize("@ss.hasPermi('system:file:export')")
    @Log(title = "application_file", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ChkApplicationFile chkApplicationFile)
    {
        List<ChkApplicationFile> list = chkApplicationFileService.selectChkApplicationFileList(chkApplicationFile);
        ExcelUtil<ChkApplicationFile> util = new ExcelUtil<ChkApplicationFile>(ChkApplicationFile.class);
        util.exportExcel(response, list, "application_file数据");
    }

    /**
     * 获取application_file详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:file:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(chkApplicationFileService.selectChkApplicationFileById(id));
    }

    /**
     * 新增application_file
     */
    @PreAuthorize("@ss.hasPermi('system:file:add')")
    @Log(title = "application_file", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChkApplicationFile chkApplicationFile)
    {
        return toAjax(chkApplicationFileService.insertChkApplicationFile(chkApplicationFile));
    }

    /**
     * 修改application_file
     */
    @PreAuthorize("@ss.hasPermi('system:file:edit')")
    @Log(title = "application_file", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChkApplicationFile chkApplicationFile)
    {
        return toAjax(chkApplicationFileService.updateChkApplicationFile(chkApplicationFile));
    }

    /**
     * 删除application_file
     */
    @PreAuthorize("@ss.hasPermi('system:file:remove')")
    @Log(title = "application_file", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(chkApplicationFileService.deleteChkApplicationFileByIds(ids));
    }
}
