package com.jzh.xx.transaction.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jzh.xx.transaction.domain.Address;
import com.jzh.xx.transaction.domain.Banner;
import com.jzh.xx.transaction.mapper.AddressMapper;
import com.jzh.xx.transaction.mapper.BannerMapper;
import com.jzh.xx.transaction.service.BannerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements BannerService {

    @Resource
    private BannerMapper bannerMapper;

    @Override
    public List<Banner> showBanner() {
        List<Banner> banners = bannerMapper.selectList(Wrappers.lambdaQuery());
        return banners;
    }
}
