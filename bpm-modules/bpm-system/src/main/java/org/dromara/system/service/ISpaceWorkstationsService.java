package org.dromara.system.service;

import org.dromara.system.domain.SpaceWorkstations;
import org.dromara.system.domain.vo.SpaceWorkstationsVo;
import org.dromara.system.domain.bo.SpaceWorkstationsBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 工位主Service接口
 *
 * @author sunhaoyue
 * @date 2025-08-19
 */
public interface ISpaceWorkstationsService {

    /**
     * 查询工位主
     *
     * @param id 主键
     * @return 工位主
     */
    SpaceWorkstationsVo queryById(Long id);

    /**
     * 分页查询工位主列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 工位主分页列表
     */
    TableDataInfo<SpaceWorkstationsVo> queryPageList(SpaceWorkstationsBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的工位主列表
     *
     * @param bo 查询条件
     * @return 工位主列表
     */
    List<SpaceWorkstationsVo> queryList(SpaceWorkstationsBo bo);

    /**
     * 新增工位主
     *
     * @param bo 工位主
     * @return 是否新增成功
     */
    Boolean insertByBo(SpaceWorkstationsBo bo);

    /**
     * 修改工位主
     *
     * @param bo 工位主
     * @return 是否修改成功
     */
    Boolean updateByBo(SpaceWorkstationsBo bo);

    /**
     * 校验并批量删除工位主信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
