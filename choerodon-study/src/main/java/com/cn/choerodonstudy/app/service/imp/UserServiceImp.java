package com.cn.choerodonstudy.app.service.imp;

import com.cn.choerodonstudy.app.service.UserService;
import com.cn.choerodonstudy.infra.dto.OrganizationDTO;
import com.cn.choerodonstudy.infra.dto.UserDTO;
import com.cn.choerodonstudy.infra.mapper.OrginazitionMapper;
import com.cn.choerodonstudy.infra.mapper.UserMapper;
import io.choerodon.core.exception.CommonException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    private UserMapper userMapper;

    public UserServiceImp(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO createOne(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO getUserDTO(Long id) {
        UserDTO user = new UserDTO();
        user.setId(id);
        UserDTO userDTO = userMapper.selectByPrimaryKey(id);

        if (userDTO == null) {
            throw new CommonException("error.dashboard.not.exist");
        }
        return userDTO;
    }

}
