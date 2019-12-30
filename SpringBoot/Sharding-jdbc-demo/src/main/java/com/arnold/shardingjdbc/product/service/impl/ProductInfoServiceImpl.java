package com.arnold.shardingjdbc.product.service.impl;

import com.arnold.shardingjdbc.product.entity.ProductInfo;
import com.arnold.shardingjdbc.product.mapper.ProductInfoMapper;
import com.arnold.shardingjdbc.product.service.IProductInfoService;
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
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoMapper, ProductInfo> implements IProductInfoService {

}
