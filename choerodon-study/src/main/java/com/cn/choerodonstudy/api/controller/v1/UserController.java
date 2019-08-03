package com.cn.choerodonstudy.api.controller.v1;

import com.cn.choerodonstudy.app.service.OrginazationService;
import com.cn.choerodonstudy.app.service.UserService;
import com.cn.choerodonstudy.infra.dto.OrganizationDTO;
import com.cn.choerodonstudy.infra.dto.UserDTO;
import com.cn.choerodonstudy.infra.feign.IamFeignService;
import com.cn.choerodonstudy.infra.feign.OrganizationUserFeignClient;
import io.choerodon.base.annotation.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/v1/organizations")
public class UserController {

    @Autowired
    private OrginazationService orginazationService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrganizationUserFeignClient organizationUserFeignClient;

    static UserDTO userDTO = new UserDTO();

    /**
     * 根据组织id和用户id查询到某组织下的用户信息
     *
     * @param organizationId
     * @param id
     * @return
     */
    @GetMapping(value = "/{organization_id}/users/{id}")
    public ResponseEntity<UserDTO> query(@PathVariable(name = "organization_id") Long organizationId,
                                         @PathVariable("id") Long id) {
        ResponseEntity<UserDTO> query = organizationUserFeignClient.query(organizationId, id);
        userDTO = query.getBody();
        return query;
    }

    /**
     * 插入组织下的用户信息
     *
     * @return
     */
    @Permission(permissionPublic = true)
    @PostMapping("/insertUser")
    public UserDTO insertUser() {
        UserDTO one = null;
        try {
            if (userDTO != null) {
                one = userService.createOne(userDTO);
                return one;
            }
            userDTO.setId(null);
            userDTO.setEmail("123@qq.com");
            userDTO.setLoginName("lrc");
            userDTO.setOrganizationId((long) 1);
            one = userService.createOne(userDTO);
            return one;
        } catch (Exception e) {
            userDTO = null;
        }
        return null;
    }

    @GetMapping("selectUserById")
    public UserDTO getUserById() {
        if (userDTO != null) {
            Long id = userDTO.getId();
            UserDTO userDTO = userService.getUserDTO(id);
            return userDTO;
        }
        return null;
    }
}
