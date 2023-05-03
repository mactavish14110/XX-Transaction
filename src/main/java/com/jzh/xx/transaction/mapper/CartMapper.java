package com.jzh.xx.transaction.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jzh.xx.transaction.domain.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper extends BaseMapper<Cart> {
    List<Cart> getByUserIdAndSellerId(@Param("userId") Long userId, @Param("seller") Long sellerId);

    List<Cart> getByUserId(Long userId);

    void deleteByUserIdAndGoodsId(@Param("userId") Long userId,@Param("goodsId") Long goodsId);
}