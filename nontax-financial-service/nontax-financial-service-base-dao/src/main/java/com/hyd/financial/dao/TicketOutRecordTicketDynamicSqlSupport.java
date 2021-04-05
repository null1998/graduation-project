package com.hyd.financial.dao;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class TicketOutRecordTicketDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final TicketOutRecordTicket ticketOutRecordTicket = new TicketOutRecordTicket();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = ticketOutRecordTicket.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> ticketOutRecordId = ticketOutRecordTicket.ticketOutRecordId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> ticketId = ticketOutRecordTicket.ticketId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> startNumber = ticketOutRecordTicket.startNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> endNumber = ticketOutRecordTicket.endNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> number = ticketOutRecordTicket.number;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> version = ticketOutRecordTicket.version;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class TicketOutRecordTicket extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> ticketOutRecordId = column("ticket_out_record_id", JDBCType.BIGINT);

        public final SqlColumn<Long> ticketId = column("ticket_id", JDBCType.BIGINT);

        public final SqlColumn<String> startNumber = column("start_number", JDBCType.VARCHAR);

        public final SqlColumn<String> endNumber = column("end_number", JDBCType.VARCHAR);

        public final SqlColumn<Long> number = column("number", JDBCType.BIGINT);

        public final SqlColumn<Long> version = column("version", JDBCType.BIGINT);

        public TicketOutRecordTicket() {
            super("financial_ticket_out_record_ticket");
        }
    }
}