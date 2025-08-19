package org.dromara.system.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 工位主对象 space_workstations
 *
 * @author sunhaoyue
 * @date 2025-08-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("space_workstations")
public class SpaceWorkstations extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 工位唯一业务编码
     */
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
