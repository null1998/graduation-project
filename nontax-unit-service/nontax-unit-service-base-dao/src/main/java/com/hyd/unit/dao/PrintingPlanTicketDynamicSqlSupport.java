package com.hyd.unit.dao;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class PrintingPlanTicketDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final PrintingPlanTicket printingPlanTicket = new PrintingPlanTicket();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = printingPlanTicket.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> printingPlanId = printingPlanTicket.printingPlanId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> ticketId = printingPlanTicket.ticketId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> theFirstSeason = printingPlanTicket.theFirstSeason;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> theSecondSeason = printingPlanTicket.theSecondSeason;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> theThirdSeason = printingPlanTicket.theThirdSeason;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> theFourthSeason = printingPlanTicket.theFourthSeason;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> lastYear = printingPlanTicket.lastYear;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> version = printingPlanTicket.version;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class PrintingPlanTicket extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> printingPlanId = column("printing_plan_id", JDBCType.BIGINT);

        public final SqlColumn<Long> ticketId = column("ticket_id", JDBCType.BIGINT);

        public final SqlColumn<Long> theFirstSeason = column("the_first_season", JDBCType.BIGINT);

        public final SqlColumn<Long> theSecondSeason = column("the_second_season", JDBCType.BIGINT);

        public final SqlColumn<Long> theThirdSeason = column("the_third_season", JDBCType.BIGINT);

        public final SqlColumn<Long> theFourthSeason = column("the_fourth_season", JDBCType.BIGINT);

        public final SqlColumn<Long> lastYear = column("last_year", JDBCType.BIGINT);

        public final SqlColumn<Long> version = column("version", JDBCType.BIGINT);

        public PrintingPlanTicket() {
            super("financial_printing_plan_ticket");
        }
    }
}