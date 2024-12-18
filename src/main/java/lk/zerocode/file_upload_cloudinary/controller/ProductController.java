package lk.zerocode.file_upload_cloudinary.controller;

import lk.zerocode.file_upload_cloudinary.controller.request.ProductRequestDTO;
import lk.zerocode.file_upload_cloudinary.model.Product;
import lk.zerocode.file_upload_cloudinary.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @PostMapping(value = "/products")
    public ResponseEntity<Product> create(@ModelAttribute ProductRequestDTO productRequestDTO) throws IOException {
        Product product = productService.create(productRequestDTO);
        return ResponseEntity.ok(product);
    }
}
