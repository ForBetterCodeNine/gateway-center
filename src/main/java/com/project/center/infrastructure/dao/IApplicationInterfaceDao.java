package com.project.center.infrastructure.dao;

import com.project.center.infrastructure.po.ApplicationInterface;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IApplicationInterfaceDao {
    void insert(ApplicationInterface applicationInterface);
}
