package com.hyd.unit.dao;

import java.math.BigDecimal;
import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ClaimFormTicketDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final ClaimFormTicket claimFormTicket = new ClaimFormTicket();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = claimFormTicket.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> claimFormId = claimFormTicket.claimFormId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> ticketId = claimFormTicket.ticketId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> number = claimFormTicket.number;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<BigDecimal> price = claimFormTicket.price;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> start = claimFormTicket.start;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> end = claimFormTicket.end;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> version = claimFormTicket.version;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> warehouseInventoryId = claimFormTicket.warehouseInventoryId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class ClaimFormTicket extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> claimFormId = column("claim_form_id", JDBCType.BIGINT);

        public final SqlColumn<Long> ticketId = column("ticket_id", JDBCType.BIGINT);

        public final SqlColumn<Long> number = column("number", JDBCType.BIGINT);

        public final SqlColumn<BigDecimal> price = column("price", JDBCType.DECIMAL);

        public final SqlColumn<String> start = column("start", JDBCType.VARCHAR);

        public final SqlColumn<String> end = column("end", JDBCType.VARCHAR);

        public final SqlColumn<Long> version = column("version", JDBCType.BIGINT);

        public final SqlColumn<Long> warehouseInventoryId = column("warehouse_inventory_id", JDBCType.BIGINT);

        public ClaimFormTicket() {
            super("financial_claim_form_ticket");
        }
    }
}