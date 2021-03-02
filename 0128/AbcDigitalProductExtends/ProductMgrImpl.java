package AbcDigitalProductExtends;

import java.util.ArrayList;

public interface ProductMgrImpl {
    void addProduct(Product p);

    String deleteProduct(int productNum);

    Product selectProduct(int productNum);

    ArrayList<Product> getProductList(String keyWord);

    ArrayList<Product> getTvList();

    ArrayList<Product> getTvList(int inch);

    ArrayList<Product> getRefList();

    ArrayList<Product> getRefList(int liter);

    void updateProduct(int productNum, int price);

    String getPriceList();

    void save();

    void load();
}

