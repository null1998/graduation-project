package com.hyd.basedata.dao;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class WarehouseDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Warehouse warehouse = new Warehouse();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = warehouse.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> name = warehouse.name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> code = warehouse.code;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> mnemonic = warehouse.mnemonic;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> address = warehouse.address;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> unitId = warehouse.unitId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> version = warehouse.version;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Warehouse extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> code = column("code", JDBCType.VARCHAR);

        public final SqlColumn<String> mnemonic = column("mnemonic", JDBCType.VARCHAR);

        public final SqlColumn<String> address = column("address", JDBCType.VARCHAR);

        public final SqlColumn<Long> unitId = column("unit_id", JDBCType.BIGINT);

        public final SqlColumn<Long> version = column("version", JDBCType.BIGINT);

        public Warehouse() {
            super("basedata_warehouse");
        }
    }
}