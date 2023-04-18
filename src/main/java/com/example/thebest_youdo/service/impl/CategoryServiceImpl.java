package com.example.thebest_youdo.service.impl;

import com.example.thebest_youdo.model.entity.Category;
import com.example.thebest_youdo.repository.CategoryRepository;
import com.example.thebest_youdo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }
}
