package org.dromara.system.domain.vo;

import org.dromara.system.domain.SpaceWorkstations;
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
 * 工位主视图对象 space_workstations
 *
 * @author sunhaoyue
 * @date 2025-08-19
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = SpaceWorkstations.class)
public class SpaceWorkstationsVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ExcelProperty(value = "主键")
    private Long id;

    /**
     * 工位唯一业务编码
     */
    @ExcelProperty(value = "工位唯一业务编码")
    private String workstationCode;

    /**
     * 所属楼栋ID，关联space_buildings.id
     */
    @ExcelProperty(value = "所属楼栋ID，关联space_buildings.id")
    private Long buildingId;

    /**
     * 工位所在楼层(必须大于0)
     */
    @ExcelProperty(value = "工位所在楼层(必须大于0)")
    private Long floor;

    /**
     * 工位状态:0-空闲 1-使用中 2-维护中
     */
    @ExcelProperty(value = "工位状态:0-空闲 1-使用中 2-维护中", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "space_status")
    private Long status;

    /**
     * 使用类型:1-固定工位 2-流动工位
     */
    @ExcelProperty(value = "使用类型:1-固定工位 2-流动工位", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "space_usage_type")
    private Long usageType;


}
