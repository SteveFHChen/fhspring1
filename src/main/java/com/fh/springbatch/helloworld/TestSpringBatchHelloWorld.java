package com.fh.springbatch.helloworld;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * org/springframework/batch/core/configuration/xml/CoreNamespaceHandler : Unsupported major.minor version 52.0
 * Solution: Change JDK from 1.7 to 1.8
 * 
 * stanford parser和jdk版本对应关系
	J2SE 8 = 52,
	J2SE 7 = 51,
	J2SE 6.0 = 50,
	J2SE 5.0 = 49,
	JDK 1.4 = 48,
	JDK 1.3 = 47,
	JDK 1.2 = 46,
	JDK 1.1 = 45
 * 
 * 
 * Error creating bean with name 'jobRepository' defined in class path resource [com/fh/springbatch/helloworld/applicationContext_batch1.xml]: Invocation of init method failed; nested exception is java.lang.NoSuchMethodError: org.springframework.jdbc.support.incrementer.MySQLMaxValueIncrementer.setUseNewConnection(Z)V
 *Solution: change spring batch version from 4.x.x.RELEASE to 2.1.7.RELEASE;
 *		and recreate all the DB objects; 
 *
 */
public class TestSpringBatchHelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 * Application  <-------> Batch Core  <-------> Batch Infrastructure
		 * JobLauncher <---1:1----> Job <---1:n----> Step  <---1:1----> ItemReader&ItemProcessor&ItemWriter
		 * Ref:
		 * Spring Batch简单入门（一）- 简介
		 * 		https://blog.csdn.net/kangkanglou/article/details/82595136
		 * spring batch之二 一个简单的spring batch的例子
		 * 		https://blog.csdn.net/idler_bm/article/details/40688845
		 * Spring Boot下Spring Batch入门实例
		 * 		https://www.cnblogs.com/okokabcd/p/8792909.html
		 * spring batch中控制step的走向
		 * 		https://www.cnblogs.com/nizuimeiabc1/p/9669973.html
		 */
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/fh/springbatch/helloworld/applicationContext_batch1.xml");
		JobLauncher jobLauncher = ctx.getBean("jobLauncher", JobLauncher.class);
		Job job = ctx.getBean("jobHello", Job.class);
		
		JobParametersBuilder builder = new JobParametersBuilder();
		builder
			.addString("test", "test4")
			.addDate("date", new Date())
			.addLong("currenttime", System.currentTimeMillis())
			;
			
		try {
			jobLauncher.run(job, builder.addString("key1", "FHNext").toJobParameters());
			jobLauncher.run(job, builder.addString("key1", "FHEnd").toJobParameters());
			jobLauncher.run(job, builder.addString("key1", "FHFail").toJobParameters());
			jobLauncher.run(job, builder.addString("key1", "FHStop").toJobParameters());
			ctx.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
