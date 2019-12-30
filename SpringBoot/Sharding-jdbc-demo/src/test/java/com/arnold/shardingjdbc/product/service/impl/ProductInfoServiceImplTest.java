package com.arnold.shardingjdbc.product.service.impl;

import com.arnold.shardingjdbc.product.entity.ProductInfo;
import com.arnold.shardingjdbc.product.service.IProductInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    IProductInfoService productInfoService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            ProductInfo productInfo = new ProductInfo();
            productInfo.setStoreInfoId((long) i);
            productInfo.setProductName("222");

            productInfoService.save(productInfo);
        }
    }

}