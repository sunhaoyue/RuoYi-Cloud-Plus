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
import org.dromara.system.domain.bo.SpaceWorkstationUsageBo;
import org.dromara.system.domain.vo.SpaceWorkstationUsageVo;
import org.dromara.system.domain.SpaceWorkstationUsage;
import org.dromara.system.mapper.SpaceWorkstationUsageMapper;
import org.dromara.system.service.ISpaceWorkstationUsageService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 工位使用记录Service业务层处理
 *
 * @author sunhaoyue
 * @date 2025-08-19
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class SpaceWorkstationUsageServiceImpl implements ISpaceWorkstationUsageService {

    private final SpaceWorkstationUsageMapper baseMapper;

    /**
     * 查询工位使用记录
     *
     * @param id 主键
     * @return 工位使用记录
     */
    @Override
    public SpaceWorkstationUsageVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询工位使用记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 工位使用记录分页列表
     */
    @Override
    public TableDataInfo<SpaceWorkstationUsageVo> queryPageList(SpaceWorkstationUsageBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<SpaceWorkstationUsage> lqw = buildQueryWrapper(bo);
        Page<SpaceWorkstationUsageVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的工位使用记录列表
     *
     * @param bo 查询条件
     * @return 工位使用记录列表
     */
    @Override
    public List<SpaceWorkstationUsageVo> queryList(SpaceWorkstationUsageBo bo) {
        LambdaQueryWrapper<SpaceWorkstationUsage> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<SpaceWorkstationUsage> buildQueryWrapper(SpaceWorkstationUsageBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<SpaceWorkstationUsage> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(SpaceWorkstationUsage::getId);
        lqw.eq(bo.getEmployeeId() != null, SpaceWorkstationUsage::getEmployeeId, bo.getEmployeeId());
        lqw.eq(bo.getWorkstationId() != null, SpaceWorkstationUsage::getWorkstationId, bo.getWorkstationId());
        lqw.eq(bo.getUsageType() != null, SpaceWorkstationUsage::getUsageType, bo.getUsageType());
        lqw.eq(bo.getStartTime() != null, SpaceWorkstationUsage::getStartTime, bo.getStartTime());
        lqw.eq(bo.getEndTime() != null, SpaceWorkstationUsage::getEndTime, bo.getEndTime());
        lqw.eq(bo.getStatus() != null, SpaceWorkstationUsage::getStatus, bo.getStatus());
        lqw.eq(bo.getIsLongTerm() != null, SpaceWorkstationUsage::getIsLongTerm, bo.getIsLongTerm());
        return lqw;
    }

    /**
     * 新增工位使用记录
     *
     * @param bo 工位使用记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(SpaceWorkstationUsageBo bo) {
        SpaceWorkstationUsage add = MapstructUtils.convert(bo, SpaceWorkstationUsage.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改工位使用记录
     *
     * @param bo 工位使用记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(SpaceWorkstationUsageBo bo) {
        SpaceWorkstationUsage update = MapstructUtils.convert(bo, SpaceWorkstationUsage.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(SpaceWorkstationUsage entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除工位使用记录信息
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
