package com.fh.springbatch.helloworld.db;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class StudentWriter implements ItemWriter<Student> {

	private StudentDao studentDao;

	@Override
	public void write(final List<? extends Student> students) throws Exception {
		for (Student item : students) {
			studentDao.update(item);
		}
	}
}
