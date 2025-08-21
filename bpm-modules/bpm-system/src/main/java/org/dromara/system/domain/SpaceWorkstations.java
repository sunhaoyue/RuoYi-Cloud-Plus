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
 * @date 2025-08-21
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
