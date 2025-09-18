package repository;

import entity.CategoryEntity;
import entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    // Tìm kiếm theo nội dung tên
    List<ProductEntity> findByNameContaining(String name);
    // Tìm kiếm và phân trang
    Page<ProductEntity> findByNameContaining(String name, Pageable pageable);
}
