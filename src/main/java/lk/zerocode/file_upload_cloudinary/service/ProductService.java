package lk.zerocode.file_upload_cloudinary.service;

import lk.zerocode.file_upload_cloudinary.controller.request.ProductRequestDTO;
import lk.zerocode.file_upload_cloudinary.model.Product;
import org.springframework.stereotype.Service;

import java.io.IOException;

public interface ProductService {
    Product create(ProductRequestDTO productRequestDTO) throws IOException;
}
