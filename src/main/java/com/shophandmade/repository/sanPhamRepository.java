package com.shophandmade.repository;

import com.shophandmade.entity.sanPhamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface sanPhamRepository extends JpaRepository<sanPhamEntity, Integer> {

//    List<SanphamEntity> getSanPhamByDanhMucSanPham(long id);

}
