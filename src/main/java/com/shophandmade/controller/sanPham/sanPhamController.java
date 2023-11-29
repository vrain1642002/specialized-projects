package com.shophandmade.controller.sanPham;

import com.shophandmade.entity.sanPhamEntity;
import com.shophandmade.service.sanPham.sanPhamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sanPham")
@RequiredArgsConstructor
public class sanPhamController {

    private final sanPhamService sanPhamService;

    @GetMapping()
    public List<sanPhamEntity> layTatCaSP() {
        return sanPhamService.getAllSP();
    }

    @GetMapping("/{id}")
    public sanPhamEntity laySPBangId(@PathVariable Integer id) {
        return sanPhamService.getSPById(id);
    }

//    @GetMapping("/dmsp/{id}")
//    public List<SanphamEntity> laySanPhamBangDMSP(@PathVariable Integer id) {
//        return sanPhamService.getSanPhamByDanhMucSanPham(id);
//    }

    @PostMapping("/them")
    public sanPhamEntity themSanPham(@RequestBody sanPhamRequest sanPhamRequest) {
        return sanPhamService.saveSanPham(sanPhamRequest);
    }

    @PutMapping("/{id}")
    public sanPhamEntity capNhatSP(@PathVariable Integer id, @RequestBody sanPhamRequest sanPhamRequest) {
        return sanPhamService.updateSanPham(id, sanPhamRequest);
    }

    @DeleteMapping("/{id}")
    public String xoaSanPham(@PathVariable Integer id) {
        sanPhamService.deleteSanPham(id);
        return "Xoa san pham thanh cong";
    }

    @PostMapping("/trangThai")
    public sanPhamEntity capNhatTrangThaiSanPham(@PathVariable Integer id, @RequestBody sanPhamRequest sanPhamRequest) {
        return sanPhamService.updateTrangThai(id, sanPhamRequest);
    }

}
