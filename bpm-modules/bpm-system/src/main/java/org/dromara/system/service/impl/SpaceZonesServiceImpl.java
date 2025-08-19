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
import org.dromara.system.domain.bo.SpaceZonesBo;
import org.dromara.system.domain.vo.SpaceZonesVo;
import org.dromara.system.domain.SpaceZones;
import org.dromara.system.mapper.SpaceZonesMapper;
import org.dromara.system.service.ISpaceZonesService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 城市工区信息Service业务层处理
 *
 * @author sunhaoyue
 * @date 2025-08-19
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class SpaceZonesServiceImpl implements ISpaceZonesService {

    private final SpaceZonesMapper baseMapper;

    /**
     * 查询城市工区信息
     *
     * @param id 主键
     * @return 城市工区信息
     */
    @Override
    public SpaceZonesVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询城市工区信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 城市工区信息分页列表
     */
    @Override
    public TableDataInfo<SpaceZonesVo> queryPageList(SpaceZonesBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<SpaceZones> lqw = buildQueryWrapper(bo);
        Page<SpaceZonesVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的城市工区信息列表
     *
     * @param bo 查询条件
     * @return 城市工区信息列表
     */
    @Override
    public List<SpaceZonesVo> queryList(SpaceZonesBo bo) {
        LambdaQueryWrapper<SpaceZones> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<SpaceZones> buildQueryWrapper(SpaceZonesBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<SpaceZones> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(SpaceZones::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getCity()), SpaceZones::getCity, bo.getCity());
        lqw.like(StringUtils.isNotBlank(bo.getZoneName()), SpaceZones::getZoneName, bo.getZoneName());
        lqw.eq(StringUtils.isNotBlank(bo.getAddress()), SpaceZones::getAddress, bo.getAddress());
        return lqw;
    }

    /**
     * 新增城市工区信息
     *
     * @param bo 城市工区信息
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(SpaceZonesBo bo) {
        SpaceZones add = MapstructUtils.convert(bo, SpaceZones.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改城市工区信息
     *
     * @param bo 城市工区信息
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(SpaceZonesBo bo) {
        SpaceZones update = MapstructUtils.convert(bo, SpaceZones.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(SpaceZones entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除城市工区信息信息
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
