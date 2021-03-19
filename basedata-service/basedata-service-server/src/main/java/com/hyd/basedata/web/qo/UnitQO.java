package com.hyd.basedata.web.qo;

/**
 * @author yanduohuang
 * @date 2021/3/19 1:09
 */
public class UnitQO {
    private Long id;
    private Long zoneId;
    private Long dictionaryId;

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

    public Long getDictionaryId() {
        return dictionaryId;
    }

    public void setDictionaryId(Long dictionaryId) {
        this.dictionaryId = dictionaryId;
    }

    @Override
    public String toString() {
        return "UnitQO{" +
                "id=" + id +
                ", zoneId=" + zoneId +
                ", dictionaryId=" + dictionaryId +
                '}';
    }
}
