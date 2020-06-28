package com.fh.springbatch.helloworld;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;

public class HelloDecider implements JobExecutionDecider {

	private int count = 5;
	
	@Override
	public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
		// TODO Auto-generated method stub
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this.getClass().getName() + " is finished.");
		
		/*
		if(count==4) {
			return new FlowExecutionStatus("FHNext");
		}else if(count==3) {
			return new FlowExecutionStatus("FHEnd");
		}else if(count==2) {
			return new FlowExecutionStatus("FHFail");
		}else if(count==1) {
			return new FlowExecutionStatus("FHStop");
		}else if(count==0) {
			return new FlowExecutionStatus("FH0");
		}else {
			return FlowExecutionStatus.COMPLETED;
		}*/
		
		JobParameters jobParams = jobExecution.getJobParameters();
		return new FlowExecutionStatus(jobParams.getString("key1"));
	}

}
