package org.dromara.system.service.impl;

import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.dromara.system.domain.bo.SpaceBuildingsBo;
import org.dromara.system.domain.vo.SpaceBuildingsVo;
import org.dromara.system.domain.SpaceBuildings;
import org.dromara.system.mapper.SpaceBuildingsMapper;
import org.dromara.system.service.ISpaceBuildingsService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 楼栋信息Service业务层处理
 *
 * @author sunhaoyue
 * @date 2025-08-19
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class SpaceBuildingsServiceImpl implements ISpaceBuildingsService {

    private final SpaceBuildingsMapper baseMapper;

    /**
     * 查询楼栋信息
     *
     * @param id 主键
     * @return 楼栋信息
     */
    @Override
    public SpaceBuildingsVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询楼栋信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 楼栋信息分页列表
     */
    @Override
    public TableDataInfo<SpaceBuildingsVo> queryPageList(SpaceBuildingsBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<SpaceBuildings> lqw = buildQueryWrapper(bo);
        Page<SpaceBuildingsVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的楼栋信息列表
     *
     * @param bo 查询条件
     * @return 楼栋信息列表
     */
    @Override
    public List<SpaceBuildingsVo> queryList(SpaceBuildingsBo bo) {
        LambdaQueryWrapper<SpaceBuildings> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<SpaceBuildings> buildQueryWrapper(SpaceBuildingsBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<SpaceBuildings> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(SpaceBuildings::getId);
        lqw.eq(bo.getZoneId() != null, SpaceBuildings::getZoneId, bo.getZoneId());
        lqw.like(StringUtils.isNotBlank(bo.getBuildingName()), SpaceBuildings::getBuildingName, bo.getBuildingName());
        lqw.eq(bo.getFloorCount() != null, SpaceBuildings::getFloorCount, bo.getFloorCount());
        return lqw;
    }

    /**
     * 新增楼栋信息
     *
     * @param bo 楼栋信息
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(SpaceBuildingsBo bo) {
        SpaceBuildings add = MapstructUtils.convert(bo, SpaceBuildings.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改楼栋信息
     *
     * @param bo 楼栋信息
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(SpaceBuildingsBo bo) {
        SpaceBuildings update = MapstructUtils.convert(bo, SpaceBuildings.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(SpaceBuildings entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除楼栋信息信息
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
