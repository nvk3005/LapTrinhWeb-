package org.example.baitaptuan05.repository;

import org.example.baitaptuan05.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findByNameContainingIgnoreCase(String keyword);

    Page<Category> findByNameContainingIgnoreCase(String keyword, Pageable pageable);

}
