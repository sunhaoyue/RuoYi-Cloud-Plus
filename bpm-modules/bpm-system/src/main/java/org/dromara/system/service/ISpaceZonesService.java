package org.dromara.system.service;

import org.dromara.system.domain.SpaceZones;
import org.dromara.system.domain.vo.SpaceZonesVo;
import org.dromara.system.domain.bo.SpaceZonesBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 城市工区信息Service接口
 *
 * @author sunhaoyue
 * @date 2025-08-19
 */
public interface ISpaceZonesService {

    /**
     * 查询城市工区信息
     *
     * @param id 主键
     * @return 城市工区信息
     */
    SpaceZonesVo queryById(Long id);

    /**
     * 分页查询城市工区信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 城市工区信息分页列表
     */
    TableDataInfo<SpaceZonesVo> queryPageList(SpaceZonesBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的城市工区信息列表
     *
     * @param bo 查询条件
     * @return 城市工区信息列表
     */
    List<SpaceZonesVo> queryList(SpaceZonesBo bo);

    /**
     * 新增城市工区信息
     *
     * @param bo 城市工区信息
     * @return 是否新增成功
     */
    Boolean insertByBo(SpaceZonesBo bo);

    /**
     * 修改城市工区信息
     *
     * @param bo 城市工区信息
     * @return 是否修改成功
     */
    Boolean updateByBo(SpaceZonesBo bo);

    /**
     * 校验并批量删除城市工区信息信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
