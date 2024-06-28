package HN_JV240408_BS_LEMINHQUANG.Exam_Basic.ra.run;

import HN_JV240408_BS_LEMINHQUANG.Exam_Basic.ra.service.CatalogService;

import java.util.Scanner;

public class BookManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("**************************BASIC-MENU**************************\n" +
                    "1. Quản lý danh mục\n" +
                    "2. Quản lý sản phẩm\n" +
                    "3. Thoát");
            System.out.println("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    CatalogManagement.catalogMenu(scanner);
                    break;
                case 2:
                    ProductManagament.productMenu(scanner);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.err.println("lựa chọn từ 1 -> 3");
            }
        }while (true);
    }
}
