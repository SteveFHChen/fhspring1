package com.fh.springibatis.fhextend;

import com.ibatis.sqlmap.engine.impl.SqlMapExecutorDelegate;

public class FHSqlMapExecutorDelegate extends SqlMapExecutorDelegate {

	public FHSqlMapExecutorDelegate() {
		super();
		// TODO Auto-generated constructor stub
		this.sqlExecutor = new FHSqlExecutor();
	}

}
