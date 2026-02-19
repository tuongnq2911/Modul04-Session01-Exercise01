package ra.exercise01.service;

import ra.exercise01.model.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();

    public ProductService() {
        products.add(new Product(1, "Laptop Dell", 1500.0));
        products.add(new Product(2, "Iphone 17 PRO", 1500.0));
        products.add(new Product(3, "Ban Phim Logitech", 20.0));
    }

    // 1. Lấy tất cả danh sách
    public List<Product> getAllProducts() {
        return products;
    }

    // 2. Thêm mới
    public Product addProduct(Product product) {
        products.add(product);
        return product;
    }

    // 3. Sửa
    public Product updateProduct(int id, Product newProduct) {
        for (Product p : products) {
            if (p.getId() == id) {
                p.setName(newProduct.getName());
                p.setPrice(newProduct.getPrice());
                return p;
            }
        }
        return null;
    }

    // 4. Xoá
    public boolean deleteProduct(int id) {
        return  products.removeIf(p -> p.getId() == id);
    }
}
