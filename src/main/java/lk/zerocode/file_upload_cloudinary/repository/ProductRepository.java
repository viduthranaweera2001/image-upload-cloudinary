package lk.zerocode.file_upload_cloudinary.repository;

import lk.zerocode.file_upload_cloudinary.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
