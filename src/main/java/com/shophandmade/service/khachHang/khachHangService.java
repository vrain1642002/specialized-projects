package com.shophandmade.service.khachHang;

import com.shophandmade.entity.khachHangEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface khachHangService {

    ResponseEntity<String> signUp(Map<String, String> requestMap);

    ResponseEntity<String> login(Map<String, String> requestMap);

    ResponseEntity<String> checkToken();

    List<khachHangEntity> getAllKH();

    khachHangEntity getKHById(Integer id);

    khachHangEntity findByEmail(String email);

    khachHangEntity findByHoTen(String hoTen);

    khachHangEntity updateKhachHang(Integer id, khachHangEntity khachhangEntity);

    void deleteKhachHang(Integer id);

}
