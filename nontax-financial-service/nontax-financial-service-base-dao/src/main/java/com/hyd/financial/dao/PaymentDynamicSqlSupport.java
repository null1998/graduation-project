package com.hyd.financial.dao;

import java.math.BigDecimal;
import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class PaymentDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Payment payment = new Payment();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = payment.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> orderNumber = payment.orderNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> sourceOrderNumber = payment.sourceOrderNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> srcUnitId = payment.srcUnitId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> desUnitId = payment.desUnitId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<BigDecimal> totalPrice = payment.totalPrice;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> orderType = payment.orderType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> date = payment.date;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> payDate = payment.payDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> status = payment.status;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> version = payment.version;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> paytype = payment.paytype;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Payment extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> orderNumber = column("order_number", JDBCType.BIGINT);

        public final SqlColumn<Long> sourceOrderNumber = column("source_order_number", JDBCType.BIGINT);

        public final SqlColumn<Long> srcUnitId = column("src_unit_id", JDBCType.BIGINT);

        public final SqlColumn<Long> desUnitId = column("des_unit_id", JDBCType.BIGINT);

        public final SqlColumn<BigDecimal> totalPrice = column("total_price", JDBCType.DECIMAL);

        public final SqlColumn<String> orderType = column("order_type", JDBCType.VARCHAR);

        public final SqlColumn<String> date = column("date", JDBCType.VARCHAR);

        public final SqlColumn<String> payDate = column("pay_date", JDBCType.VARCHAR);

        public final SqlColumn<Integer> status = column("status", JDBCType.INTEGER);

        public final SqlColumn<Long> version = column("version", JDBCType.BIGINT);

        public final SqlColumn<String> paytype = column("payType", JDBCType.VARCHAR);

        public Payment() {
            super("financial_payment");
        }
    }
}