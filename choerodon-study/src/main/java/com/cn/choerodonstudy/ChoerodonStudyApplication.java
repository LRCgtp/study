package com.cn.choerodonstudy;

import io.choerodon.base.annotation.Permission;
import io.choerodon.resource.annoation.EnableChoerodonResourceServer;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@EnableChoerodonResourceServer
public class ChoerodonStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChoerodonStudyApplication.class, args);
    }

    @GetMapping
    @Permission(permissionPublic = true)
    @ApiOperation(value = "demo")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<String>("hello world.", HttpStatus.OK);
    }
}
