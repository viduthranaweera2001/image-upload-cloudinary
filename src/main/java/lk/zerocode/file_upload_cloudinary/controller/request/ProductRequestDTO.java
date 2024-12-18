package lk.zerocode.file_upload_cloudinary.controller.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductRequestDTO {

    private String name;
    private Double price;
    private MultipartFile image;
}
