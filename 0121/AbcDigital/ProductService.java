package AbcDigital;

import java.util.Scanner;

public class ProductService {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TvModel tvModel = new TvModel();
        RefrigModel refrigModel = new RefrigModel();

        System.out.println("TV 정보를 시리얼 넘버, 모델명, 가격, 재고, 인치 순으로 입력하세요");

        String serialNumber = scanner.next();
        tvModel.setSerialNumber(serialNumber);

        String modelName = scanner.nextLine();
        tvModel.setModelName(modelName);

        int price = scanner.nextInt();
        tvModel.setPrice(price);

        int stockNumber = scanner.nextInt();
        tvModel.setStockNumber(stockNumber);

        int inch = scanner.nextInt();
        tvModel.setInch(inch);

        System.out.println("냉장고 정보를 시리얼 넘버, 모델명, 가격, 재고, 용량 순으로 입력하세요");

        serialNumber = scanner.next();
        refrigModel.setSerialNumber(serialNumber);

        modelName = scanner.nextLine();
        refrigModel.setModelName(modelName);

        price = scanner.nextInt();
        refrigModel.setPrice(price);

        stockNumber = scanner.nextInt();
        refrigModel.setStockNumber(stockNumber);

        int volume = scanner.nextInt();
        refrigModel.setVolume(volume);

        System.out.println("시리얼넘버\t모델명\t가격\t재고\t기타사항");
        System.out.println(tvModel.toString());
        System.out.println(refrigModel.toString());
    }
}
