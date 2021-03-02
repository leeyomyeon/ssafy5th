package AbcDigitalProductExtends;

import java.io.Serializable;

public class Product implements Serializable {
    private int productNum;
    private String productName;
    private int price;
    private int stock;

    public int getProductNum() {
        return productNum;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String toString() {
        return "|"+productNum+"\t|"+productName+"\t\t|"+price+"\t|"+stock+"\t\t|";
    }
}
