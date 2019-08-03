package com.cn.choerodonstudy.infra.enums;

/**
 * MemberType for table iam_member_role
 *
 * @author zmf
 */
public enum MemberType {
    CLIENT("client"),
    USER("user");

    private final String value;

    MemberType(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
