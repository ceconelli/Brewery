/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author gceconelli
 */
public class Brand {
    private int brandCode;
    private String brandName;

    public Brand(int brandCode, String brandName) {
        this.brandCode = brandCode;
        this.brandName = brandName;
    }

    public int getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(int brandCode) {
        this.brandCode = brandCode;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "Brand{" + "brandCode=" + brandCode + ", brandName=" + brandName + '}';
    }
    
    
}
