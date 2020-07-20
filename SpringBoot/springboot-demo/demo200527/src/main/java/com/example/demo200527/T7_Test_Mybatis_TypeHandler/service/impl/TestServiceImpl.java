package com.example.demo200527.T7_Test_Mybatis_TypeHandler.service.impl;



import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo200527.T7_Test_Mybatis_TypeHandler.entity.TestEntity;
import com.example.demo200527.T7_Test_Mybatis_TypeHandler.mapper.TestMapper;
import com.example.demo200527.T7_Test_Mybatis_TypeHandler.service.ITestService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author arnold
 * @since 2020-01-10
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, TestEntity> implements ITestService {

}
