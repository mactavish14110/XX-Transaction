package com.jzh.xx.transaction.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jzh.xx.transaction.domain.Category;
import com.jzh.xx.transaction.dto.PageInfo;
import com.jzh.xx.transaction.mapper.CategoryMapper;
import com.jzh.xx.transaction.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public Category showCategory(Long id) {
        return categoryMapper.selectById(id);
    }

    @Override
    public PageInfo<Category> page(int draw, int start, int length, Category category) {
        Map<String,Object> params = new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("Category",category);

        int count = categoryMapper.selectCount(Wrappers.lambdaQuery(category));
        PageInfo<Category> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(categoryMapper.categoryPage(params));

        return pageInfo;
    }

    @Override
    public void saveCategory(Category category) {
        if(category.getId() == null){
            categoryMapper.insert(category);
        }
        else {
            categoryMapper.updateById(category);
        }
    }

    @Override
    public Category getById(Long id) {
        return categoryMapper.selectById(id);
    }

    @Override
    public void deleteOne(int id) {
        categoryMapper.deleteById(id);
    }

    @Override
    public List<Category> categoryList() {
        List<Category> categories = categoryMapper.selectList(Wrappers.lambdaQuery());
        return categories;
    }

    @Override
    public void deleteSelected(String[] sIds) {
        for (String sId : sIds) {
            int i = Integer.parseInt(sId);
            categoryMapper.deleteById(i);
        }
    }
}
