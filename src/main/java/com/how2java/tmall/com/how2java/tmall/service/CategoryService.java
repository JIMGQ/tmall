package com.how2java.tmall.com.how2java.tmall.service;

import com.how2java.tmall.com.how2java.tmall.dao.CategoryDao;

import com.how2java.tmall.com.how2java.tmall.pojo.Category;
import com.how2java.tmall.com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired CategoryDao categoryDao;

    public List<Category> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return categoryDao.findAll(sort);
    }

    public Page4Navigator<Category> list(int start, int size, int navigatePages) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page pageFromJPA =categoryDao.findAll(pageable);

        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }

    public void add(Category bean) {
        categoryDao.save(bean);
    }

    public void delete(int id) {
        Category c = new Category();
        c.setId(id);
        categoryDao.delete(c);
    }

    public Category get(int id) {
        return categoryDao.getOne(id);
    }
}
