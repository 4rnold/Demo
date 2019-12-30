package com.arnold.shardingjdbc.store.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.arnold.shardingjdbc.common.controller.CurdController;
import com.arnold.shardingjdbc.store.entity.StoreInfo;

/**
 * <p>
 *  控制器
 * </p>
 *
 * @author arnold
 * @since 2019-12-30
*/
@RestController
@RequestMapping("/store/info")
public class StoreInfoController extends CurdController<StoreInfo> {

}
