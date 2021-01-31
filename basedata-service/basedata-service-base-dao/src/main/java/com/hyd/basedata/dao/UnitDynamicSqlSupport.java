package com.hyd.basedata.dao;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UnitDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Unit unit = new Unit();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = unit.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> parentUnit = unit.parentUnit;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> name = unit.name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> code = unit.code;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> unitSort = unit.unitSort;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> parentDepartment = unit.parentDepartment;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> unitType = unit.unitType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Byte> printStatus = unit.printStatus;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> mnemonicCode = unit.mnemonicCode;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> master = unit.master;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> tax = unit.tax;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> fax = unit.fax;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> tel = unit.tel;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> address = unit.address;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> email = unit.email;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> website = unit.website;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> remark = unit.remark;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> tenantId = unit.tenantId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> zoneId = unit.zoneId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> createdBy = unit.createdBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> creator = unit.creator;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> createdTime = unit.createdTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> updatedBy = unit.updatedBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> modifier = unit.modifier;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> updatedTime = unit.updatedTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Byte> status = unit.status;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> version = unit.version;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Unit extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> parentUnit = column("parent_unit", JDBCType.BIGINT);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> code = column("code", JDBCType.VARCHAR);

        public final SqlColumn<String> unitSort = column("unit_sort", JDBCType.VARCHAR);

        public final SqlColumn<String> parentDepartment = column("parent_department", JDBCType.VARCHAR);

        public final SqlColumn<String> unitType = column("unit_type", JDBCType.VARCHAR);

        public final SqlColumn<Byte> printStatus = column("print_status", JDBCType.TINYINT);

        public final SqlColumn<String> mnemonicCode = column("mnemonic_code", JDBCType.VARCHAR);

        public final SqlColumn<String> master = column("master", JDBCType.VARCHAR);

        public final SqlColumn<String> tax = column("tax", JDBCType.VARCHAR);

        public final SqlColumn<String> fax = column("fax", JDBCType.VARCHAR);

        public final SqlColumn<String> tel = column("tel", JDBCType.VARCHAR);

        public final SqlColumn<String> address = column("address", JDBCType.VARCHAR);

        public final SqlColumn<String> email = column("email", JDBCType.VARCHAR);

        public final SqlColumn<String> website = column("website", JDBCType.VARCHAR);

        public final SqlColumn<String> remark = column("remark", JDBCType.VARCHAR);

        public final SqlColumn<Long> tenantId = column("tenant_id", JDBCType.BIGINT);

        public final SqlColumn<Long> zoneId = column("zone_id", JDBCType.BIGINT);

        public final SqlColumn<Long> createdBy = column("created_by", JDBCType.BIGINT);

        public final SqlColumn<String> creator = column("creator", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> createdTime = column("created_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> updatedBy = column("updated_by", JDBCType.BIGINT);

        public final SqlColumn<String> modifier = column("modifier", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> updatedTime = column("updated_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Byte> status = column("status", JDBCType.TINYINT);

        public final SqlColumn<Long> version = column("version", JDBCType.BIGINT);

        public Unit() {
            super("basic_unit");
        }
    }
}