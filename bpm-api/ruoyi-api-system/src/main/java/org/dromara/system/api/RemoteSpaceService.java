package org.dromara.system.api;

import org.dromara.system.api.domain.vo.RemoteSpaceVo;

import java.util.List;
import java.util.Map;

/**
 * 空间服务
 *
 * @author Lion Li
 */
public interface RemoteSpaceService {

    /**
     * 通过空间ID查询空间名称
     *
     * @param SpaceIds 空间ID串逗号分隔
     * @return 空间名称串逗号分隔
     */
    String selectSpaceNameByIds(String SpaceIds);


}
