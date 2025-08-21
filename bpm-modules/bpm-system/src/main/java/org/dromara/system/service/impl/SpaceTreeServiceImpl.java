package org.dromara.system.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import org.dromara.common.core.constant.SystemConstants;
import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dromara.common.core.utils.TreeBuildUtils;
import org.dromara.system.domain.vo.SysDeptVo;
import org.springframework.stereotype.Service;
import org.dromara.system.domain.bo.SpaceTreeBo;
import org.dromara.system.domain.vo.SpaceTreeVo;
import org.dromara.system.domain.SpaceTree;
import org.dromara.system.mapper.SpaceTreeMapper;
import org.dromara.system.service.ISpaceTreeService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 空间树结构（工区-楼栋-楼层）Service业务层处理
 *
 * @author sunhaoyue
 * @date 2025-08-20
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class SpaceTreeServiceImpl implements ISpaceTreeService {

    private final SpaceTreeMapper baseMapper;

    /**
     * 查询空间树结构（工区-楼栋-楼层）
     *
     * @param id 主键
     * @return 空间树结构（工区-楼栋-楼层）
     */
    @Override
    public SpaceTreeVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }


    /**
     * 查询符合条件的空间树结构（工区-楼栋-楼层）列表
     *
     * @param bo 查询条件
     * @return 空间树结构（工区-楼栋-楼层）列表
     */
    @Override
    public List<SpaceTreeVo> queryList(SpaceTreeBo bo) {
        LambdaQueryWrapper<SpaceTree> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    /**
     * 查询空间工区树结构信息
     *
     * @param spaceBo 空间信息
     * @return 部门树信息集合
     */
    @Override
    public List<Tree<Long>> selectSpaceTreeList(SpaceTreeBo spaceBo) {
        LambdaQueryWrapper<SpaceTree> lqw = buildQueryWrapper(spaceBo);
        List<SpaceTreeVo> spaces = baseMapper.selectVoList(lqw);
        return buildSpaceTreeSelect(spaces);
    }

    private LambdaQueryWrapper<SpaceTree> buildQueryWrapper(SpaceTreeBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<SpaceTree> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(SpaceTree::getSort);
        lqw.orderByAsc(SpaceTree::getId);
        lqw.eq(bo.getParentId() != null, SpaceTree::getParentId, bo.getParentId());
        lqw.eq(StringUtils.isNotBlank(bo.getType()), SpaceTree::getType, bo.getType());
        lqw.like(StringUtils.isNotBlank(bo.getName()), SpaceTree::getName, bo.getName());
        lqw.eq(StringUtils.isNotBlank(bo.getCity()), SpaceTree::getCity, bo.getCity());
        lqw.eq(StringUtils.isNotBlank(bo.getAddress()), SpaceTree::getAddress, bo.getAddress());
        lqw.eq(bo.getFloorNumber() != null, SpaceTree::getFloorNumber, bo.getFloorNumber());
        lqw.eq(bo.getSort() != null, SpaceTree::getSort, bo.getSort());

        return lqw;
    }
    /**
     * 构建前端所需要下拉树结构
     *
     * @param spaceTrees 部门列表
     * @return 下拉树结构列表
     */
    @Override
    public List<Tree<Long>> buildSpaceTreeSelect(List<SpaceTreeVo> spaceTrees) {
        if (CollUtil.isEmpty(spaceTrees)) {
            return CollUtil.newArrayList();
        }
        return TreeBuildUtils.buildMultiRoot(
            spaceTrees,
            SpaceTreeVo::getId,
            SpaceTreeVo::getParentId,
            (node, treeNode) -> treeNode
                .setId(node.getId())
                .setParentId(node.getParentId())
                .setName(node.getName())
                .setWeight(node.getSort())
        );
    }
    /**
     * 新增空间树结构（工区-楼栋-楼层）
     *
     * @param bo 空间树结构（工区-楼栋-楼层）
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(SpaceTreeBo bo) {
        SpaceTree add = MapstructUtils.convert(bo, SpaceTree.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改空间树结构（工区-楼栋-楼层）
     *
     * @param bo 空间树结构（工区-楼栋-楼层）
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(SpaceTreeBo bo) {
        SpaceTree update = MapstructUtils.convert(bo, SpaceTree.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(SpaceTree entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除空间树结构（工区-楼栋-楼层）信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteByIds(ids) > 0;
    }
}
