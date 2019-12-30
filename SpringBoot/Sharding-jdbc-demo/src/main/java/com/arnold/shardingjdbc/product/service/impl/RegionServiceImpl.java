package com.arnold.shardingjdbc.product.service.impl;

import com.arnold.shardingjdbc.product.entity.Region;
import com.arnold.shardingjdbc.product.mapper.RegionMapper;
import com.arnold.shardingjdbc.product.service.IRegionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author arnold
 * @since 2019-12-30
 */
@Service
public class RegionServiceImpl extends ServiceImpl<RegionMapper, Region> implements IRegionService {

}
