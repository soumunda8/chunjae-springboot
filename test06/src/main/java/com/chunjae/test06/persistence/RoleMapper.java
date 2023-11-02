package com.chunjae.test06.persistence;

import com.chunjae.test06.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface RoleMapper {

    Role getRoleInfo(@Param("role") String role);   // UserGrand 값이 들어옴

}