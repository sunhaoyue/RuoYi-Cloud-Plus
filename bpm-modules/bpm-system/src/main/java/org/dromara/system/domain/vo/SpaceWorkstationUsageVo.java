package org.dromara.system.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.system.domain.SpaceWorkstationUsage;
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
 * 工位使用记录视图对象 space_workstation_usage
 *
 * @author sunhaoyue
 * @date 2025-08-19
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = SpaceWorkstationUsage.class)
public class SpaceWorkstationUsageVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ExcelProperty(value = "主键")
    private Long id;

    /**
     * 使用员工ID，关联sys_user.user_id
     */
    @ExcelProperty(value = "使用员工ID，关联sys_user.user_id")
    private Long employeeId;

    /**
     * 使用工位ID，关联space_workstations.id
     */
    @ExcelProperty(value = "使用工位ID，关联space_workstations.id")
    private Long workstationId;

    /**
     * 使用类型:1-固定分配 2-流动预定
     */
    @ExcelProperty(value = "使用类型:1-固定分配 2-流动预定", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "space_usage_type")
    private Long usageType;

    /**
     * 使用开始时间
     */
    @ExcelProperty(value = "使用开始时间")
    private Date startTime;

    /**
     * 使用结束时间(NULL表示长期使用)
     */
    @ExcelProperty(value = "使用结束时间(NULL表示长期使用)")
    private Date endTime;

    /**
     * 记录状态:0-已取消 1-有效中 2-已完成
     */
    @ExcelProperty(value = "记录状态:0-已取消 1-有效中 2-已完成", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "space_status")
    private Long status;

    /**
     * 是否长期分配标志
     */
    @ExcelProperty(value = "是否长期分配标志")
    private Long isLongTerm;

    /**
     * 使用备注信息
     */
    @ExcelProperty(value = "使用备注信息")
    private String remark;


}
