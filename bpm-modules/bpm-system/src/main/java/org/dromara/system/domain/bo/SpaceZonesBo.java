package org.dromara.system.domain.bo;

import org.dromara.system.domain.SpaceZones;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 城市工区信息业务对象 space_zones
 *
 * @author sunhaoyue
 * @date 2025-08-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = SpaceZones.class, reverseConvertGenerate = false)
public class SpaceZonesBo extends BaseEntity {

    /**
     * 主键
     */
    @NotNull(message = "主键不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 工区所在城市名称
     */
    @NotBlank(message = "工区所在城市名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String city;

    /**
     * 工区具体名称
     */
    @NotBlank(message = "工区具体名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String zoneName;

    /**
     * 工区详细地址信息
     */
    private String address;


}
