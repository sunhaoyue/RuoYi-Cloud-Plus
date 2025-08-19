package org.dromara.system.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 城市工区信息对象 space_zones
 *
 * @author sunhaoyue
 * @date 2025-08-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("space_zones")
public class SpaceZones extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 工区所在城市名称
     */
    private String city;

    /**
     * 工区具体名称
     */
    private String zoneName;

    /**
     * 工区详细地址信息
     */
    private String address;

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
