package com.spring_cookbook.batch;

import java.util.Collections;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.ItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.PathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.oxm.xstream.XStreamMarshaller;

import com.spring_cookbook.domain.User;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	private JobBuilderFactory jobs;

	@Autowired
	private StepBuilderFactory steps;
    
    @Bean
    public Job job1(){
        return jobs.get("job1")
                .start(step1())
                .build();
    }
           
    @Bean
    public Step step1(){
        return steps.get("step")
                .<User,User>chunk(2)
                .reader(reader(null))
                .processor(processor())
                .writer(writer())
                .build();
    }
    
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/db1");
		dataSource.setUsername("root");
		dataSource.setPassword("123");

		return dataSource;
	}
	    
    @Bean
    @StepScope
    public StaxEventItemReader<User> reader(@Value("#{jobParameters[file]}") String xmlFilePath) {        
        StaxEventItemReader<User> reader = new StaxEventItemReader<User>();
        reader.setResource(new PathResource(xmlFilePath));
        reader.setFragmentRootElementName("person");

    	XStreamMarshaller marshaller = new XStreamMarshaller();
    	marshaller.setAliases(Collections.singletonMap("person", User.class)); 
    	reader.setUnmarshaller(marshaller);
      
    	return reader;
    }
    
    @Bean
    public ItemProcessor<User,User> processor() {
        return new UserProcessorIncrementAge();
    }
    
    @Bean
    public JdbcBatchItemWriter<User> writer(){
	    JdbcBatchItemWriter<User> writer = new JdbcBatchItemWriter<User>();
	    writer.setDataSource(dataSource());
	    writer.setSql("INSERT INTO user (first_name, age) " +
	    		"VALUES ( :firstName, :age)");
	    ItemSqlParameterSourceProvider<User> paramProvider = new BeanPropertyItemSqlParameterSourceProvider<User>();
	    writer.setItemSqlParameterSourceProvider(paramProvider);
	    return writer;
    }
}
   