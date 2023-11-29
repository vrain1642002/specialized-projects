package com.shophandmade.controller.khachHang;

import com.shophandmade.entity.khachHangEntity;
import com.shophandmade.service.khachHang.khachHangService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class khachHangController {

    private final khachHangService khachHangService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody(required = true) Map<String, String> requestMap) {
        return khachHangService.signUp(requestMap);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody(required = true) Map<String, String> requestMap) {
        return khachHangService.login(requestMap);
    }

    @GetMapping("/checkToken")
    public ResponseEntity<String> checkToken() {
        return khachHangService.checkToken();
    }

    @GetMapping()
    public List<khachHangEntity> layTatCaKH() {
        return khachHangService.getAllKH();
    }

    @GetMapping("/{id}")
    public khachHangEntity layKHBangId(@PathVariable Integer id) {
        return khachHangService.getKHById(id);
    }

    @GetMapping("/email/{email}")
    public khachHangEntity layKHBangEmail(@PathVariable String email) {
        return khachHangService.findByEmail(email);
    }

    @GetMapping("/hoTen/{hoTen}")
    public khachHangEntity timTenKhachHang(@PathVariable String hoTen) {
        return khachHangService.findByHoTen(hoTen);
    }

    @PutMapping("/{id}")
    public khachHangEntity capNhatKhachHang(@PathVariable Integer id, @RequestBody khachHangEntity khachhangEntity) {
        return khachHangService.updateKhachHang(id, khachhangEntity);
    }

    @DeleteMapping("/{id}")
    public String xoaKhachHang(@PathVariable Integer id) {
        khachHangService.deleteKhachHang(id);
        return "Xoa khach hang thang cong";
    }

}
