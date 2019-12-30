package com.arnold.shardingjdbc.product.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.arnold.shardingjdbc.common.controller.CurdController;
import com.arnold.shardingjdbc.product.entity.ProductDescript;

/**
 * <p>
 *  控制器
 * </p>
 *
 * @author arnold
 * @since 2019-12-30
*/
@RestController
@RequestMapping("/product/Descript")
public class DescriptController extends CurdController<ProductDescript> {

}
