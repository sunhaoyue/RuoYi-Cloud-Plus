package org.dromara.common.translation.core.impl;

import lombok.AllArgsConstructor;
import org.apache.dubbo.config.annotation.DubboReference;
import org.dromara.common.translation.annotation.TranslationType;
import org.dromara.common.translation.constant.TransConstant;
import org.dromara.common.translation.core.TranslationInterface;
import org.dromara.system.api.RemoteSpaceService;

/**
 *
 */
@AllArgsConstructor
@TranslationType(type = TransConstant.SPACE_ID_TO_NAME)
public class SpaceNameTranslationImpl implements TranslationInterface<String> {

    @DubboReference
    private RemoteSpaceService remoteSpaceService;

    @Override
    public String translation(Object key, String other) {
        return remoteSpaceService.selectSpaceNameByIds(key.toString());
    }
}
