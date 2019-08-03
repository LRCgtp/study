package com.cn.choerodonstudy.app.service.imp;

import com.cn.choerodonstudy.app.service.OrginazationService;
import com.cn.choerodonstudy.infra.dto.OrganizationDTO;
import com.cn.choerodonstudy.infra.mapper.OrginazitionMapper;
import io.choerodon.core.exception.CommonException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrginazationServiceImp implements OrginazationService {

    private OrginazitionMapper orginazitionMapper;

    public OrginazationServiceImp(OrginazitionMapper orginazitionMapper) {
        this.orginazitionMapper = orginazitionMapper;
    }

    @Override
    public OrganizationDTO createOne(OrganizationDTO organizationDTO) {
        if (orginazitionMapper.insert(organizationDTO) != 1) {
            throw new CommonException("error.task.insert");
        }
        return organizationDTO;
    }

    @Override
    public OrganizationDTO getOriginaztion(Long id) {
        OrganizationDTO organizationDTO = new OrganizationDTO();
        organizationDTO.setId(id);
        organizationDTO = orginazitionMapper.selectByPrimaryKey(id);

        if (organizationDTO == null) {
            throw new CommonException("error.dashboard.not.exist");
        }
        return organizationDTO;
    }

    @Override
    public List<OrganizationDTO> list() {
        return null;
    }
}
