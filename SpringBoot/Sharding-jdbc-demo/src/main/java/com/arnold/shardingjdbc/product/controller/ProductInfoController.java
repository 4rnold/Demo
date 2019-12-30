package com.arnold.shardingjdbc.product.controller;

import com.arnold.shardingjdbc.product.entity.ProductInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.arnold.shardingjdbc.common.controller.CurdController;

/**
 * <p>
 *  控制器
 * </p>
 *
 * @author arnold
 * @since 2019-12-30
*/
@RestController
@RequestMapping("/product/Info")
public class ProductInfoController extends CurdController<ProductInfo> {

}
