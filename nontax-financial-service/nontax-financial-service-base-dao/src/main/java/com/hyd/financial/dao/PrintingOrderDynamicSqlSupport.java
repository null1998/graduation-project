package com.hyd.financial.dao;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class PrintingOrderDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final PrintingOrder printingOrder = new PrintingOrder();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = printingOrder.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> ordernumber = printingOrder.ordernumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> start = printingOrder.start;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> end = printingOrder.end;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> unitId = printingOrder.unitId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> printUnitId = printingOrder.printUnitId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> warehouseId = printingOrder.warehouseId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> version = printingOrder.version;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> status = printingOrder.status;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class PrintingOrder extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> ordernumber = column("orderNumber", JDBCType.BIGINT);

        public final SqlColumn<String> start = column("start", JDBCType.VARCHAR);

        public final SqlColumn<String> end = column("end", JDBCType.VARCHAR);

        public final SqlColumn<Long> unitId = column("unit_id", JDBCType.BIGINT);

        public final SqlColumn<Long> printUnitId = column("print_unit_id", JDBCType.BIGINT);

        public final SqlColumn<Long> warehouseId = column("warehouse_id", JDBCType.BIGINT);

        public final SqlColumn<Long> version = column("version", JDBCType.BIGINT);

        public final SqlColumn<Integer> status = column("status", JDBCType.INTEGER);

        public PrintingOrder() {
            super("financial_printing_order");
        }
    }
}