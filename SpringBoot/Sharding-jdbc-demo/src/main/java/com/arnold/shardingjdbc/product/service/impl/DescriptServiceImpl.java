package com.arnold.shardingjdbc.product.service.impl;

import com.arnold.shardingjdbc.product.entity.ProductDescript;
import com.arnold.shardingjdbc.product.mapper.DescriptMapper;
import com.arnold.shardingjdbc.product.service.IDescriptService;
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
public class DescriptServiceImpl extends ServiceImpl<DescriptMapper, ProductDescript> implements IDescriptService {

}
