package org.dromara.system.domain.vo;

import org.dromara.common.translation.annotation.Translation;
import org.dromara.common.translation.constant.TransConstant;
import org.dromara.system.domain.SpaceWorkstations;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;



/**
 * 工位主视图对象 space_workstations
 *
 * @author sunhaoyue
 * @date 2025-08-21
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
     * 工位名称(可选)
     */
    @ExcelProperty(value = "工位名称(可选)")
    private String workstationName;

    /**
     * 所属空间
     */
    @ExcelProperty(value = "所属空间")
    private Long spaceId;

    /**
     * 工位所在楼层
     */
    @ExcelProperty(value = "工位所在楼层")
    private Long floor;

    /**
     * 工位状态
     */
    @ExcelProperty(value = "工位状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "space_status")
    private Long status;

    /**
     * 使用类型
     */
    @ExcelProperty(value = "使用类型", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "space_usage_type")
    private Long usageType;

    /**
     * 空间名
     */
    @Translation(type = TransConstant.SPACE_ID_TO_NAME, mapper = "id")
    private String spaceName;

}
