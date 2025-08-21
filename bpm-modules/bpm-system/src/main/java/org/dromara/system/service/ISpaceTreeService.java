package org.dromara.system.service;

import cn.hutool.core.lang.tree.Tree;
import org.dromara.system.domain.vo.SpaceTreeVo;
import org.dromara.system.domain.bo.SpaceTreeBo;

import java.util.Collection;
import java.util.List;

/**
 * 空间树结构（工区-楼栋-楼层）Service接口
 *
 * @author sunhaoyue
 * @date 2025-08-20
 */
public interface ISpaceTreeService {

    /**
     * 查询空间树结构（工区-楼栋-楼层）
     *
     * @param id 主键
     * @return 空间树结构（工区-楼栋-楼层）
     */
    SpaceTreeVo queryById(Long id);


    /**
     * 查询符合条件的空间树结构（工区-楼栋-楼层）列表
     *
     * @param bo 查询条件
     * @return 空间树结构（工区-楼栋-楼层）列表
     */
    List<SpaceTreeVo> queryList(SpaceTreeBo bo);

    /**
     * 查询空间工区树结构信息
     *
     * @param space 空间信息
     * @return 部门树信息集合
     */
    List<Tree<Long>> selectSpaceTreeList(SpaceTreeBo space);

    /**
     * 构建前端所需要下拉树结构
     *
     * @param spaceTrees 空间区域列表
     * @return 下拉树结构列表
     */
    List<Tree<Long>> buildSpaceTreeSelect(List<SpaceTreeVo> spaceTrees);
    /**
     * 新增空间树结构（工区-楼栋-楼层）
     *
     * @param bo 空间树结构（工区-楼栋-楼层）
     * @return 是否新增成功
     */
    Boolean insertByBo(SpaceTreeBo bo);

    /**
     * 修改空间树结构（工区-楼栋-楼层）
     *
     * @param bo 空间树结构（工区-楼栋-楼层）
     * @return 是否修改成功
     */
    Boolean updateByBo(SpaceTreeBo bo);

    /**
     * 校验并批量删除空间树结构（工区-楼栋-楼层）信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
