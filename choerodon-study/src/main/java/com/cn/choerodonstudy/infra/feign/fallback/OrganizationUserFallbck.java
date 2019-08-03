package com.cn.choerodonstudy.infra.feign.fallback;

import com.cn.choerodonstudy.infra.dto.UserDTO;
import com.cn.choerodonstudy.infra.feign.OrganizationUserFeignClient;
import org.springframework.http.ResponseEntity;

public class OrganizationUserFallbck implements OrganizationUserFeignClient {
    @Override
    public ResponseEntity<UserDTO> query(Long organizationId, Long id) {
        return null;
    }
}
