package com.arnold.shardingjdbc.common.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {"com.arnold.shardingjdbc.UserEncrypt.mapper"}, sqlSessionFactoryRef = "encryptSessionFactory")
public class EncryptMybatisConfig {

    @Autowired
    @Qualifier("encryptDataSource")
    private DataSource encryptDataSource;

    /**
     * 使用mybatis plus 的SqlSessionFactory
     * @return
     */
    @Bean("encryptSessionFactory")
    public MybatisSqlSessionFactoryBean sqlSessionFactoryBean() {
        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(encryptDataSource);
        return sqlSessionFactoryBean;
    }
}
