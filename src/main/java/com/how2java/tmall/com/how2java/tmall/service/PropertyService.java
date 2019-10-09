package com.how2java.tmall.com.how2java.tmall.service;

import com.how2java.tmall.com.how2java.tmall.dao.PropertyDao;
import com.how2java.tmall.com.how2java.tmall.pojo.Category;
import com.how2java.tmall.com.how2java.tmall.pojo.Property;
import com.how2java.tmall.com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {
    @Autowired PropertyDao propertyDao;
    @Autowired CategoryService categoryService;

    public List<Property> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return propertyDao.findAll(sort);
    }

    public Page4Navigator<Property> list(int cid, int start, int size,int navigatePages) {
        Category category = categoryService.get(cid);

        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);

        Page<Property> pageFromJPA =propertyDao.findByCategory(category,pageable);

        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }

    public void add(Property bean) {
        propertyDao.save(bean);
    }

    public void delete(int id) {
        Property c = new Property();
        c.setId(id);
        propertyDao.delete(c);
    }

    public Property get(int id) {
        return propertyDao.getOne(id);
    }
}
