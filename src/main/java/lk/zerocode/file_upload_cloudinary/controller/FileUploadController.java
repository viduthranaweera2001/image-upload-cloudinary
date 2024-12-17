package lk.zerocode.file_upload_cloudinary.controller;

import lk.zerocode.file_upload_cloudinary.service.FileUpload;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@RestController
@RequiredArgsConstructor
public class FileUploadController {

    private final FileUpload fileUpload;

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("image")MultipartFile multipartFile, Model model) throws IOException {
        String imageURL = fileUpload.uploadFile(multipartFile);
        model.addAttribute("imageURL",imageURL);
        return "gallery";
    }

//    @GetMapping("/image/{publicId}")
//    public ResponseEntity<String> getImage(@PathVariable String publicId) {
//        String imageUrl = fileUpload.findById(publicId);
//        return ResponseEntity.ok(imageUrl);
//    }

    @GetMapping("/image/{publicId}")
    public ResponseEntity<ByteArrayResource> getImage(@PathVariable String publicId) {
        try {
            String imageUrl = fileUpload.findById(publicId);

            InputStream inputStream = new URL(imageUrl).openStream();
            byte[] imageBytes = inputStream.readAllBytes();
            inputStream.close();

            ByteArrayResource resource = new ByteArrayResource(imageBytes);

            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=" + publicId + ".jpg")
                    .body(resource);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
