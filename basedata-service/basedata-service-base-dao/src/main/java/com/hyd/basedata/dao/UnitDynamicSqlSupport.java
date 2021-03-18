package com.hyd.basedata.dao;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UnitDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Unit unit = new Unit();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = unit.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> name = unit.name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> code = unit.code;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> mnemonic = unit.mnemonic;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> master = unit.master;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> taxNumber = unit.taxNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> faxNumber = unit.faxNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> telNumber = unit.telNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> address = unit.address;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> email = unit.email;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> website = unit.website;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> zoneId = unit.zoneId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> parentId = unit.parentId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> version = unit.version;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> dictionaryId = unit.dictionaryId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Unit extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> code = column("code", JDBCType.VARCHAR);

        public final SqlColumn<String> mnemonic = column("mnemonic", JDBCType.VARCHAR);

        public final SqlColumn<String> master = column("master", JDBCType.VARCHAR);

        public final SqlColumn<String> taxNumber = column("tax_number", JDBCType.VARCHAR);

        public final SqlColumn<String> faxNumber = column("fax_number", JDBCType.VARCHAR);

        public final SqlColumn<String> telNumber = column("tel_number", JDBCType.VARCHAR);

        public final SqlColumn<String> address = column("address", JDBCType.VARCHAR);

        public final SqlColumn<String> email = column("email", JDBCType.VARCHAR);

        public final SqlColumn<String> website = column("website", JDBCType.VARCHAR);

        public final SqlColumn<Long> zoneId = column("zone_id", JDBCType.BIGINT);

        public final SqlColumn<Long> parentId = column("parent_id", JDBCType.BIGINT);

        public final SqlColumn<Long> version = column("version", JDBCType.BIGINT);

        public final SqlColumn<Long> dictionaryId = column("dictionary_id", JDBCType.BIGINT);

        public Unit() {
            super("basedata_unit");
        }
    }
}