package com.project.shophandmade.controller;

import com.project.shophandmade.dtos.DanhmucsanphamDTO;
import com.project.shophandmade.dtos.SanphamDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/sanphams")
public class SanphamController {

     @PostMapping(value = "",
            //Kieu uploadd file mutipart
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)

    public ResponseEntity<?> TaoSanpham(
            @Valid @ModelAttribute SanphamDTO sanphamDTO,
//            @RequestPart("file") MultipartFile file,
            BindingResult result
    ) {
        try {
            if(result.hasErrors()) {
                List<String> errorMessages = result.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errorMessages);
            }
//            List<MultipartFile> files = sanphamDTO.getFiles();
//            files = files == null ? new ArrayList<MultipartFile>() : files;
//            for (MultipartFile file : files) {
//                if(file.getSize() == 0) {
//                    continue;
//                }
            MultipartFile file = sanphamDTO.getFile();
            if(file!=null){
                // Kiểm tra kích thước file và định dạng
                if(file.getSize() > 10 * 1024 * 1024) { // Kích thước > 10MB
                    return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE)
                            .body("Kich thuoc file qua lon,do lon toi da la 10MB");
                }
                String contentType = file.getContentType();
                //kiem tra file co phai la image khong khi co bat dau la start
                if(contentType == null || !contentType.startsWith("image/")) {
                    return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
                            .body("Phai la file hinh");
                }
                // Lưu file và cập nhật thumbnail trong DTO
                String filename = luuFile(file); // Thay thế hàm này với code của bạn để lưu file
                //lưu vào đối tượng san pham trong DB => sẽ làm sau
                //lưu vào bảng product_images
            }
            return ResponseEntity.ok("Da them san pham thanh cong");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    private String luuFile(MultipartFile file) throws IOException {
         //lay ten file buoc phai doi tra ve ten goc
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        // Thêm UUID vào trước tên file để đảm bảo tên file là duy nhất
        String uniqueFilename = UUID.randomUUID().toString() + "_" + filename;
        // Đường dẫn đến thư mục mà bạn muốn lưu file
        java.nio.file.Path uploadDir = Paths.get("uploads");
        // Kiểm tra và tạo thư mục nếu nó không tồn tại
        if (!Files.exists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }
        // Đường dẫn đầy đủ đến file
        java.nio.file.Path destination = Paths.get(uploadDir.toString(), uniqueFilename);
        // Sao chép file vào thư mục đích
        Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);
        return uniqueFilename;
    }
    @GetMapping("")
    public ResponseEntity<String> laySanphams(
            @RequestParam("page")     int page,
            @RequestParam("limit")    int limit
    ) {
        return ResponseEntity.ok("lay tat ca san pham");
    }
    //http://localhost:8088/api/v1/sanpham/6
    @GetMapping("/{id}")
    public ResponseEntity<String> laySanphambyID(
            @PathVariable("id") String productId
    ) {
        return ResponseEntity.ok("San pham voi ma: " + productId);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> xoaSanpham(@PathVariable long id) {
        return ResponseEntity.ok(String.format("San pham co ma = %d da xoa thanh cong", id));
    }
}
