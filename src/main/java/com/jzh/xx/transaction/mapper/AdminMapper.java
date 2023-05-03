package com.jzh.xx.transaction.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jzh.xx.transaction.domain.Admin;

public interface AdminMapper extends BaseMapper<Admin> {
    Admin getByUsername(String username);
}