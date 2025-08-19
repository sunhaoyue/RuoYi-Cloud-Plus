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
import org.dromara.system.domain.vo.SpaceZonesVo;
import org.dromara.system.domain.bo.SpaceZonesBo;
import org.dromara.system.service.ISpaceZonesService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 城市工区信息
 * 前端访问路由地址为:/system/zones
 *
 * @author sunhaoyue
 * @date 2025-08-19
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/zones")
public class SpaceZonesController extends BaseController {

    private final ISpaceZonesService spaceZonesService;

    /**
     * 查询城市工区信息列表
     */
    @SaCheckPermission("system:zones:list")
    @GetMapping("/list")
    public TableDataInfo<SpaceZonesVo> list(SpaceZonesBo bo, PageQuery pageQuery) {
        return spaceZonesService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出城市工区信息列表
     */
    @SaCheckPermission("system:zones:export")
    @Log(title = "城市工区信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(SpaceZonesBo bo, HttpServletResponse response) {
        List<SpaceZonesVo> list = spaceZonesService.queryList(bo);
        ExcelUtil.exportExcel(list, "城市工区信息", SpaceZonesVo.class, response);
    }

    /**
     * 获取城市工区信息详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:zones:query")
    @GetMapping("/{id}")
    public R<SpaceZonesVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("id") Long id) {
        return R.ok(spaceZonesService.queryById(id));
    }

    /**
     * 新增城市工区信息
     */
    @SaCheckPermission("system:zones:add")
    @Log(title = "城市工区信息", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody SpaceZonesBo bo) {
        return toAjax(spaceZonesService.insertByBo(bo));
    }

    /**
     * 修改城市工区信息
     */
    @SaCheckPermission("system:zones:edit")
    @Log(title = "城市工区信息", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody SpaceZonesBo bo) {
        return toAjax(spaceZonesService.updateByBo(bo));
    }

    /**
     * 删除城市工区信息
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:zones:remove")
    @Log(title = "城市工区信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("ids") Long[] ids) {
        return toAjax(spaceZonesService.deleteWithValidByIds(List.of(ids), true));
    }
}
