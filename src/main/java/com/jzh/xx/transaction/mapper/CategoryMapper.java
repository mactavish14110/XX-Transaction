package com.jzh.xx.transaction.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jzh.xx.transaction.domain.Category;

import java.util.List;
import java.util.Map;

public interface CategoryMapper extends BaseMapper<Category> {
    List<Category> categoryPage(Map<String,Object> params);
}