package service.impl;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import entity.CategoryEntity;
import repository.CategoryRepository;
import service.ICategoryService;


@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryEntity save(CategoryEntity entity) {
        if (entity.getCategoryId() == null) {
            return categoryRepository.save(entity);
        } else {
            Optional<CategoryEntity> opt = findById(entity.getCategoryId());
            if (opt.isPresent()) {
                if (StringUtils.isEmpty(entity.getCategoryName())) {
                    entity.setCategoryName(opt.get().getCategoryName());
                }
            }
            return categoryRepository.save(entity);
        }
    }

    @Override
    public List<CategoryEntity> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<CategoryEntity> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public List<CategoryEntity> findAll(Sort sort) {
        return categoryRepository.findAll(sort);
    }

    @Override
    public List<CategoryEntity> findAllById(Iterable<Long> ids) {
        return categoryRepository.findAllById(ids);
    }

    @Override
    public Optional<CategoryEntity> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Optional<CategoryEntity> findOne(Example<CategoryEntity> example) {
        return categoryRepository.findOne(example);
    }

    @Override
    public long count() {
        return categoryRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void delete(CategoryEntity entity) {
        categoryRepository.delete(entity);
    }

    @Override
    public void deleteAll() {
        categoryRepository.deleteAll();
    }

    @Override
    public List<CategoryEntity> findByNameContaining(String name) {
        return categoryRepository.findByNameContaining(name, Pageable.unpaged()).getContent();
    }

    @Override
    public Page<CategoryEntity> findByNameContaining(String name, Pageable pageable) {
        return categoryRepository.findByNameContaining(name, pageable);
    }
}