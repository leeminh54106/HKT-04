package HN_JV240408_BS_LEMINHQUANG.Exam_Basic.ra.service;

import HN_JV240408_BS_LEMINHQUANG.Exam_Basic.ra.model.Catalog;
import HN_JV240408_BS_LEMINHQUANG.Exam_Basic.ra.model.Product;

import java.util.ArrayList;
import java.util.List;

public class CatalogService implements IGenericService<Catalog, Integer> {
    public static List<Catalog> catalogList = new ArrayList<>();

    @Override
    public List<Catalog> getAll() {
        return catalogList;
    }

    @Override
    public void save(Catalog catalog) {
        int index = findById(catalog.getCatalogId());
        if (index >= 0) {
            catalogList.set(index, catalog);
        } else {
            catalogList.add(catalog);
        }
    }

    @Override
    public int findById(Integer id) {
        for (int i = 0; i < catalogList.size(); i++) {
            if (catalogList.get(i).getCatalogId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void delete(Integer id) {
        int index = findById(id);
        if (index >= 0) {
            boolean isExist = false;
            for (Product product : ProductService.productList) {
                if (product.getProductId() == id) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                catalogList.remove(index);
                System.out.println("xóa thành công!");
            } else {
                System.err.println("Danh mục có chứa sản,phẩm không thể xóa!");
            }
        } else {
            System.err.println("Không tìm thấy");
        }
    }
}
