package com.arnold.shardingjdbc.store.service.impl;

import com.arnold.shardingjdbc.store.entity.StoreInfo;
import com.arnold.shardingjdbc.store.mapper.StoreInfoMapper;
import com.arnold.shardingjdbc.store.service.IStoreInfoService;
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
public class StoreInfoServiceImpl extends ServiceImpl<StoreInfoMapper, StoreInfo> implements IStoreInfoService {

}
