package com.cn.choerodonstudy.app.service.imp;

import com.cn.choerodonstudy.app.service.OrginazationService;
import com.cn.choerodonstudy.infra.dto.OrganizationDTO;
import com.cn.choerodonstudy.infra.mapper.OrginazitionMapper;
import com.cn.choerodonstudy.infra.vo.OrginazationVo;
import io.choerodon.core.exception.CommonException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class OrginazationServiceImp implements OrginazationService {

    static final Logger logger= LoggerFactory.getLogger(OrginazationServiceImp.class);

    @Autowired
    private OrginazitionMapper orginazitionMapper;

    @Override
    public OrginazationVo createOne(OrginazationVo organizationVo) {
        int i = orginazitionMapper.insertOrginaztation(organizationVo);
        logger.info("OrginazationServiceImp开始插入操作");
        if (i>0){
         logger.info("数据库插入成功了");
         return organizationVo;
        }
        logger.info("OrginazationServiceImp插入数据库失败");
        return null;
    }

    @Override
    public OrginazationVo getOriginaztion(BigInteger id) {
        OrginazationVo orginazationVo=orginazitionMapper.selectOrgByID(id);
        return orginazationVo;
    }

    @Override
    public List<OrganizationDTO> list() {
        return null;
    }
}
