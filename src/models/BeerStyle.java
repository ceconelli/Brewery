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
public class BeerStyle {
    private int beerStyleCode;
    private String BeerStyleName;

    public BeerStyle(int beerStyleCode, String BeerStyleName) {
        this.beerStyleCode = beerStyleCode;
        this.BeerStyleName = BeerStyleName;
    }

    public int getBeerStyleCode() {
        return beerStyleCode;
    }

    public void setBeerStyleCode(int beerStyleCode) {
        this.beerStyleCode = beerStyleCode;
    }

    public String getBeerStyleName() {
        return BeerStyleName;
    }

    public void setBeerStyleName(String BeerStyleName) {
        this.BeerStyleName = BeerStyleName;
    }

    @Override
    public String toString() {
        return "BeerStyle{" + "beerStyleCode=" + beerStyleCode + ", BeerStyleName=" + BeerStyleName + '}';
    }
    
    
}
