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
import org.dromara.system.domain.vo.SpaceWorkstationsVo;
import org.dromara.system.domain.bo.SpaceWorkstationsBo;
import org.dromara.system.service.ISpaceWorkstationsService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 工位主
 * 前端访问路由地址为:/system/workstations
 *
 * @author sunhaoyue
 * @date 2025-08-19
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/workstations")
public class SpaceWorkstationsController extends BaseController {

    private final ISpaceWorkstationsService spaceWorkstationsService;

    /**
     * 查询工位主列表
     */
    @SaCheckPermission("system:workstations:list")
    @GetMapping("/list")
    public TableDataInfo<SpaceWorkstationsVo> list(SpaceWorkstationsBo bo, PageQuery pageQuery) {
        return spaceWorkstationsService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出工位主列表
     */
    @SaCheckPermission("system:workstations:export")
    @Log(title = "工位主", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(SpaceWorkstationsBo bo, HttpServletResponse response) {
        List<SpaceWorkstationsVo> list = spaceWorkstationsService.queryList(bo);
        ExcelUtil.exportExcel(list, "工位主", SpaceWorkstationsVo.class, response);
    }

    /**
     * 获取工位主详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:workstations:query")
    @GetMapping("/{id}")
    public R<SpaceWorkstationsVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("id") Long id) {
        return R.ok(spaceWorkstationsService.queryById(id));
    }

    /**
     * 新增工位主
     */
    @SaCheckPermission("system:workstations:add")
    @Log(title = "工位主", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody SpaceWorkstationsBo bo) {
        return toAjax(spaceWorkstationsService.insertByBo(bo));
    }

    /**
     * 修改工位主
     */
    @SaCheckPermission("system:workstations:edit")
    @Log(title = "工位主", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody SpaceWorkstationsBo bo) {
        return toAjax(spaceWorkstationsService.updateByBo(bo));
    }

    /**
     * 删除工位主
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:workstations:remove")
    @Log(title = "工位主", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("ids") Long[] ids) {
        return toAjax(spaceWorkstationsService.deleteWithValidByIds(List.of(ids), true));
    }
}
