package lk.zerocode.file_upload_cloudinary.controller.response;

import lombok.Data;
@Data
public class ProductResponse {
    private String name;
    private String description;
    private Double price;
    private String image;
}
