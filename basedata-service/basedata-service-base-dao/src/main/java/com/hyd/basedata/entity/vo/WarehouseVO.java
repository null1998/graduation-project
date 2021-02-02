package com.hyd.basedata.entity.vo;


/**
 * @author yanduohuang
 * @date 2021/2/1 16:56
 */
public class WarehouseVO {

    private String name;

    private String code;

    private String mnemonic;

    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "WarehouseVO{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", mnemonic='" + mnemonic + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
