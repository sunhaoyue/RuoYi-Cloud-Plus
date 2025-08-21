package org.dromara.system.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.dromara.common.idempotent.annotation.RepeatSubmit;
import org.dromara.common.log.annotation.Log;
import org.dromara.common.web.core.BaseController;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.core.domain.R;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.log.enums.BusinessType;
import org.dromara.common.excel.utils.ExcelUtil;
import org.dromara.system.domain.vo.SpaceWorkstationUsageVo;
import org.dromara.system.domain.bo.SpaceWorkstationUsageBo;
import org.dromara.system.service.ISpaceWorkstationUsageService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 工位使用记录
 * 前端访问路由地址为:/system/workstationUsage
 *
 * @author sunhaoyue
 * @date 2025-08-21
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/workstationUsage")
public class SpaceWorkstationUsageController extends BaseController {

    private final ISpaceWorkstationUsageService spaceWorkstationUsageService;

    /**
     * 查询工位使用记录列表
     */
    @SaCheckPermission("system:workstationUsage:list")
    @GetMapping("/list")
    public TableDataInfo<SpaceWorkstationUsageVo> list(SpaceWorkstationUsageBo bo, PageQuery pageQuery) {
        return spaceWorkstationUsageService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出工位使用记录列表
     */
    @SaCheckPermission("system:workstationUsage:export")
    @Log(title = "工位使用记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(SpaceWorkstationUsageBo bo, HttpServletResponse response) {
        List<SpaceWorkstationUsageVo> list = spaceWorkstationUsageService.queryList(bo);
        ExcelUtil.exportExcel(list, "工位使用记录", SpaceWorkstationUsageVo.class, response);
    }

    /**
     * 获取工位使用记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:workstationUsage:query")
    @GetMapping("/{id}")
    public R<SpaceWorkstationUsageVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("id") Long id) {
        return R.ok(spaceWorkstationUsageService.queryById(id));
    }

    /**
     * 新增工位使用记录
     */
    @SaCheckPermission("system:workstationUsage:add")
    @Log(title = "工位使用记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody SpaceWorkstationUsageBo bo) {
        return toAjax(spaceWorkstationUsageService.insertByBo(bo));
    }

    /**
     * 修改工位使用记录
     */
    @SaCheckPermission("system:workstationUsage:edit")
    @Log(title = "工位使用记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody SpaceWorkstationUsageBo bo) {
        return toAjax(spaceWorkstationUsageService.updateByBo(bo));
    }

    /**
     * 删除工位使用记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:workstationUsage:remove")
    @Log(title = "工位使用记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("ids") Long[] ids) {
        return toAjax(spaceWorkstationUsageService.deleteWithValidByIds(List.of(ids), true));
    }
}
