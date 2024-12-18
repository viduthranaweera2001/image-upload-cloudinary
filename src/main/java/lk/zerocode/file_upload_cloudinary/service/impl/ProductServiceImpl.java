package lk.zerocode.file_upload_cloudinary.service.impl;

import com.cloudinary.Cloudinary;
import lk.zerocode.file_upload_cloudinary.controller.request.ProductRequestDTO;
import lk.zerocode.file_upload_cloudinary.model.Product;
import lk.zerocode.file_upload_cloudinary.repository.ProductRepository;
import lk.zerocode.file_upload_cloudinary.service.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ModelMapper modelMapper;
    private ProductRepository productRepository;
    private final Cloudinary cloudinary;

    @Override
    public Product create(ProductRequestDTO productRequestDTO) throws IOException {

        String image = cloudinary.uploader()
                .upload(productRequestDTO.getImage().getBytes(),
                        Map.of("public_id", UUID.randomUUID().toString()))
                .get("url")
                .toString();
        Product product = modelMapper.map(productRequestDTO, Product.class);
        product.setImage(image);
        productRepository.save(product);

        return product;
    }
}
