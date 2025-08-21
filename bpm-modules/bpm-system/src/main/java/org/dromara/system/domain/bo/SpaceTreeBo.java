package org.dromara.system.domain.bo;

import org.dromara.system.domain.SpaceTree;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 空间树结构（工区-楼栋-楼层）业务对象 space_tree
 *
 * @author sunhaoyue
 * @date 2025-08-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = SpaceTree.class, reverseConvertGenerate = false)
public class SpaceTreeBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 父级ID，根节点为空或0
     */
    private Long parentId;

    /**
     * 节点类型
     */
    @NotBlank(message = "节点类型不能为空", groups = { AddGroup.class, EditGroup.class })
    private String type;

    /**
     * 工区名称
     */
    @NotBlank(message = "工区名称不能为空", groups = { AddGroup.class, EditGroup.class })
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


}
