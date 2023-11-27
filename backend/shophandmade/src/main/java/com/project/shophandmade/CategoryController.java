package com.project.shophandmade;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {

    @GetMapping("")  //http://localhost:8088/api/v1/categories
    public ResponseEntity<String> getAllCategories(){
        return ResponseEntity.ok("Chao ban quoc viet");
    }
    @PostMapping("")
    public ResponseEntity<String> insertCategory(){
        return ResponseEntity.ok("Insert Category");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable Long id){
        return ResponseEntity.ok("Update Category with id ="+id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
        return ResponseEntity.ok("Delete Category with id ="+id);
    }
}
