package ra.exercise01.service;

import ra.exercise01.model.Product;
import org.springframework.stereotype.Service;
import ra.exercise01.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 1. Lấy tất cả danh sách
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // 2. Thêm mới
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    // 3. Sửa
    public Product updateProduct(Integer id, Product newProduct) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm"));
        existingProduct.setName(newProduct.getName());
        existingProduct.setPrice(newProduct.getPrice());

        return productRepository.save(existingProduct);
    }

    // 4. Xoá
    public void deleteProduct(Integer id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy sản phẩm");
        }
        productRepository.deleteById(id);
    }
}
