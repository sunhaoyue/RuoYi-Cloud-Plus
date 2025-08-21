package org.dromara.system.service;

import org.dromara.system.domain.SpaceTree;
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
