package com.cn.choerodonstudy.infra.feign;

import com.cn.choerodonstudy.infra.dto.OrganizationDTO;
import com.cn.choerodonstudy.infra.feign.fallback.IamClientFallback;
import io.choerodon.base.annotation.Permission;
import io.choerodon.base.enums.ResourceType;
import io.choerodon.core.iam.ResourceLevel;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient(value = "iam-service", fallback = IamClientFallback.class)
@Component
public interface IamFeignService {

    /**
     * 根据组织id查询组织
     *
     * @param id 所要查询的组织id号
     * @return 组织信息
     */
    @GetMapping(value = "/v1/organizations/{organization_id}")
    public ResponseEntity<OrganizationDTO> query(@PathVariable(name = "organization_id") Long id);

}

