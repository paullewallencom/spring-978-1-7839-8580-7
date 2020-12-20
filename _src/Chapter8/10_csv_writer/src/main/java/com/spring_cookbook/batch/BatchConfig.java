package com.spring_cookbook.batch;

import java.io.File;

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
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.PathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

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
                .<User,User>chunk(1)
                .reader(reader(null))
                .processor(processor())
                .writer(writer(null))
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
    public FlatFileItemReader<User> reader(@Value("#{jobParameters[file]}") String csvFilePath) {
    	FlatFileItemReader<User> reader = new FlatFileItemReader<User>();
        reader.setLineMapper(lineMapper());
        reader.setResource(new PathResource(csvFilePath));
        
        reader.setLinesToSkip(1);
        reader.setEncoding("utf-8");
        
        return reader;
    }
    
    private LineMapper<User> lineMapper() {
    	DefaultLineMapper<User> lineMapper = new DefaultLineMapper<User>();
        
    	DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setNames(new String[]{"firstName","age"});
        lineTokenizer.setIncludedFields(new int[]{0,1});
        lineMapper.setLineTokenizer(lineTokenizer);
        
        BeanWrapperFieldSetMapper<User> fieldSetMapper = new BeanWrapperFieldSetMapper<User>();
        fieldSetMapper.setTargetType(User.class);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        
        return lineMapper;
    }
    
    @Bean
    public ItemProcessor<User,User> processor() {
        return new UserProcessorIncrementAge();
    }
    
    @Bean
    @StepScope
    public FlatFileItemWriter<User> writer(@Value("#{jobParameters[fileOut]}") String csvFilePath) {
        BeanWrapperFieldExtractor<User> fieldExtractor = new BeanWrapperFieldExtractor<User>();
        fieldExtractor.setNames(new String[]{"firstName","age"});

        DelimitedLineAggregator<User> lineAggregator = new DelimitedLineAggregator<User>();
        lineAggregator.setDelimiter(",");
        lineAggregator.setFieldExtractor(fieldExtractor);
        
        FlatFileItemWriter<User> writer = new FlatFileItemWriter<User>();
        writer.setLineAggregator(lineAggregator); 
        writer.setResource(new PathResource(csvFilePath));
        
        return writer;
    }
}
   