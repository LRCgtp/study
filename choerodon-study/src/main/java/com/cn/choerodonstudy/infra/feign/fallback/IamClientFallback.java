package com.cn.choerodonstudy.infra.feign.fallback;

import com.cn.choerodonstudy.infra.dto.OrganizationDTO;
import com.cn.choerodonstudy.infra.feign.IamFeignService;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;

public class IamClientFallback implements IamFeignService {

    @Override
    public ResponseEntity<OrganizationDTO> query(Long id) {
        return null;
    }
}
