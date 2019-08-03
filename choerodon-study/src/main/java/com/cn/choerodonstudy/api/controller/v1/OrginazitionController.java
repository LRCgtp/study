package com.cn.choerodonstudy.api.controller.v1;

import com.cn.choerodonstudy.app.service.OrginazationService;
import com.cn.choerodonstudy.app.service.UserService;
import com.cn.choerodonstudy.infra.dto.OrganizationDTO;
import com.cn.choerodonstudy.infra.dto.UserDTO;
import com.cn.choerodonstudy.infra.feign.IamFeignService;
import com.cn.choerodonstudy.infra.feign.OrganizationUserFeignClient;
import io.choerodon.base.annotation.Permission;
import io.choerodon.base.enums.ResourceType;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/org/v1/organizations")
public class OrginazitionController {


    @Autowired
    private IamFeignService iamFeignService;

    @Autowired
    private OrginazationService orginazationService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrganizationUserFeignClient organizationUserFeignClient;

    static OrganizationDTO organizationDTO = new OrganizationDTO();

    static UserDTO userDTO = new UserDTO();

    /**
     * 根据id查询组织信息
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{organization_id}")
    public ResponseEntity<OrganizationDTO> query(@PathVariable(name = "organization_id") Long id) {
        ResponseEntity<OrganizationDTO> query = iamFeignService.query(id);
        organizationDTO = query.getBody();
        orginazationService.createOne(organizationDTO);
        return query;
    }

    /**
     * 插入组织信息
     *
     * @return
     */
    @Permission(permissionPublic = true)
    @PostMapping("/insertORG")
    public OrganizationDTO insertORG() {
        OrganizationDTO one = null;
        try {
            if (organizationDTO != null) {
                one = orginazationService.createOne(organizationDTO);
            }
            organizationDTO.setId(null);
            organizationDTO.setCode("afalfja");
            organizationDTO.setIS_ENABLED("123");
            orginazationService.createOne(organizationDTO);
            return one;
        } catch (Exception e) {
            organizationDTO = null;
        }
        return null;
    }

    @GetMapping("selectOriginalById")
    public OrganizationDTO getByOriginalId() {
        if (organizationDTO != null) {
            Long id = organizationDTO.getId();
            OrganizationDTO originaztion = orginazationService.getOriginaztion(id);
            return originaztion;
        }
        return null;
    }

    /**
     * 分页查询组织信息
     */

}

