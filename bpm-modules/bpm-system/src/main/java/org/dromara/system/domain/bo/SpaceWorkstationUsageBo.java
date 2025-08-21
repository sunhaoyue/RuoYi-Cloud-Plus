package org.dromara.system.domain.bo;

import org.dromara.system.domain.SpaceWorkstationUsage;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 工位使用记录业务对象 space_workstation_usage
 *
 * @author sunhaoyue
 * @date 2025-08-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = SpaceWorkstationUsage.class, reverseConvertGenerate = false)
public class SpaceWorkstationUsageBo extends BaseEntity {

    /**
     * 主键
     */
    @NotNull(message = "主键不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 使用员工
     */
    @NotNull(message = "使用员工不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long employeeId;

    /**
     * 使用工位
     */
    @NotNull(message = "使用工位不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long workstationId;

    /**
     * 使用类型
     */
    @NotNull(message = "使用类型不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long usageType;

    /**
     * 使用开始时间
     */
    @NotNull(message = "使用开始时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date startTime;

    /**
     * 使用结束时间
     */
    private Date endTime;

    /**
     * 记录状态
     */
    private Long status;

    /**
     * 是否长期分配标志
     */
    private String isLongTerm;

    /**
     * 使用备注信息
     */
    private String remark;


}
