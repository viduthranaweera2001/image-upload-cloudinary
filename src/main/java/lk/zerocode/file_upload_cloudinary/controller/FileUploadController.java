package lk.zerocode.file_upload_cloudinary.controller;

import lk.zerocode.file_upload_cloudinary.service.FileUpload;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@AllArgsConstructor
public class FileUploadController {

    private final FileUpload fileUpload;

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("image")MultipartFile multipartFile, Model model) throws IOException {
        String imageURL = fileUpload.upload(multipartFile);
        model.addAttribute("imageURL",imageURL);
        return "gallery";
    }

    @GetMapping("/image/{publicId}")
    public ResponseEntity<String> getById(@PathVariable String publicId) {
        String imageUrl = fileUpload.findById(publicId);
        return ResponseEntity.ok(imageUrl);
    }

}
