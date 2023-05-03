package com.jzh.xx.transaction.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jzh.xx.transaction.domain.XxUser;

import java.util.List;
import java.util.Map;

public interface XxUserMapper extends BaseMapper<XxUser> {
    /**
     * 查询用户
     * @param phone
     * @return
     */
    XxUser getByPhone(String phone);

    XxUser getByUsername(String username);

    List<XxUser> page(Map<String,Object> params);

    void deleteMulti(Integer[] ids);

    int getUserCount();
}