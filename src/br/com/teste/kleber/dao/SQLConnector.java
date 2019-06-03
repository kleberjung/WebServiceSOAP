package br.com.teste.kleber.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnector {
	
	private String user = "crud";
	private String pwd = "crud";
	private String url = "jdbc:mysql://127.0.0.1:3306/exame";
	private String driver = "org.gjt.mm.mysql.Driver";
	
	private Connection conexao;
	private Statement statement;
	private ResultSet resultset;
	private PreparedStatement preparedStatement; 
	
	public Connection getConexao() {
		return conexao;
	}

	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public ResultSet getResultset() {
		return resultset;
	}

	public void setResultset(ResultSet resultset) {
		this.resultset = resultset;
	}

	public PreparedStatement getPreparedStatement() {
		return preparedStatement;
	}

	public void setPreparedStatement(PreparedStatement preparedStatement) {
		this.preparedStatement = preparedStatement;
	}

	public void conecta() throws Exception {
 
	    Class.forName(driver);
	    conexao = DriverManager.getConnection(url, user, pwd);
	    statement = conexao.createStatement();
	  }
	  
	  public void exec(String sql) throws Exception {
	   resultset = statement.executeQuery(sql);
	  }
	  
	  public void exec2(String sql) throws Exception {
		   statement.executeQuery(sql);
	  }
 	  
	  public void desconecta() {
	    try  {
	        conexao.close();
	    }
	    catch(SQLException e) {
	    	System.out.println("Não foi possivel fechar o banco de dados: " + e.getMessage());
	    }

  }
}