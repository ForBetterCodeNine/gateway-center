package com.project.center.application;

import com.project.center.domain.register.model.vo.ApplicationInterfaceMethodVO;
import com.project.center.domain.register.model.vo.ApplicationInterfaceVO;
import com.project.center.domain.register.model.vo.ApplicationSystemVO;

/**
 * 接口注册服务
 */
public interface IRegisterManageService {
    void registerApplication(ApplicationSystemVO applicationSystemVO);

    void registerApplicationInterface(ApplicationInterfaceVO applicationInterfaceVO);

    void registerApplicationInterfaceMethod(ApplicationInterfaceMethodVO applicationInterfaceMethodVO);
}
