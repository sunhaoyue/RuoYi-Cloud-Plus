package org.dromara.system.domain.bo;

import org.dromara.system.domain.SpaceWorkstations;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 工位主业务对象 space_workstations
 *
 * @author sunhaoyue
 * @date 2025-08-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = SpaceWorkstations.class, reverseConvertGenerate = false)
public class SpaceWorkstationsBo extends BaseEntity {

    /**
     * 主键
     */
    @NotNull(message = "主键不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 工位唯一业务编码
     */
    @NotBlank(message = "工位唯一业务编码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String workstationCode;

    /**
     * 所属楼栋ID，关联space_buildings.id
     */
    private Long buildingId;

    /**
     * 工位所在楼层(必须大于0)
     */
    private Long floor;

    /**
     * 工位状态:0-空闲 1-使用中 2-维护中
     */
    private Long status;

    /**
     * 使用类型:1-固定工位 2-流动工位
     */
    private Long usageType;


}
