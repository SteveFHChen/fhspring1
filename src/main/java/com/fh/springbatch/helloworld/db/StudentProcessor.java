package com.fh.springbatch.helloworld.db;

import org.springframework.batch.item.ItemProcessor;

public class StudentProcessor implements ItemProcessor<Student, Student> {

	@Override
	public Student process(final Student student) throws Exception {
		student.setAge(student.getAge() + 1);
		return student;
	}
}
