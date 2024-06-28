package HN_JV240408_BS_LEMINHQUANG.Exam_Basic.ra.service;

import HN_JV240408_BS_LEMINHQUANG.Exam_Basic.ra.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IGenericService<Product, Integer> {
    public static List<Product> productList = new ArrayList<Product>();

    @Override
    public List<Product> getAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        int index = findById(product.getProductId());
        if (index >= 0) {
            productList.set(index, product);
        } else {
            productList.add(product);
        }
    }

    @Override
    public int findById(Integer id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void delete(Integer id) {
        int index = findById(id);
        if (index >= 0) {
            productList.remove(index);
        } else {
            System.err.println("Không tồn tại!");
        }
    }
}
