package com.cn.choerodonstudy.infra.mapper;

import com.cn.choerodonstudy.infra.dto.OrganizationDTO;
import com.cn.choerodonstudy.infra.dto.UserDTO;
import io.choerodon.mybatis.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<UserDTO> {
}
