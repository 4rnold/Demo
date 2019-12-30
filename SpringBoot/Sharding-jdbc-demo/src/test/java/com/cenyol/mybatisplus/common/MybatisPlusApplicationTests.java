package com.cenyol.mybatisplus.common;

import com.arnold.shardingjdbc.product.entity.ProductInfo;
import com.arnold.shardingjdbc.product.service.IProductInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusApplicationTests {

    @Autowired
    IProductInfoService productInfoService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setStoreInfoId(111l);
        productInfo.setProductName("111");

        productInfoService.save(productInfo);
    }

}
