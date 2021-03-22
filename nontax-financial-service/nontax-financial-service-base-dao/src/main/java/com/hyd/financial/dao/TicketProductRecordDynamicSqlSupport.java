package com.hyd.financial.dao;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class TicketProductRecordDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final TicketProductRecord ticketProductRecord = new TicketProductRecord();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = ticketProductRecord.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> orderNumber = ticketProductRecord.orderNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> printUnitId = ticketProductRecord.printUnitId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> ticketId = ticketProductRecord.ticketId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> number = ticketProductRecord.number;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> startNumber = ticketProductRecord.startNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> endNumber = ticketProductRecord.endNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> printOrderNumber = ticketProductRecord.printOrderNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> version = ticketProductRecord.version;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> createdDate = ticketProductRecord.createdDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class TicketProductRecord extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> orderNumber = column("order_number", JDBCType.BIGINT);

        public final SqlColumn<Long> printUnitId = column("print_unit_id", JDBCType.BIGINT);

        public final SqlColumn<Long> ticketId = column("ticket_id", JDBCType.BIGINT);

        public final SqlColumn<Integer> number = column("number", JDBCType.INTEGER);

        public final SqlColumn<String> startNumber = column("start_number", JDBCType.VARCHAR);

        public final SqlColumn<String> endNumber = column("end_number", JDBCType.VARCHAR);

        public final SqlColumn<Long> printOrderNumber = column("print_order_number", JDBCType.BIGINT);

        public final SqlColumn<Long> version = column("version", JDBCType.BIGINT);

        public final SqlColumn<String> createdDate = column("created_date", JDBCType.VARCHAR);

        public TicketProductRecord() {
            super("financial_ticket_product_record");
        }
    }
}