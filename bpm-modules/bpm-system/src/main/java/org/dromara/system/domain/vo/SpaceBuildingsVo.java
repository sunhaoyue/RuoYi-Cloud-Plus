package org.dromara.system.domain.vo;

import org.dromara.system.domain.SpaceBuildings;
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
 * 楼栋信息视图对象 space_buildings
 *
 * @author sunhaoyue
 * @date 2025-08-19
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = SpaceBuildings.class)
public class SpaceBuildingsVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ExcelProperty(value = "主键")
    private Long id;

    /**
     * 所属工区ID，关联space_zones.id
     */
    @ExcelProperty(value = "所属工区ID，关联space_zones.id")
    private Long zoneId;

    /**
     * 楼栋名称
     */
    @ExcelProperty(value = "楼栋名称")
    private String buildingName;

    /**
     * 该楼栋总楼层数
     */
    @ExcelProperty(value = "该楼栋总楼层数")
    private Long floorCount;


}
