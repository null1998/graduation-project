package com.hyd.basedata.web.qo;

import com.hyd.common.core.pojo.qo.BaseQO;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yanduohuang
 * @date 2021/3/21 0:24
 */
@Data
@NoArgsConstructor
public class TicketQO  extends BaseQO {
    private Long id;
    private Long zoneId;
    private String year;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "TicketQO{" +
                "id=" + id +
                ", zoneId=" + zoneId +
                ", year='" + year + '\'' +
                ", name='" + name + '\'' +
                "} " + super.toString();
    }
}
