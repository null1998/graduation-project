package com.hyd.financial.web.qo;

import com.hyd.common.core.pojo.qo.BaseQO;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yanduohuang
 * @date 2021/3/21 22:54
 */
@Data
@NoArgsConstructor
public class TicketProductRecordQO  extends BaseQO {
    private Long id;
    private Long ticketId;
    private Long printOrderNumber;
    private Long printUnitId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Long getPrintOrderNumber() {
        return printOrderNumber;
    }

    public void setPrintOrderNumber(Long printOrderNumber) {
        this.printOrderNumber = printOrderNumber;
    }

    public Long getPrintUnitId() {
        return printUnitId;
    }

    public void setPrintUnitId(Long printUnitId) {
        this.printUnitId = printUnitId;
    }

    @Override
    public String toString() {
        return "TicketProductRecordQO{" +
                "id=" + id +
                ", ticketId=" + ticketId +
                ", printOrderNumber=" + printOrderNumber +
                ", printUnitId=" + printUnitId +
                "} " + super.toString();
    }
}
