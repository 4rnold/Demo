package com.arnold.shardingjdbc.product.dao;

import com.arnold.shardingjdbc.product.mapper.ProductInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductInfoDao {

    @Autowired
    ProductInfoMapper mapper;

}
