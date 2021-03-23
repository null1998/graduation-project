package com.hyd.financial.dao;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class TicketStoreRecordTicketDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final TicketStoreRecordTicket ticketStoreRecordTicket = new TicketStoreRecordTicket();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = ticketStoreRecordTicket.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> ticketStoreRecordId = ticketStoreRecordTicket.ticketStoreRecordId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> ticketId = ticketStoreRecordTicket.ticketId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> startNumber = ticketStoreRecordTicket.startNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> endNumber = ticketStoreRecordTicket.endNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> number = ticketStoreRecordTicket.number;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> version = ticketStoreRecordTicket.version;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class TicketStoreRecordTicket extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> ticketStoreRecordId = column("ticket_store_record_id", JDBCType.BIGINT);

        public final SqlColumn<Long> ticketId = column("ticket_id", JDBCType.BIGINT);

        public final SqlColumn<String> startNumber = column("start_number", JDBCType.VARCHAR);

        public final SqlColumn<String> endNumber = column("end_number", JDBCType.VARCHAR);

        public final SqlColumn<Long> number = column("number", JDBCType.BIGINT);

        public final SqlColumn<Long> version = column("version", JDBCType.BIGINT);

        public TicketStoreRecordTicket() {
            super("financial_ticket_store_record_ticket");
        }
    }
}