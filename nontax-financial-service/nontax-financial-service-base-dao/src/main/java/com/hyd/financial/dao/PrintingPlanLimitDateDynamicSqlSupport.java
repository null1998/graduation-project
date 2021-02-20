package com.hyd.financial.dao;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class PrintingPlanLimitDateDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final PrintingPlanLimitDate printingPlanLimitDate = new PrintingPlanLimitDate();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = printingPlanLimitDate.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> year = printingPlanLimitDate.year;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> startDate = printingPlanLimitDate.startDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> endDate = printingPlanLimitDate.endDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> unitId = printingPlanLimitDate.unitId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> version = printingPlanLimitDate.version;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class PrintingPlanLimitDate extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Integer> year = column("year", JDBCType.INTEGER);

        public final SqlColumn<LocalDateTime> startDate = column("start_date", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> endDate = column("end_date", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> unitId = column("unit_id", JDBCType.BIGINT);

        public final SqlColumn<Long> version = column("version", JDBCType.BIGINT);

        public PrintingPlanLimitDate() {
            super("financial_printing_plan_limit_date");
        }
    }
}