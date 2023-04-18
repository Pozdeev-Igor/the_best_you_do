package com.example.thebest_youdo.service;


import com.example.thebest_youdo.model.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategories();
}
