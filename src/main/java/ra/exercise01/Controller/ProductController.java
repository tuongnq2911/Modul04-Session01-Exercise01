package ra.exercise01.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ra.exercise01.model.Product;
import ra.exercise01.service.ProductService;


import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    // Lấy danh sách
    @GetMapping
    public List<Product> getProducts() {
        return  productService.getAllProducts();
    }

    // Thêm mới
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    // Cập nhật
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    // Xoá
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        boolean isDeleted = productService.deleteProduct(id);
        if (isDeleted) {
            return "Xóa thành công sản phẩm ID: " + id;
        }else  {
            return "Không tìm thấy sản phẩm để xóa";
        }
    }
}
