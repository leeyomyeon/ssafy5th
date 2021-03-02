package AbcDigitalProductExtends;

public class Refrigerator extends Product{

    private int volume;

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "|"+super.getProductNum()+"\t|"+super.getProductName()+"\t\t|"
                +super.getPrice()+"\t|"+super.getStock()+"\t\t|"+ this.getVolume() +"liter\t|";
    }
}
