package com.hyd.financial.dao;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class PrintingOrderTicketDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final PrintingOrderTicket printingOrderTicket = new PrintingOrderTicket();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = printingOrderTicket.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> printingOrderId = printingOrderTicket.printingOrderId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> ticketId = printingOrderTicket.ticketId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> number = printingOrderTicket.number;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> version = printingOrderTicket.version;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class PrintingOrderTicket extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> printingOrderId = column("printing_order_id", JDBCType.BIGINT);

        public final SqlColumn<Long> ticketId = column("ticket_id", JDBCType.BIGINT);

        public final SqlColumn<Long> number = column("number", JDBCType.BIGINT);

        public final SqlColumn<Long> version = column("version", JDBCType.BIGINT);

        public PrintingOrderTicket() {
            super("financial_printing_order_ticket");
        }
    }
}