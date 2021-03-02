package AbcDigitalProductExtends;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManagerImpl manager = ProductManagerImpl.getInstance();
        String menu = "|상품번호\t|상품명\t\t|가격\t|수량\t|기타\t|";
        String bar = "-------------------------------------";

        manager.load();

        int sel;
        do {
            System.out.println("1. 상품 등록");
            System.out.println("2. 전체 상품 조회");
            System.out.println("3. 상품번호로 조회");
            System.out.println("4. 상품명으로 조회(부분검색 가능)");
            System.out.println("5. TV 정보 조회");
            System.out.println("6. 냉장고 정보 조회");
            System.out.println("7. 상품번호로 삭제");
            System.out.println("8. 재고가 있는 상품의 총 금액");
            System.out.println("0. 종료");
            sel = scanner.nextInt();

            if(sel == 1) {
                System.out.println("******************** 1. 상품 등록 ********************");
                System.out.println("1. TV 2. 냉장고 0. 돌아가기");
                int t = scanner.nextInt();

                try {
                    if(t == 1) {
                        Tv tvProduct = new Tv();
                        System.out.println("상품번호 입력 : ");
                        int productNum = scanner.nextInt();
                        tvProduct.setProductNum(productNum);

                        System.out.println("상품이름 입력 : ");
                        String productName = scanner.next();
                        tvProduct.setProductName(productName);

                        System.out.println("상품가격 입력 : ");
                        int price = scanner.nextInt();
                        tvProduct.setPrice(price);

                        System.out.print("재고수량 입력 : ");
                        int stock = scanner.nextInt();
                        tvProduct.setStock(stock);

                        System.out.print("인치 수 입력 : ");
                        int inch = scanner.nextInt();
                        tvProduct.setInch(inch);

                        manager.addProduct(tvProduct);
                    } else if (t == 2) {
                        Refrigerator refProduct = new Refrigerator();
                        System.out.println("상품번호 입력 : ");
                        int productNum = scanner.nextInt();
                        refProduct.setProductNum(productNum);

                        System.out.println("상품이름 입력 : ");
                        String productName = scanner.next();
                        refProduct.setProductName(productName);

                        System.out.println("상품가격 입력 : ");
                        int price = scanner.nextInt();
                        refProduct.setPrice(price);

                        System.out.print("재고수량 입력 : ");
                        int stock = scanner.nextInt();
                        refProduct.setStock(stock);

                        System.out.print("용량 입력 : ");
                        int volume = scanner.nextInt();
                        refProduct.setVolume(volume);

                        manager.addProduct(refProduct);
                    }
                } catch(DuplicateException e) {
                    System.out.println("상품번호가 중복됩니다.");
                }

            } else if (sel == 2) {
                System.out.println("****************** 4. 전체상품 조회 ******************");

                System.out.println(menu);
                System.out.println(bar);

                ArrayList<Product> tvList = manager.getTvList();
                ArrayList<Product> refList = manager.getRefList();
                if(tvList.size() == 0 && refList.size() == 0) {
                    System.out.println("등록된 상품이 없습니다.");
                } else {
                    for(int i = 0; i < tvList.size(); i++) {
                        System.out.println(tvList.get(i));
                    }
                    for(int i = 0; i < refList.size(); i++) {
                        System.out.println(refList.get(i));
                    }
                }

            } else if (sel == 3) {
                System.out.println("******************** 3. 상품 조회 ********************");
                System.out.println("조회할 상품 번호를 입력하세요.");

                int productNum = scanner.nextInt();

                try {
                    Product selectedProduct = manager.selectProduct(productNum);
                    System.out.println(menu);
                    System.out.println(bar);
                    System.out.println(selectedProduct);
                } catch(CodeNotFoundException e) {
                    System.out.println("해당 상품번호로 조회한 상품이 없습니다.");
                }

            } else if (sel == 4) {
                System.out.println("****************** 4. 상품명으로 조회 *******************");
                System.out.println("조회할 상품 키워드를 입력하세요.");

                String str = scanner.next();

                try {
                    ArrayList<Product> selectedProduct = manager.getProductList(str);
                    System.out.println(menu);
                    System.out.println(bar);

                    for(Product p : selectedProduct) {
                        System.out.println(p);
                    }

                } catch (ProductNotFoundException e) {
                    System.out.println("해당 키워드로 검색한 상품이 없습니다.");
                }

            } else if (sel == 5) {
                System.out.println("******************* 5. TV 조회하기 *******************");
                System.out.println("1. 전체 조회하기 2. 특정 inch 이상 tv만 조회하기");

                int t = scanner.nextInt();
                if (t == 1) {
                    try {
                        ArrayList<Product> tvList = manager.getTvList();
                        System.out.println(menu);
                        System.out.println(bar);

                        for(int i = 0; i < tvList.size(); i++) {
                            System.out.println(tvList.get(i));
                        }
                    } catch (ProductNotFoundException e) {
                        System.out.println("등록된 TV가 없습니다.");
                    }
                } else if (t == 2) {
                    System.out.println("몇인치 이상 TV를 조회할까요?");
                    int inch = scanner.nextInt();

                    try {
                        ArrayList<Product> tvList = manager.getTvList(inch);

                        System.out.println(menu);
                        System.out.println(bar);

                        for(int i = 0; i < tvList.size(); i++) {
                            System.out.println(tvList.get(i));
                        }
                    } catch (ProductNotFoundException e) {
                        System.out.println(inch+"inch 이상 상품이 없습니다.");
                    }
                }
            } else if (sel == 6) {
                System.out.println("****************** 6. 냉장고 조회하기 ******************");
                System.out.println("1. 전체 조회하기 2. 특정 Liter 이상 냉장고만 조회하기");

                int t = scanner.nextInt();

                if (t == 1) {
                    try {
                        ArrayList<Product> refList = manager.getRefList();

                        System.out.println(menu);
                        System.out.println(bar);

                        for(int i = 0; i < refList.size(); i++) {
                            System.out.println(refList.get(i));
                        }
                    } catch (ProductNotFoundException e) {
                        System.out.println("등록된 냉장고가 없습니다.");
                    }
                } else if (t == 2) {
                    System.out.println("몇리터 이상 냉장고를 조회할까요?");
                    int liter = scanner.nextInt();

                    try {
                        ArrayList<Product> refList = manager.getRefList(liter);
                        System.out.println(menu);
                        System.out.println(bar);

                        for (int i = 0; i < refList.size(); i++) {
                            System.out.println(refList.get(i));
                        }
                    } catch (ProductNotFoundException e) {
                        System.out.println(liter + "Liter 이상 상품이 없습니다.");
                    }
                }
            } else if (sel == 7) {
                System.out.println("******************** 7. 상품 삭제 ********************");
                System.out.println("삭제할 상품 번호를 입력하세요.");
                int productNum = scanner.nextInt();

                try {
                    String result = manager.deleteProduct(productNum);

                    System.out.println(result);

                } catch (CodeNotFoundException e) {
                    System.out.println("해당 상품번호로 조회한 상품이 없습니다.");
                }
            } else if (sel == 8) {
                System.out.println("***************** 8. 재고상품 조회하기 *****************");
                try {
                    System.out.println(manager.getPriceList());
                } catch (ProductNotFoundException e) {
                    System.out.println("상품이 없습니다!");
                }
            } else if (sel == 9) {
                System.out.println("****************** 9. 상품가격 수정하기 *****************");
                System.out.println("상품 번호를 입력하세요.");
                try {
                    int productNum = scanner.nextInt();

                    Product selectedProduct = manager.selectProduct(productNum);

                    System.out.println(selectedProduct.getProductName()+"의 상품가격은 "+selectedProduct.getPrice()+"원 입니다. 얼마로 바꾸시겠어요?");
                    int price = scanner.nextInt();

                    manager.updateProduct(productNum, price);

                    System.out.println("가격이 성공적으로 변경되었습니다.");
                } catch (CodeNotFoundException e) {
                    System.out.println("해당 상품번호가 없습니다.");
                } catch (InputMismatchException e1) {
                    System.out.println("가격을 잘못 입력하셨습니다. 음수는 입력할 수 없습니다.");
                }
            }

        } while(sel != 0);

        System.out.println("프로그램을 종료햡니다.");
        manager.run();
        scanner.close();
    }
}
