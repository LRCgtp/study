package com.cn.choerodonstudy.app.service;

import com.cn.choerodonstudy.infra.dto.OrganizationDTO;
import com.cn.choerodonstudy.infra.vo.OrginazationVo;

import java.math.BigInteger;
import java.util.List;

public interface OrginazationService {
    OrginazationVo createOne(OrginazationVo organizationVo);

    OrginazationVo getOriginaztion(BigInteger id);

    List<OrganizationDTO> list();
}
