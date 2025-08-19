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
import org.dromara.system.domain.bo.SpaceWorkstationsBo;
import org.dromara.system.domain.vo.SpaceWorkstationsVo;
import org.dromara.system.domain.SpaceWorkstations;
import org.dromara.system.mapper.SpaceWorkstationsMapper;
import org.dromara.system.service.ISpaceWorkstationsService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 工位主Service业务层处理
 *
 * @author sunhaoyue
 * @date 2025-08-19
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class SpaceWorkstationsServiceImpl implements ISpaceWorkstationsService {

    private final SpaceWorkstationsMapper baseMapper;

    /**
     * 查询工位主
     *
     * @param id 主键
     * @return 工位主
     */
    @Override
    public SpaceWorkstationsVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询工位主列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 工位主分页列表
     */
    @Override
    public TableDataInfo<SpaceWorkstationsVo> queryPageList(SpaceWorkstationsBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<SpaceWorkstations> lqw = buildQueryWrapper(bo);
        Page<SpaceWorkstationsVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的工位主列表
     *
     * @param bo 查询条件
     * @return 工位主列表
     */
    @Override
    public List<SpaceWorkstationsVo> queryList(SpaceWorkstationsBo bo) {
        LambdaQueryWrapper<SpaceWorkstations> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<SpaceWorkstations> buildQueryWrapper(SpaceWorkstationsBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<SpaceWorkstations> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(SpaceWorkstations::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getWorkstationCode()), SpaceWorkstations::getWorkstationCode, bo.getWorkstationCode());
        lqw.eq(bo.getBuildingId() != null, SpaceWorkstations::getBuildingId, bo.getBuildingId());
        lqw.eq(bo.getFloor() != null, SpaceWorkstations::getFloor, bo.getFloor());
        lqw.eq(bo.getStatus() != null, SpaceWorkstations::getStatus, bo.getStatus());
        lqw.eq(bo.getUsageType() != null, SpaceWorkstations::getUsageType, bo.getUsageType());
        return lqw;
    }

    /**
     * 新增工位主
     *
     * @param bo 工位主
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(SpaceWorkstationsBo bo) {
        SpaceWorkstations add = MapstructUtils.convert(bo, SpaceWorkstations.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改工位主
     *
     * @param bo 工位主
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(SpaceWorkstationsBo bo) {
        SpaceWorkstations update = MapstructUtils.convert(bo, SpaceWorkstations.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(SpaceWorkstations entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除工位主信息
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
