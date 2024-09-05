package com.project.center.domain.register.service;

import com.project.center.application.IRegisterManageService;
import com.project.center.domain.register.model.vo.ApplicationInterfaceMethodVO;
import com.project.center.domain.register.model.vo.ApplicationInterfaceVO;
import com.project.center.domain.register.model.vo.ApplicationSystemVO;
import com.project.center.domain.register.repository.IRegisterManageRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class RegisterManageService implements IRegisterManageService {

    @Resource
    private IRegisterManageRepository registerManageRepository;

    @Override
    public void registerApplication(ApplicationSystemVO applicationSystemVO) {
        registerManageRepository.registerApplication(applicationSystemVO);
    }

    @Override
    public void registerApplicationInterface(ApplicationInterfaceVO applicationInterfaceVO) {
        registerManageRepository.registerApplicationInterface(applicationInterfaceVO);
    }

    @Override
    public void registerApplicationInterfaceMethod(ApplicationInterfaceMethodVO applicationInterfaceMethodVO) {
        registerManageRepository.registerApplicationInterfaceMethod(applicationInterfaceMethodVO);
    }
}
