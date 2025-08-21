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
 * @date 2025-08-21
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
     * 工位名称(可选)
     */
    private String workstationName;

    /**
     * 所属空间
     */
    private Long spaceId;

    /**
     * 工位所在楼层
     */
    private Long floor;

    /**
     * 工位状态
     */
    private Long status;

    /**
     * 使用类型
     */
    private Long usageType;


}
