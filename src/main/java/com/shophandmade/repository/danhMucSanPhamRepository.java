package com.shophandmade.repository;

import com.shophandmade.entity.danhMucSanPhamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface danhMucSanPhamRepository extends JpaRepository<danhMucSanPhamEntity, Integer> {

}
