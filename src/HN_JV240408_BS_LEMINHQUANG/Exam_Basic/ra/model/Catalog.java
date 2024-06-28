package HN_JV240408_BS_LEMINHQUANG.Exam_Basic.ra.model;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Catalog {
    private int catalogId;
    private String catalogName;
    private String description;

    public Catalog() {
    }

    public Catalog(int catalogId, String catalogName, String description) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.description = description;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void inputCatalog(Scanner scanner) {
        System.out.println("Nhập mã danh mục: ");
        this.catalogId = Integer.parseInt(scanner.nextLine());
        this.catalogName = inputcatalogName(scanner);
        this.description = inputDescription(scanner);
    }

    public String inputDescription(Scanner scanner) {
        System.out.println("Nhập mô tả:");
        do {
            String description = scanner.nextLine();
            if(description.trim().isEmpty()){
                System.err.println("không được để trống");
            }else {
                return description;
            }
        }while (true);
    }

    public String inputcatalogName(Scanner scanner) {
        System.out.println("Nhập tên danh mục :");
        do {
            String catalogName = scanner.nextLine();
            if(catalogName.trim().isEmpty()){
                System.err.println("Không được để trống");
            }else {
                return catalogName;
            }
        }while (true);
    }

    @Override
    public String toString() {
        return "Mã: " + catalogId + ", Tên: " + catalogName + ", Mô tả: " + description;
    }
}

