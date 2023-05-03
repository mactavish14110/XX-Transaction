package com.jzh.xx.transaction.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jzh.xx.transaction.domain.Goods;
import com.jzh.xx.transaction.dto.PageResult;

public interface FrontCateService {
    /**
     * 分页
     * @param pageNum
     * @param categoryId
     * @return
     */
    PageResult<Goods> goodsPage(int pageNum, Long categoryId);
}
