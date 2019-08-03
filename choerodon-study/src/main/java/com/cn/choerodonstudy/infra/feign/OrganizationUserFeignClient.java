package com.cn.choerodonstudy.infra.feign;

import com.cn.choerodonstudy.infra.dto.UserDTO;
import com.cn.choerodonstudy.infra.feign.fallback.IamClientFallback;
import com.cn.choerodonstudy.infra.feign.fallback.OrganizationUserFallbck;
import io.choerodon.base.annotation.Permission;
import io.choerodon.base.enums.ResourceType;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "iam-service", fallback = OrganizationUserFallbck.class)
@Component
public interface OrganizationUserFeignClient {

    @GetMapping(value = "/v1/organizations/{organization_id}/users/{id}")
    public ResponseEntity<UserDTO> query(@PathVariable(name = "organization_id") Long organizationId,
                                         @PathVariable("id") Long id);
}
