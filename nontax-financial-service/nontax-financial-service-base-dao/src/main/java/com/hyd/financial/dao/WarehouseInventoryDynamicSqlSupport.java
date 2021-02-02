package com.hyd.financial.dao;

import java.math.BigDecimal;
import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class WarehouseInventoryDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final WarehouseInventory warehouseInventory = new WarehouseInventory();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = warehouseInventory.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> warehouseId = warehouseInventory.warehouseId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> ticketId = warehouseInventory.ticketId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> number = warehouseInventory.number;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<BigDecimal> price = warehouseInventory.price;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> start = warehouseInventory.start;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> end = warehouseInventory.end;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> version = warehouseInventory.version;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> status = warehouseInventory.status;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class WarehouseInventory extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> warehouseId = column("warehouse_id", JDBCType.BIGINT);

        public final SqlColumn<Long> ticketId = column("ticket_id", JDBCType.BIGINT);

        public final SqlColumn<Long> number = column("number", JDBCType.BIGINT);

        public final SqlColumn<BigDecimal> price = column("price", JDBCType.DECIMAL);

        public final SqlColumn<String> start = column("start", JDBCType.VARCHAR);

        public final SqlColumn<String> end = column("end", JDBCType.VARCHAR);

        public final SqlColumn<Long> version = column("version", JDBCType.BIGINT);

        public final SqlColumn<Integer> status = column("status", JDBCType.INTEGER);

        public WarehouseInventory() {
            super("financial_warehouse_inventory");
        }
    }
}