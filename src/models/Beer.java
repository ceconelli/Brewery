package models;

/**
 *
 * @author gceconelli
 */
public class Beer {
    private int cod_beer;
    private double alcohol_content;
    private double price;
    private Brand brand;
    private BeerStyle style;

    public Beer(int cod_beer, double alcohol_content, double price, Brand brand, BeerStyle style) {
        this.cod_beer = cod_beer;
        this.alcohol_content = alcohol_content;
        this.price = price;
        this.brand = brand;
        this.style = style;
    }

    public int getCod_beer() {
        return cod_beer;
    }

    public void setCod_beer(int cod_beer) {
        this.cod_beer = cod_beer;
    }

    public double getAlcohol_content() {
        return alcohol_content;
    }

    public void setAlcohol_content(double alcohol_content) {
        this.alcohol_content = alcohol_content;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public BeerStyle getStyle() {
        return style;
    }

    public void setStyle(BeerStyle style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return "Beer{" + "cod_beer=" + cod_beer + ", alcohol_content=" + alcohol_content + ", price=" + price + ", brand=" + brand + ", style=" + style + '}';
    }
    
    
    
    
    
}
