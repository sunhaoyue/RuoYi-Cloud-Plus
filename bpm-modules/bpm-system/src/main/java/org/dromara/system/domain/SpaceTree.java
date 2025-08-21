package org.dromara.system.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 空间树结构（工区-楼栋-楼层）对象 space_tree
 *
 * @author sunhaoyue
 * @date 2025-08-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("space_tree")
public class SpaceTree extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 父级ID，根节点为空或0
     */
    private Long parentId;

    /**
     * 节点类型
     */
    private String type;

    /**
     * 工区名称
     */
    private String name;

    /**
     * 城市
     */
    private String city;

    /**
     * 详情地址
     */
    private String address;

    /**
     * 楼层编号
     */
    private Long floorNumber;

    /**
     * 排序
     */
    private Long sort;

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
