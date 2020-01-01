package com.arnold.shardingjdbc.common.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {"com.arnold.shardingjdbc.product.mapper","com.arnold.shardingjdbc.store.mapper"}, sqlSessionFactoryRef = "shardingSessionFactory")
public class ShardingMybatisConfig {

    @Autowired
    @Qualifier("shardingDataSource")
    private DataSource shardingDataSource;

    /**
     * 使用mybatis plus 的SqlSessionFactory
     * @return
     */
    @Bean("shardingSessionFactory")
    public MybatisSqlSessionFactoryBean sqlSessionFactoryBean() {
        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(shardingDataSource);
        return sqlSessionFactoryBean;
    }


//    @Primary
//    @ConfigurationProperties(prefix = "mybatis")
//    public SqlSessionFactoryBean sqlSessionFactoryBean() {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(shardingDataSource);
//        return sqlSessionFactoryBean;
//    }

}
