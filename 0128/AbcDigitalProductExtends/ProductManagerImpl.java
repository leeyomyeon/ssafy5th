package AbcDigitalProductExtends;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class ProductManagerImpl extends Thread implements ProductMgrImpl {
    private static ProductManagerImpl instance;
    public static ProductManagerImpl getInstance() {
        if(instance == null) {
            instance = new ProductManagerImpl();
        }
        return instance;
    }

    private ArrayList<Product> product;

    private ProductManagerImpl() {
        product = new ArrayList<>();
    }

    public void addProduct(Product p) {
        for(int i = 0; i < product.size(); i++) {
            if(p.getProductNum() == product.get(i).getProductNum()) {
                throw new DuplicateException();
            }
        }
        product.add(p);
    }

    public String deleteProduct(int productNum) {
        for(int i = 0; i < product.size(); i++) {
            if(product.get(i).getProductNum() == productNum) {
                product.remove(i);
                return "상품번호 "+productNum+"의 상품이 삭제되었습니다.";
            }
        }

        throw new CodeNotFoundException();
    }

    public Product selectProduct(int productNum) {
        for(int i = 0; i < product.size(); i++) {
            if(productNum == product.get(i).getProductNum()) {
                return product.get(i);
            }
        }

        throw new CodeNotFoundException();
    }

    public ArrayList<Product> getProductList(String keyWord) {
        ArrayList<Product> selectList = new ArrayList<>();

        for(int i = 0; i < product.size(); i++) {
            if(product.get(i).getProductName().contains(keyWord)) {
                selectList.add(product.get(i));
            }
        }

        if(selectList.size() == 0) {
            throw new ProductNotFoundException();
        }

        return selectList;
    }

    public ArrayList<Product> getTvList() {
        ArrayList<Product> tvList = new ArrayList<>();

        for(int i = 0; i < product.size(); i++) {
            if(product.get(i) instanceof Tv) {
                tvList.add(product.get(i));
            }
        }

        if(tvList.size() == 0) {
            throw new ProductNotFoundException();
        } else {
            return tvList;
        }
    }

    public ArrayList<Product> getTvList(int inch) {
        ArrayList<Product> tvList = new ArrayList<>();

        for(int i = 0; i < product.size(); i++) {
            if(product.get(i) instanceof Tv && ((Tv) product.get(i)).getInch() >= inch) {
                tvList.add(product.get(i));
            }
        }

        if(tvList.size() == 0) {
            throw new ProductNotFoundException();
        } else {
            return tvList;
        }
    }

    public ArrayList<Product> getRefList() {
        ArrayList<Product> refList = new ArrayList<>();

        for(int i = 0; i < product.size(); i++) {
            if(product.get(i) instanceof Refrigerator) {
                refList.add(product.get(i));
            }
        }

        if(refList.size() == 0) {
            throw new ProductNotFoundException();
        } else {
            return refList;
        }
    }

    public ArrayList<Product> getRefList(int liter) {
        ArrayList<Product> refList = new ArrayList<>();

        for(int i = 0; i < product.size(); i++) {
            if(product.get(i) instanceof Refrigerator && ((Refrigerator) product.get(i)).getVolume() >= liter) {
                refList.add(product.get(i));
            }
        }

        if(refList.size() == 0) {
            throw new ProductNotFoundException();
        } else {
            return refList;
        }
    }

    public String getPriceList() {
        if(product.size() == 0) {
            throw new ProductNotFoundException();
        } else {
            int sum = 0;
            int count = 0;

            for(int i = 0; i < product.size(); i++) {
                count += product.get(i).getStock();
                sum += (product.get(i).getStock() * product.get(i).getPrice());
            }

            return "총 " + count + "개 " + sum + "원 입니다." ;
        }
    }

    public void updateProduct(int productNum, int price) {
        if(price < 0) {
            throw new InputMismatchException();
        }

        for(int i = 0; i < product.size(); i++) {
            if(product.get(i).getProductNum() == productNum) {
                product.get(i).setPrice(price);
            }
        }

        throw new CodeNotFoundException();
    }

    public void run() {
        try {
            ObjectOutputStream oOut = new ObjectOutputStream(new FileOutputStream("/Users/iyomyeon/Desktop/SSAFY/product.dat"));
            oOut.writeObject(product);
            oOut.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void save() {
        // not used
    }

    public void load() {
        try {
            ObjectInputStream oIn = new ObjectInputStream(new FileInputStream("/Users/iyomyeon/Desktop/SSAFY/product.dat"));
            product = (ArrayList<Product>) oIn.readObject();
        } catch (FileNotFoundException e) {
            product = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }
}

