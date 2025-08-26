package org.dromara.system.dubbo;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import org.dromara.common.core.constant.SystemConstants;
import org.dromara.common.core.utils.StreamUtils;
import org.dromara.system.api.RemoteSpaceService;
import org.dromara.system.api.domain.vo.RemoteSpaceVo;
import org.dromara.system.domain.SpaceTree;
import org.dromara.system.domain.vo.SpaceTreeVo;
import org.dromara.system.mapper.SpaceTreeMapper;
import org.dromara.system.service.ISpaceTreeService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 空间服务
 *
 * @author Lion Li
 */
@RequiredArgsConstructor
@Service
@DubboService
public class RemoteSpaceTreeServiceImpl implements RemoteSpaceService {

    private final ISpaceTreeService spaceTreeService;

    /**
     * 通过空间ID查询空间名称
     *
     * @param spaceTreeIds 空间ID串逗号分隔
     * @return 空间名称串逗号分隔
     */
    @Override
    public String selectSpaceNameByIds(String spaceTreeIds) {
        return spaceTreeService.selectSpaceNameByIds(spaceTreeIds);
    }

}
