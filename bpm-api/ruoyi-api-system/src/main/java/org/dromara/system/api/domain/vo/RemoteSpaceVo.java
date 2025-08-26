package org.dromara.system.api.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * 空间
 *
 * @author sun
 */

@Data
@NoArgsConstructor
public class RemoteSpaceVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 空间ID
     */
    private Long Id;

    /**
     * 空间ID
     */
    private Long parentId;

    /**
     * 空间名称
     */
    private String spaceName;

}
