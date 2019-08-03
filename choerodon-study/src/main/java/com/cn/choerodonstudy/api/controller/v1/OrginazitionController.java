package com.cn.choerodonstudy.api.controller.v1;

import com.cn.choerodonstudy.app.service.OrginazationService;
import com.cn.choerodonstudy.app.service.UserService;
import com.cn.choerodonstudy.app.service.imp.OrginazationServiceImp;
import com.cn.choerodonstudy.infra.dto.OrganizationDTO;
import com.cn.choerodonstudy.infra.dto.UserDTO;
import com.cn.choerodonstudy.infra.feign.IamFeignService;
import com.cn.choerodonstudy.infra.feign.OrganizationUserFeignClient;
import com.cn.choerodonstudy.infra.vo.OrginazationVo;
import io.choerodon.base.annotation.Permission;
import io.choerodon.base.enums.ResourceType;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
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

    static OrganizationDTO organizationDTO = null;

    static UserDTO userDTO = new UserDTO();

    static OrginazationVo orginazationVo = null;

    static final Logger logger = LoggerFactory.getLogger(OrginazationServiceImp.class);

    /**
     * 根据id查询组织信息
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{organization_id}")
    public ResponseEntity<OrganizationDTO> query(@PathVariable(name = "organization_id") Long id) {
        ResponseEntity<OrganizationDTO> query = iamFeignService.query(id);
        organizationDTO = new OrganizationDTO();
        organizationDTO = query.getBody();
        orginazationVo = new OrginazationVo();
        if (organizationDTO == null) {
            orginazationVo.setID(new BigInteger("20"));
            orginazationVo.setCODE("afa232");
            orginazationVo.setNAME("汉得");
            orginazationVo.setIS_ENABLED(10);
        } else {
            Long ID = organizationDTO.getId();
            BigInteger m = new BigInteger(ID.toString());
            orginazationVo.setID(m);
            orginazationVo.setCODE(organizationDTO.getCode());
            orginazationVo.setNAME(organizationDTO.getName());
            orginazationVo.setIS_ENABLED(9);
            logger.info("OrginazitionController插入orginazation" + orginazationVo.toString());
            orginazationVo = orginazationService.createOne(orginazationVo);
            return query;
        }
        logger.info("OrginazitionController插入失败了,因为字段查询为空\"+orginazationVo.toString()");
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
       /* try {
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
        }*/
        return null;
    }

    @GetMapping("selectOriginalById")
    public OrginazationVo getByOriginalId() {
        logger.info("OrginazitionController根据id查询组织信息");
        if (organizationDTO != null) {
            Long id = organizationDTO.getId();
            BigInteger m = new BigInteger(id.toString());
            OrginazationVo originaztion = orginazationService.getOriginaztion(m);
            logger.info("OrginazitionController查询组织信息成功");
            return originaztion;
        }
        logger.info("OrginazitionController查询组织信息失败");
        return null;
    }

    /**
     * 分页查询组织信息
     */

}

