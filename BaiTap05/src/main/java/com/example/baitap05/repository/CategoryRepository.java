package repository;

import entity.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    // Tìm kiếm theo nội dung tên
    List<CategoryEntity> findByNameContaining(String name);
    // Tìm kiếm và phân trang
    Page<CategoryEntity> findByNameContaining(String name, Pageable pageable);
}
