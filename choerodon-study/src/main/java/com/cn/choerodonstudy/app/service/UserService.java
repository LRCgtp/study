package com.cn.choerodonstudy.app.service;

import com.cn.choerodonstudy.infra.dto.OrganizationDTO;
import com.cn.choerodonstudy.infra.dto.UserDTO;

public interface UserService {
    UserDTO createOne(UserDTO userDTO);

    UserDTO getUserDTO(Long id);
}
