package com.fh.javatest.thread4executor;

import java.io.Serializable;

public class ThreadPoolTask implements Runnable, Serializable {

	private static final long serialVersionUID = 5629922503465441651L;
	
	private Object threadPoolTaskData;
	private static int produceTaskSleepTime = 10000;
	
	public ThreadPoolTask(Object threadPoolTaskData){
		super();
		this.threadPoolTaskData = threadPoolTaskData;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("start..."+this.threadPoolTaskData);
		try{
			//Simulate thread is processing task
			Thread.sleep(this.produceTaskSleepTime);
			if(this.threadPoolTaskData.toString().equals("task@3")){
				throw new RuntimeException("task@3 throw exception.");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("stop..."+this.threadPoolTaskData);
		this.threadPoolTaskData = null;
	}
	
	public Object getTask(){
		return this.threadPoolTaskData;
	}

}
