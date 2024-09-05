package com.project.center.domain.manage.model.aggregates;

import com.project.center.domain.manage.model.vo.ApplicationSystemVO;

import java.util.List;

/**
 * 网关算力配置信息
 */

public class ApplicationSystemRichInfo {
    //网关ID
    private String gatewayId;

    //系统列表
    private List<ApplicationSystemVO> applicationSystemVOList;
}
