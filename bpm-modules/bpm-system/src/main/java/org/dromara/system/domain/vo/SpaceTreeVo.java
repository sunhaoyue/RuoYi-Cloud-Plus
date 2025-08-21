package org.dromara.system.domain.vo;

import org.dromara.system.domain.SpaceTree;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;



/**
 * 空间树结构（工区-楼栋-楼层）视图对象 space_tree
 *
 * @author sunhaoyue
 * @date 2025-08-20
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = SpaceTree.class)
public class SpaceTreeVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ExcelProperty(value = "主键ID")
    private Long id;

    /**
     * 父级ID，根节点为空或0
     */
    @ExcelProperty(value = "父级ID，根节点为空或0")
    private Long parentId;

    /**
     * 节点类型
     */
    @ExcelProperty(value = "节点类型", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "space_type")
    private String type;

    /**
     * 工区名称
     */
    @ExcelProperty(value = "工区名称")
    private String name;

    /**
     * 城市
     */
    @ExcelProperty(value = "城市")
    private String city;

    /**
     * 详情地址
     */
    @ExcelProperty(value = "详情地址")
    private String address;

    /**
     * 楼层编号
     */
    @ExcelProperty(value = "楼层编号")
    private Long floorNumber;

    /**
     * 排序
     */
    @ExcelProperty(value = "排序")
    private Long sort;


}
