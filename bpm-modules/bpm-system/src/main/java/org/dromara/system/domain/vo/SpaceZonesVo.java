package org.dromara.system.domain.vo;

import org.dromara.system.domain.SpaceZones;
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
 * 城市工区信息视图对象 space_zones
 *
 * @author sunhaoyue
 * @date 2025-08-19
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = SpaceZones.class)
public class SpaceZonesVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ExcelProperty(value = "主键")
    private Long id;

    /**
     * 工区所在城市名称
     */
    @ExcelProperty(value = "工区所在城市名称")
    private String city;

    /**
     * 工区具体名称
     */
    @ExcelProperty(value = "工区具体名称")
    private String zoneName;

    /**
     * 工区详细地址信息
     */
    @ExcelProperty(value = "工区详细地址信息")
    private String address;


}
