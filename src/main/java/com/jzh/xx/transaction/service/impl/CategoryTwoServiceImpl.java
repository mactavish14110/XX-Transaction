package com.jzh.xx.transaction.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jzh.xx.transaction.domain.Address;
import com.jzh.xx.transaction.domain.CategoryTwo;
import com.jzh.xx.transaction.mapper.AddressMapper;
import com.jzh.xx.transaction.mapper.CategoryTwoMapper;
import com.jzh.xx.transaction.service.CategoryTwoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryTwoServiceImpl extends ServiceImpl<CategoryTwoMapper, CategoryTwo> implements CategoryTwoService {
    @Resource
    private CategoryTwoMapper categoryTwoMapper;

    @Override
    public List<CategoryTwo> getAll() {
        return categoryTwoMapper.selectList(Wrappers.lambdaQuery());
    }
}
