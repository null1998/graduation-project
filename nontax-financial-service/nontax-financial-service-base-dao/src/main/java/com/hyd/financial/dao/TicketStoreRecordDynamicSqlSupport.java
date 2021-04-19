package com.hyd.financial.dao;

import java.sql.JDBCType;
import java.time.LocalDate;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class TicketStoreRecordDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final TicketStoreRecord ticketStoreRecord = new TicketStoreRecord();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = ticketStoreRecord.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> orderNumber = ticketStoreRecord.orderNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> sourceOrderNumber = ticketStoreRecord.sourceOrderNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> unitId = ticketStoreRecord.unitId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> sourceUnitId = ticketStoreRecord.sourceUnitId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> sourceWarehouseId = ticketStoreRecord.sourceWarehouseId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> version = ticketStoreRecord.version;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> dictionaryId = ticketStoreRecord.dictionaryId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDate> storeDate = ticketStoreRecord.storeDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> storeType = ticketStoreRecord.storeType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class TicketStoreRecord extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> orderNumber = column("order_number", JDBCType.BIGINT);

        public final SqlColumn<Long> sourceOrderNumber = column("source_order_number", JDBCType.BIGINT);

        public final SqlColumn<Long> unitId = column("unit_id", JDBCType.BIGINT);

        public final SqlColumn<Long> sourceUnitId = column("source_unit_id", JDBCType.BIGINT);

        public final SqlColumn<Long> sourceWarehouseId = column("source_warehouse_id", JDBCType.BIGINT);

        public final SqlColumn<Long> version = column("version", JDBCType.BIGINT);

        public final SqlColumn<Long> dictionaryId = column("dictionary_id", JDBCType.BIGINT);

        public final SqlColumn<LocalDate> storeDate = column("store_date", JDBCType.DATE);

        public final SqlColumn<String> storeType = column("store_type", JDBCType.VARCHAR);

        public TicketStoreRecord() {
            super("financial_ticket_store_record");
        }
    }
}