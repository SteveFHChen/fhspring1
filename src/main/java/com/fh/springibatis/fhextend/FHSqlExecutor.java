package com.fh.springibatis.fhextend;

import java.sql.Connection;
import java.sql.SQLException;

import com.ibatis.sqlmap.engine.execution.SqlExecutor;
import com.ibatis.sqlmap.engine.mapping.statement.RowHandlerCallback;
import com.ibatis.sqlmap.engine.scope.StatementScope;

public class FHSqlExecutor extends SqlExecutor {

	@Override
	public int executeUpdate(StatementScope statementScope, Connection conn,
			String sql, Object[] parameters) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("SQL:"+sql);
		System.out.println("Parameters:"+parameters);
		return super.executeUpdate(statementScope, conn, sql, parameters);
	}

	@Override
	public void executeQuery(StatementScope statementScope, Connection conn,
			String sql, Object[] parameters, int skipResults, int maxResults,
			RowHandlerCallback callback) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("SQL:"+sql);
		System.out.println("Parameters:"+parameters);
		super.executeQuery(statementScope, conn, sql, parameters, skipResults,
				maxResults, callback);
	}

}
