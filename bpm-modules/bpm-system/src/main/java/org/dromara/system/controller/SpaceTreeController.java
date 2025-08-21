package org.dromara.system.controller;

import java.util.List;

import cn.hutool.core.lang.tree.Tree;
import lombok.RequiredArgsConstructor;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.dromara.common.idempotent.annotation.RepeatSubmit;
import org.dromara.common.log.annotation.Log;
import org.dromara.common.web.core.BaseController;
import org.dromara.common.core.domain.R;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.log.enums.BusinessType;
import org.dromara.common.excel.utils.ExcelUtil;
import org.dromara.system.domain.vo.SpaceTreeVo;
import org.dromara.system.domain.bo.SpaceTreeBo;
import org.dromara.system.service.ISpaceTreeService;

/**
 * 空间树结构（工区-楼栋-楼层）
 * 前端访问路由地址为:/system/tree
 *
 * @author sunhaoyue
 * @date 2025-08-20
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/tree")
public class SpaceTreeController extends BaseController {

    private final ISpaceTreeService spaceTreeService;

    /**
     * 查询空间树结构（工区-楼栋-楼层）列表
     */
    @SaCheckPermission("system:tree:list")
    @GetMapping("/list")
    public R<List<SpaceTreeVo>> list(SpaceTreeBo bo) {
        List<SpaceTreeVo> list = spaceTreeService.queryList(bo);
        return R.ok(list);
    }

    /**
     * 导出空间树结构（工区-楼栋-楼层）列表
     */
    @SaCheckPermission("system:tree:export")
    @Log(title = "空间树结构（工区-楼栋-楼层）", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(SpaceTreeBo bo, HttpServletResponse response) {
        List<SpaceTreeVo> list = spaceTreeService.queryList(bo);
        ExcelUtil.exportExcel(list, "空间树结构（工区-楼栋-楼层）", SpaceTreeVo.class, response);
    }

    /**
     * 获取空间树结构（工区-楼栋-楼层）详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:tree:query")
    @GetMapping("/{id}")
    public R<SpaceTreeVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("id") Long id) {
        return R.ok(spaceTreeService.queryById(id));
    }

    /**
     * 获取空间工区树列表
     */
    @SaCheckPermission("system:tree:list")
    @GetMapping("/spaceTree")
    public R<List<Tree<Long>>> deptTree(SpaceTreeBo space) {
        return R.ok(spaceTreeService.selectSpaceTreeList(space));
    }
    /**
     * 新增空间树结构（工区-楼栋-楼层）
     */
    @SaCheckPermission("system:tree:add")
    @Log(title = "空间树结构（工区-楼栋-楼层）", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody SpaceTreeBo bo) {
        return toAjax(spaceTreeService.insertByBo(bo));
    }

    /**
     * 修改空间树结构（工区-楼栋-楼层）
     */
    @SaCheckPermission("system:tree:edit")
    @Log(title = "空间树结构（工区-楼栋-楼层）", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody SpaceTreeBo bo) {
        return toAjax(spaceTreeService.updateByBo(bo));
    }

    /**
     * 删除空间树结构（工区-楼栋-楼层）
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:tree:remove")
    @Log(title = "空间树结构（工区-楼栋-楼层）", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("ids") Long[] ids) {
        return toAjax(spaceTreeService.deleteWithValidByIds(List.of(ids), true));
    }
}
