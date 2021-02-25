package com.hyd.unit.dao;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class SettlementDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Settlement settlement = new Settlement();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = settlement.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> bussinessDictionaryId = settlement.bussinessDictionaryId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> bussinessOrderNumber = settlement.bussinessOrderNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> settlementDate = settlement.settlementDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> settlementUnit = settlement.settlementUnit;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> settlementTypeDictionaryId = settlement.settlementTypeDictionaryId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> unitId = settlement.unitId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> status = settlement.status;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> version = settlement.version;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Settlement extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> bussinessDictionaryId = column("bussiness_dictionary_id", JDBCType.BIGINT);

        public final SqlColumn<Long> bussinessOrderNumber = column("bussiness_order_number", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> settlementDate = column("settlement_date", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> settlementUnit = column("settlement_unit", JDBCType.BIGINT);

        public final SqlColumn<Long> settlementTypeDictionaryId = column("settlement_type_dictionary_id", JDBCType.BIGINT);

        public final SqlColumn<Long> unitId = column("unit_id", JDBCType.BIGINT);

        public final SqlColumn<Integer> status = column("status", JDBCType.INTEGER);

        public final SqlColumn<Long> version = column("version", JDBCType.BIGINT);

        public Settlement() {
            super("financial_settlement");
        }
    }
}