package org.dromara.system.service;

import org.dromara.system.domain.SpaceWorkstationUsage;
import org.dromara.system.domain.vo.SpaceWorkstationUsageVo;
import org.dromara.system.domain.bo.SpaceWorkstationUsageBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 工位使用记录Service接口
 *
 * @author sunhaoyue
 * @date 2025-08-21
 */
public interface ISpaceWorkstationUsageService {

    /**
     * 查询工位使用记录
     *
     * @param id 主键
     * @return 工位使用记录
     */
    SpaceWorkstationUsageVo queryById(Long id);

    /**
     * 分页查询工位使用记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 工位使用记录分页列表
     */
    TableDataInfo<SpaceWorkstationUsageVo> queryPageList(SpaceWorkstationUsageBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的工位使用记录列表
     *
     * @param bo 查询条件
     * @return 工位使用记录列表
     */
    List<SpaceWorkstationUsageVo> queryList(SpaceWorkstationUsageBo bo);

    /**
     * 新增工位使用记录
     *
     * @param bo 工位使用记录
     * @return 是否新增成功
     */
    Boolean insertByBo(SpaceWorkstationUsageBo bo);

    /**
     * 修改工位使用记录
     *
     * @param bo 工位使用记录
     * @return 是否修改成功
     */
    Boolean updateByBo(SpaceWorkstationUsageBo bo);

    /**
     * 校验并批量删除工位使用记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
