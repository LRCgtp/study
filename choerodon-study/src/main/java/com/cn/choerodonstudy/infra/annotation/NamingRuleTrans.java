package com.cn.choerodonstudy.infra.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface NamingRuleTrans {
    public NamingRuleTransStrategy value() default NamingRuleTransStrategy.CAMEL;
}