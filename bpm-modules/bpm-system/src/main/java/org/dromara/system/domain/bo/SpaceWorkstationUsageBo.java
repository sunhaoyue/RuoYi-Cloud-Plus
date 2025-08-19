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
 * @date 2025-08-19
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
     * 使用员工ID，关联sys_user.user_id
     */
    @NotNull(message = "使用员工ID，关联sys_user.user_id不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long employeeId;

    /**
     * 使用工位ID，关联space_workstations.id
     */
    @NotNull(message = "使用工位ID，关联space_workstations.id不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long workstationId;

    /**
     * 使用类型:1-固定分配 2-流动预定
     */
    @NotNull(message = "使用类型:1-固定分配 2-流动预定不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long usageType;

    /**
     * 使用开始时间
     */
    @NotNull(message = "使用开始时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date startTime;

    /**
     * 使用结束时间(NULL表示长期使用)
     */
    private Date endTime;

    /**
     * 记录状态:0-已取消 1-有效中 2-已完成
     */
    private Long status;

    /**
     * 是否长期分配标志
     */
    private Long isLongTerm;

    /**
     * 使用备注信息
     */
    private String remark;


}
