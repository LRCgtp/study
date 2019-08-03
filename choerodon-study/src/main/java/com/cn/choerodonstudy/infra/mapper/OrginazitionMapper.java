package com.cn.choerodonstudy.infra.mapper;

import com.cn.choerodonstudy.infra.dto.OrganizationDTO;
import com.cn.choerodonstudy.infra.vo.OrginazationVo;
import io.choerodon.mybatis.common.Mapper;

import java.math.BigInteger;

@org.apache.ibatis.annotations.Mapper
public interface OrginazitionMapper extends Mapper<OrganizationDTO> {
    int insertOrginaztation(OrginazationVo orginazationVo);

    OrginazationVo selectOrgByID(BigInteger id);
}
