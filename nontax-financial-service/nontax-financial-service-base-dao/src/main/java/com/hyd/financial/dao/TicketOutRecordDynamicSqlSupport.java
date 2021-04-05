package com.hyd.financial.dao;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class TicketOutRecordDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final TicketOutRecord ticketOutRecord = new TicketOutRecord();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = ticketOutRecord.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> orderNumber = ticketOutRecord.orderNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> targetOrderNumber = ticketOutRecord.targetOrderNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> unitId = ticketOutRecord.unitId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> targetUnitId = ticketOutRecord.targetUnitId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> outType = ticketOutRecord.outType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> outDate = ticketOutRecord.outDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> version = ticketOutRecord.version;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class TicketOutRecord extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> orderNumber = column("order_number", JDBCType.BIGINT);

        public final SqlColumn<Long> targetOrderNumber = column("target_order_number", JDBCType.BIGINT);

        public final SqlColumn<Long> unitId = column("unit_id", JDBCType.BIGINT);

        public final SqlColumn<Long> targetUnitId = column("target_unit_id", JDBCType.BIGINT);

        public final SqlColumn<String> outType = column("out_type", JDBCType.VARCHAR);

        public final SqlColumn<String> outDate = column("out_date", JDBCType.VARCHAR);

        public final SqlColumn<Long> version = column("version", JDBCType.BIGINT);

        public TicketOutRecord() {
            super("financial_ticket_out_record");
        }
    }
}