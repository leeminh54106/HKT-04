package HN_JV240408_BS_LEMINHQUANG.Exam_Basic.ra.run;

import HN_JV240408_BS_LEMINHQUANG.Exam_Basic.ra.model.Catalog;
import HN_JV240408_BS_LEMINHQUANG.Exam_Basic.ra.service.CatalogService;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CatalogManagement {
    private static final CatalogService catalogFeature = new CatalogService();

    public static void catalogMenu(Scanner scanner) {
        boolean quit = true;
        do {
            System.out.println("********************CATALOG-MANAGEMENT********************\n" +
                    "1. Nhập số danh mục thêm mới và nhập thông tin cho từng danh mục \n" +
                    "2. Hiển thị thông tin tất cả các danh mục \n" +
                    "3. Sửa tên danh mục theo mã danh mục \n" +
                    "4. Xóa danh muc theo mã danh mục (lưu ý ko xóa khi có sản phẩm)\n" +
                    "5. Quay lại");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    inputCatalogList(scanner);
                    break;
                case 2:
                    showCatalog();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    quit = false;
                    break;
                default:
                    System.err.println("Từ 1 -> 5");
            }
        } while (quit);
    }

    private static void showCatalog() {
        if (catalogFeature.getAll().isEmpty()) {
            System.err.println("Danh mục rỗng!");
            return;
        }
        for() {

        }
    }

    private static void inputCatalogList(Scanner scanner) {
        System.out.println("Nhập số lượng danh mục muốn thêm:");
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            Catalog newCatalog = new Catalog();
            newCatalog.inputCatalog(scanner);
            catalogFeature.save(newCatalog);
        }
    }
}