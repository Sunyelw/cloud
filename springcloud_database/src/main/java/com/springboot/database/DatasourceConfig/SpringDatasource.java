package com.springboot.database.DatasourceConfig;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 项目名称:   pinkstone
 * 包:        com.springboot.database.DatasourceConfig
 * 类名称:     SpringDatasource
 * 类描述:     springdatasource config
 * 创建人:     huangyang
 * 创建时间:   2018/8/23 21:00
 */
@Configuration
@MapperScan(basePackages = "com.springboot.database.smdata", sqlSessionTemplateRef  = "smSqlSessionTemplate")
public class SpringDatasource {

	@Bean(name = "smDatasource")
	@ConfigurationProperties(prefix = "spring.datasource.mybatisdatasource")
	@Primary
	public DataSource smDatasource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "smSqlSessionFactory")
	@Primary
	public SqlSessionFactory smSqlSessionFactory(@Qualifier("smDatasource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		return bean.getObject();
	}

	@Bean(name = "smTransactionManager")
	@Primary
	public DataSourceTransactionManager smTransactionManager(@Qualifier("smDatasource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = "smSqlSessionTemplate")
	@Primary
	public SqlSessionTemplate smSqlSessionTemplate(@Qualifier("smSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
