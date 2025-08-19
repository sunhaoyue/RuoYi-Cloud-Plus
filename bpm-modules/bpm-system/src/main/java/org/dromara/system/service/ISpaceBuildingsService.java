package org.dromara.system.service;

import org.dromara.system.domain.SpaceBuildings;
import org.dromara.system.domain.vo.SpaceBuildingsVo;
import org.dromara.system.domain.bo.SpaceBuildingsBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 楼栋信息Service接口
 *
 * @author sunhaoyue
 * @date 2025-08-19
 */
public interface ISpaceBuildingsService {

    /**
     * 查询楼栋信息
     *
     * @param id 主键
     * @return 楼栋信息
     */
    SpaceBuildingsVo queryById(Long id);

    /**
     * 分页查询楼栋信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 楼栋信息分页列表
     */
    TableDataInfo<SpaceBuildingsVo> queryPageList(SpaceBuildingsBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的楼栋信息列表
     *
     * @param bo 查询条件
     * @return 楼栋信息列表
     */
    List<SpaceBuildingsVo> queryList(SpaceBuildingsBo bo);

    /**
     * 新增楼栋信息
     *
     * @param bo 楼栋信息
     * @return 是否新增成功
     */
    Boolean insertByBo(SpaceBuildingsBo bo);

    /**
     * 修改楼栋信息
     *
     * @param bo 楼栋信息
     * @return 是否修改成功
     */
    Boolean updateByBo(SpaceBuildingsBo bo);

    /**
     * 校验并批量删除楼栋信息信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
