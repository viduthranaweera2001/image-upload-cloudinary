package lk.zerocode.file_upload_cloudinary.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileUpload {
    String upload(MultipartFile multipartFile) throws IOException;

    String findById(String publicId);

}
