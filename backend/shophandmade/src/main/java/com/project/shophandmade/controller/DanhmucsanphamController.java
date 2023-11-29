package com.project.shophandmade.controller;

import com.project.shophandmade.dtos.DanhmucsanphamDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/Danhmucsanphams")
//@Validated
public class DanhmucsanphamController {
    @GetMapping("")  //http://localhost:8088/api/v1/Danhmucsanpham
    public ResponseEntity<String> LayDanhmucsanpham(
            @RequestParam ("page") int page,
            @RequestParam ("limit") int limit

    ){
        return ResponseEntity.ok(String.format("LaytatcaDanhmucsanpham,page= %d,limit=% d",page,limit));
    }
    @PostMapping("")
    //Tham so truyen vao la 1 object=>Data Transfre object= Request Object
    public ResponseEntity<?> ThemDanhmucsanpham(@Valid @RequestBody DanhmucsanphamDTO danhmucsanphamDTO, BindingResult result){
        if (result.hasErrors())
        {
            //lay danh sach loi chuyen dang string bang stream de bao loi
            List<String> errorMessage=  result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return  ResponseEntity.badRequest().body(errorMessage);

        }

        return ResponseEntity.ok("Day la ham them"+danhmucsanphamDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> SuaDanhmucsanpham(@PathVariable Long id){
        return ResponseEntity.ok("Cap nhat danh muc san pham voi ma ="+id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> XoaDanhmucsanpham(@PathVariable Long id){
        return ResponseEntity.ok("Xoa danh muc san pham voi ma="+id);
    }

}
