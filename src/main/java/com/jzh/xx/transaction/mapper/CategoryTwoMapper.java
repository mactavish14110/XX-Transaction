package com.jzh.xx.transaction.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jzh.xx.transaction.domain.CategoryTwo;

import java.util.List;

public interface CategoryTwoMapper extends BaseMapper<CategoryTwo> {
    List<CategoryTwo> getByCategoryId(Long categoryId);
}