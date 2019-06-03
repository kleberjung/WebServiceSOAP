package br.com.teste.kleber.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.teste.kleber.model.Paciente;
import br.com.teste.kleber.util.Constantes;

public class PacienteDAO {
	
	public List<Paciente> getLista() throws Exception {

		List<Paciente> pacienteLista = new ArrayList<Paciente>();
		SQLConnector SQLConn = new SQLConnector();

		SQLConn.conecta();
		
		SQLConn.exec(Constantes.LISTAR_PACIENTES);


		while (SQLConn.getResultset().next()) {
			Paciente paciente = new Paciente();
			paciente.setId(SQLConn.getResultset().getInt("id"));
			paciente.setNome(SQLConn.getResultset().getString("nome"));
			paciente.setConvenio(SQLConn.getResultset().getString("convenio"));
			pacienteLista.add(paciente);
			}
		SQLConn.desconecta();
		return pacienteLista; 
	}
	
	public void salva(Paciente paciente) throws Exception {
		
		SQLConnector SQLConn = new SQLConnector();
		SQLConn.conecta();
		
		PreparedStatement preparedStatement = SQLConn.getConexao().prepareStatement(Constantes.CADASTRAR_PACIENTE);
		preparedStatement.setString(1, paciente.getNome());
		preparedStatement.setString(2, paciente.getConvenio());
		preparedStatement.execute();
		
		SQLConn.desconecta();
	}
	
	
	
	public Paciente getPaciente(int idPaciente) throws Exception {

		Paciente paciente = new Paciente();
		
		SQLConnector SQLConn = new SQLConnector();

		SQLConn.conecta();
		
		PreparedStatement preparedStatement = SQLConn.getConexao().prepareStatement(Constantes.BUSCAR_PACIENTE);
		preparedStatement.setInt(1, idPaciente);
		ResultSet rs = preparedStatement.executeQuery();
		
		rs.first();
		paciente.setId(rs.getInt("id"));
		paciente.setNome(rs.getString("nome"));
		paciente.setConvenio(rs.getString("convenio"));
		
		SQLConn.desconecta();
		return paciente; 
	}
	
	
	public Paciente getPaciente(String nome) throws Exception {

		Paciente paciente = new Paciente();
		
		SQLConnector SQLConn = new SQLConnector();

		SQLConn.conecta();
		
		PreparedStatement preparedStatement = SQLConn.getConexao().prepareStatement(Constantes.BUSCAR_PACIENTE_NOME);
		preparedStatement.setString(1, nome);
		ResultSet rs = preparedStatement.executeQuery();
		
		rs.first();
		paciente.setId(rs.getInt("id"));
		paciente.setNome(rs.getString("nome"));
		paciente.setConvenio(rs.getString("convenio"));
		
		SQLConn.desconecta();
		return paciente; 
	}
	
	

	public void atualizarPaciente(Paciente paciente) throws Exception {
		
		SQLConnector SQLConn = new SQLConnector();
		SQLConn.conecta();
		
		PreparedStatement preparedStatement = SQLConn.getConexao().prepareStatement(Constantes.ATUALIZAR_PACIENTE);
		preparedStatement.setString(1, paciente.getNome());
		preparedStatement.setString(2, paciente.getConvenio());
		preparedStatement.setInt(3, paciente.getId());
		preparedStatement.execute();
		
		SQLConn.desconecta();
		
	}
	
	
	
	
	public void excluirPaciente(Paciente paciente) throws Exception {
		
		SQLConnector SQLConn = new SQLConnector();
		SQLConn.conecta();
		
		PreparedStatement preparedStatement = SQLConn.getConexao().prepareStatement(Constantes.EXCLUIR_PACIENTE);
		preparedStatement.setInt(1, paciente.getId());
		preparedStatement.execute();
		
		SQLConn.desconecta();
		
	}
	


}
