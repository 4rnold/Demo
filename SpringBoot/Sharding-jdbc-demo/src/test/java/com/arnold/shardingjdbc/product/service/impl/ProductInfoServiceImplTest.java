package com.arnold.shardingjdbc.product.service.impl;

import com.arnold.shardingjdbc.product.entity.ProductInfo;
import com.arnold.shardingjdbc.product.service.IProductInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shardingsphere.api.hint.HintManager;
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

//    强制走主库
    @Test
    public void test2() {
        //    强制走主库
        HintManager.getInstance().setMasterRouteOnly();

//        QueryWrapper<ProductInfo> productInfoQueryWrapper = new QueryWrapper<>();
//        productInfoQueryWrapper.eq("product_info_id",418530911110299648l);

        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductInfoId(418530911110299648l);
        QueryWrapper<ProductInfo> productInfoQueryWrapper1 = new QueryWrapper<>(productInfo);

        ProductInfo one = productInfoService.getOne(productInfoQueryWrapper1);
//        ProductInfo byId = productInfoService.getById(418530911110299648l);
        System.out.println(one);
    }

    /**
     * 测试数据脱敏
     */
    @Test
    public void test3() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setStoreInfoId(11l);
        productInfo.setSpec("testtest");
        boolean save = productInfoService.save(productInfo);
    }

}