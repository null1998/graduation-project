package com.hyd.user.center.dao;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class RoleRelateDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final RoleRelate roleRelate = new RoleRelate();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = roleRelate.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> parentRoleId = roleRelate.parentRoleId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> childRoleId = roleRelate.childRoleId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> version = roleRelate.version;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class RoleRelate extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> parentRoleId = column("parent_role_id", JDBCType.BIGINT);

        public final SqlColumn<Long> childRoleId = column("child_role_id", JDBCType.BIGINT);

        public final SqlColumn<Long> version = column("version", JDBCType.BIGINT);

        public RoleRelate() {
            super("user_center_role_relate");
        }
    }
}