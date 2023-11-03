package com.chunjae.test06.persistence;

import com.chunjae.test06.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserRoleMapper {

    void setUserRoleInfo(@Param("param")UserRole param);

}