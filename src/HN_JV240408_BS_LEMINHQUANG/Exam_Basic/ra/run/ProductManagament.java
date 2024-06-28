package HN_JV240408_BS_LEMINHQUANG.Exam_Basic.ra.run;

import HN_JV240408_BS_LEMINHQUANG.Exam_Basic.ra.model.Catalog;
import HN_JV240408_BS_LEMINHQUANG.Exam_Basic.ra.model.Product;
import HN_JV240408_BS_LEMINHQUANG.Exam_Basic.ra.service.CatalogService;
import HN_JV240408_BS_LEMINHQUANG.Exam_Basic.ra.service.ProductService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductManagament {
    private static final ProductService productFeature = new ProductService();

    public static void productMenu(Scanner scanner) {
        boolean quit = true;
        do {
            System.out.println("********************PRODUCT-MANAGEMENT********************\n" +
                    "1. Nhập số sản phẩm và nhập thông tin sản phẩm \n" +
                    "2. Hiển thị thông tin các sản phẩm \n" +
                    "3. Sắp xếp sản phẩm theo giá giảm dần \n" +
                    "4. Xóa sản phẩm theo mã \n" +
                    "5. Tìm kiếm sản phẩm theo tên sản phẩm \n" +
                    "6. Thay đổi thông tin của sản phẩm theo mã sản phẩm " +
                    "7. Thoát");
            System.out.println("Lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    inputProductList(scanner);
                    break;
                case 2:
                    showProductList();
                    break;
                case 3:
                    sortProductByPrice();
                    break;
                case 4:
                    deleteProduct(scanner);
                    break;
                case 5:
                    searchProductByName(scanner);
                    break;
                case 6:
                    updateProduct(scanner);
                    break;
                case 7:
                    quit = false;
                    break;
                default:
                    System.err.println("Lựa chọn từ 1 -> 7");
            }
        } while (quit);
    }

    private static void updateProduct(Scanner scanner) {
        System.out.println("Nhập mã sản phẩm cần cập nhật:");
        int number = Integer.parseInt(scanner.nextLine());
        int index = productFeature.findById(number);
        if(index >= 0){
        Product updateProduct = ProductService.productList.get(index);
            System.out.println("Cập nhập tên sản phẩm");
            updateProduct.setProductName(updateProduct.inputProductName(scanner));
            System.out.println("Cập nhâp giá sản phẩm");
            updateProduct.setProductPrice(Double.parseDouble(scanner.nextLine()));
            System.out.println("Cập nhập mô tả:");
            updateProduct.setDescription(scanner.nextLine());
            System.out.println("Cập nhập số lượng:");
            updateProduct.setStock(updateProduct.inputStock(scanner));
            System.out.println("Cập nhập danh mục sản phẩm thuộc về:");
            updateProduct.setCatalog(updateProduct.inputCatalogId(scanner));
//            private int productId;
//            private String productName;
//            private double productPrice;
//            private String description;
//            private int stock;
//            private Catalog catalog;
//            private boolean status;
        }

    }

    private static void searchProductByName(Scanner scanner) {
        System.out.println("Nhập tên sản phẩm cần tìm: ");
        String productName = scanner.nextLine();
        boolean quit = false;
        for (Product product:productFeature.getAll()){
            if(product.getProductName().toLowerCase().contains(productName.toLowerCase())){
                product.toString();
                quit = true;
            }
        }
        if(!quit){
            System.err.println("Không tìm thấy sản phẩm " +productName);
        }
    }


    private static void deleteProduct(Scanner scanner) {
        System.out.println("Nhập mã sản phẩm muốn xóa:");
        int idDelete = Integer.parseInt(scanner.nextLine());
        productFeature.delete(idDelete);
    }

    private static void sortProductByPrice() {
        List<Product> sortProduct = ProductService.productList.stream().sorted(Comparator.comparing(Product::getProductPrice)).toList();
        for (Product product : sortProduct) {
            System.out.println(product.toString());
        }
    }

    private static void showProductList() {
        if (productFeature.getAll().isEmpty()) {
            System.err.println("danh sách trống!");
            return;
        }
        for (Product product : productFeature.getAll()) {
            System.out.println( product.toString());
        }
    }

    private static void inputProductList(Scanner scanner) {
        System.out.println("Nhập số lượng sản phẩm muốn thêm:");
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            Product newProduct = new Product();
            newProduct.inputProduct(scanner);
            productFeature.save(newProduct);
        }
    }
}
