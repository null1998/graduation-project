package com.hyd.financial.dao;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ClaimFormDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final ClaimForm claimForm = new ClaimForm();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = claimForm.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> orderNumber = claimForm.orderNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> claimDate = claimForm.claimDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> claimUnitId = claimForm.claimUnitId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> claimPerson = claimForm.claimPerson;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> claimWarehouseId = claimForm.claimWarehouseId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> remark = claimForm.remark;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> checkOpinion = claimForm.checkOpinion;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> successDate = claimForm.successDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> status = claimForm.status;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> version = claimForm.version;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class ClaimForm extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> orderNumber = column("order_number", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> claimDate = column("claim_date", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> claimUnitId = column("claim_unit_id", JDBCType.BIGINT);

        public final SqlColumn<String> claimPerson = column("claim_person", JDBCType.VARCHAR);

        public final SqlColumn<Long> claimWarehouseId = column("claim_warehouse_id", JDBCType.BIGINT);

        public final SqlColumn<String> remark = column("remark", JDBCType.VARCHAR);

        public final SqlColumn<String> checkOpinion = column("check_opinion", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> successDate = column("success_date", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> status = column("status", JDBCType.INTEGER);

        public final SqlColumn<Long> version = column("version", JDBCType.BIGINT);

        public ClaimForm() {
            super("financial_claim_form");
        }
    }
}