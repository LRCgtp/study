package com.cn.choerodonstudy.app.service;

import com.cn.choerodonstudy.infra.dto.OrganizationDTO;

import java.util.List;

public interface OrginazationService {
    OrganizationDTO createOne(OrganizationDTO organizationDTO);

    OrganizationDTO getOriginaztion(Long id);

    List<OrganizationDTO> list();
}
