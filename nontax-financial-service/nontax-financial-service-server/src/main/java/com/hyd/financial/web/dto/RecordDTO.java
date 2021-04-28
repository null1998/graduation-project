package com.hyd.financial.web.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author yanduohuang
 * @date 2021/4/2 10:35
 */
@Data
@NoArgsConstructor
public class RecordDTO {
    private Long ticketId;
    private String ticketName;
    private Map<Integer,Long> number;

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public Map<Integer, Long> getNumber() {
        return number;
    }

    public void setNumber(Map<Integer, Long> number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "RecordDTO{" +
                "ticketId=" + ticketId +
                ", ticketName='" + ticketName + '\'' +
                ", number=" + number +
                '}';
    }
}
