package HN_JV240408_BS_LEMINHQUANG.Exam_Basic.ra.model;

import HN_JV240408_BS_LEMINHQUANG.Exam_Basic.ra.run.CatalogManagement;
import HN_JV240408_BS_LEMINHQUANG.Exam_Basic.ra.service.CatalogService;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Product {
    private int productId;
    private String productName;
    private double productPrice;
    private String description;
    private int stock;
    private Catalog catalog;
    private boolean status;

    public Product() {
    }

    public Product(Catalog catalog, String description, int productId, String productName, double productPrice, boolean status, int stock) {
        this.catalog = catalog;
        this.description = description;
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.status = status;
        this.stock = stock;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void inputProduct(Scanner scanner) {
        this.productId = inputProductId(scanner);
        this.productName = inputProductName(scanner);
        System.out.println("Nhập mô tả:");
        this.description = scanner.nextLine();
        this.stock = inputStock(scanner);
        this.catalog = inputCatalogId(scanner);
        this.status = true;
    }

    private Catalog inputCatalogId(Scanner scanner) {
        for (Catalog ca : CatalogService.catalogList) {
            System.out.printf("Mã: %d,Name: %s \n", ca.getCatalogId(), ca.getCatalogName());
        }
        System.out.println("nhập Mã tác giả:");
        do {
            int choice = Integer.parseInt(scanner.nextLine());
            int catalogId = findIndexById(choice);
            if(catalogId >= 0){
                return CatalogService.catalogList.get(catalogId);
            }else {
                System.out.println("Mã không đúng!");
            }
        } while (true);
    }

    public int findIndexById(int catalogId) {
        for (int i = 0; i < CatalogService.catalogList.size(); i++) {
            if (CatalogService.catalogList.get(i).getCatalogId() == catalogId) {
                return i;
            }
        }
        return -1;
    }


    private int inputStock(Scanner scanner) {
        System.out.println("Nhập số lượng:");
        do {
            int stock = scanner.nextInt();
            if (stock >= 10) {
                return stock;
            }
        } while (true);
    }

    private String inputProductName(Scanner scanner) {
        System.out.println("Nhập tên sản phẩm:");
        do {
            String productName = scanner.nextLine();
            if (productName.trim().isEmpty()) {
                System.err.println("không được để trống!");
            } else {
                return productName;
            }
        } while (true);
    }

    public int inputProductId(Scanner scanner) {
        System.out.println("Nhập mã sản phẩm:");
        do {
            String regex = "(P)\\w{4}";
            String productName = scanner.nextLine();
            if (Pattern.matches(regex, productName)) {
                return Integer.parseInt(productName);
            } else {
                System.err.println("bắt đầu bằng P và 4 ký tự số");
            }
        } while (true);
    }
    @Override
    public String toString() {
        return "Mã: " + productId + ", Tên: " + productName + ", Giá: " + productPrice + ", Mô tả: " +description
                +", Số lượng: " +stock + ", CatalogName: " + catalog.getCatalogName() +"Status: " + status;
    }
}