package org.dromara.system.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 工位使用记录对象 space_workstation_usage
 *
 * @author sunhaoyue
 * @date 2025-08-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("space_workstation_usage")
public class SpaceWorkstationUsage extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 使用员工
     */
    private Long employeeId;

    /**
     * 使用工位
     */
    private Long workstationId;

    /**
     * 使用类型
     */
    private Long usageType;

    /**
     * 使用开始时间
     */
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

    /**
     * 版本
     */
    @Version
    private Long version;

    /**
     * 删除标志
     */
    @TableLogic
    private Long delFlag;


}
