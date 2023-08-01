package zenith.codes.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zenith.codes.projects.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
}
