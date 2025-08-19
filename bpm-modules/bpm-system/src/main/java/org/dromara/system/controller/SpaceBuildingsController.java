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
import org.dromara.system.domain.vo.SpaceBuildingsVo;
import org.dromara.system.domain.bo.SpaceBuildingsBo;
import org.dromara.system.service.ISpaceBuildingsService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 楼栋信息
 * 前端访问路由地址为:/system/buildings
 *
 * @author sunhaoyue
 * @date 2025-08-19
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/buildings")
public class SpaceBuildingsController extends BaseController {

    private final ISpaceBuildingsService spaceBuildingsService;

    /**
     * 查询楼栋信息列表
     */
    @SaCheckPermission("system:buildings:list")
    @GetMapping("/list")
    public TableDataInfo<SpaceBuildingsVo> list(SpaceBuildingsBo bo, PageQuery pageQuery) {
        return spaceBuildingsService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出楼栋信息列表
     */
    @SaCheckPermission("system:buildings:export")
    @Log(title = "楼栋信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(SpaceBuildingsBo bo, HttpServletResponse response) {
        List<SpaceBuildingsVo> list = spaceBuildingsService.queryList(bo);
        ExcelUtil.exportExcel(list, "楼栋信息", SpaceBuildingsVo.class, response);
    }

    /**
     * 获取楼栋信息详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:buildings:query")
    @GetMapping("/{id}")
    public R<SpaceBuildingsVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("id") Long id) {
        return R.ok(spaceBuildingsService.queryById(id));
    }

    /**
     * 新增楼栋信息
     */
    @SaCheckPermission("system:buildings:add")
    @Log(title = "楼栋信息", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody SpaceBuildingsBo bo) {
        return toAjax(spaceBuildingsService.insertByBo(bo));
    }

    /**
     * 修改楼栋信息
     */
    @SaCheckPermission("system:buildings:edit")
    @Log(title = "楼栋信息", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody SpaceBuildingsBo bo) {
        return toAjax(spaceBuildingsService.updateByBo(bo));
    }

    /**
     * 删除楼栋信息
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:buildings:remove")
    @Log(title = "楼栋信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("ids") Long[] ids) {
        return toAjax(spaceBuildingsService.deleteWithValidByIds(List.of(ids), true));
    }
}
