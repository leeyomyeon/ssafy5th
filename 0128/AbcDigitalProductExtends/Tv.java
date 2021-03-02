package AbcDigitalProductExtends;

import java.io.Serializable;

public class Tv extends Product {
    private int inch;

    public int getInch() {
        return inch;
    }

    public void setInch(int inch) {
        this.inch = inch;
    }

    @Override
    public String toString() {
        return "|"+super.getProductNum()+"\t|"+super.getProductName()+"\t\t|"
                +super.getPrice()+"\t|"+super.getStock()+"\t\t|"+this.inch+"inch\t|";
    }
}
