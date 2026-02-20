package ra.exercise01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.exercise01.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
