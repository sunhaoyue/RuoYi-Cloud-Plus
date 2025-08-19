package org.dromara.system.domain.bo;

import org.dromara.system.domain.SpaceBuildings;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 楼栋信息业务对象 space_buildings
 *
 * @author sunhaoyue
 * @date 2025-08-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = SpaceBuildings.class, reverseConvertGenerate = false)
public class SpaceBuildingsBo extends BaseEntity {

    /**
     * 主键
     */
    @NotNull(message = "主键不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 所属工区ID，关联space_zones.id
     */
    private Long zoneId;

    /**
     * 楼栋名称
     */
    @NotBlank(message = "楼栋名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String buildingName;

    /**
     * 该楼栋总楼层数
     */
    private Long floorCount;


}
