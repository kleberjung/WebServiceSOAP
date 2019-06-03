package br.com.teste.kleber.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.teste.kleber.model.Medico;
import br.com.teste.kleber.model.Paciente;
import br.com.teste.kleber.util.Constantes;

public class MedicoDAO {
	
	public List<Medico> getLista() throws Exception {
		List<Medico> medicoLista = new ArrayList<Medico>();
		SQLConnector SQLConn = new SQLConnector();

		SQLConn.conecta();
		
		SQLConn.exec(Constantes.LISTAR_MEDICOS);


		while (SQLConn.getResultset().next()) {
			Medico medico = new Medico();
			medico.setId(SQLConn.getResultset().getInt("id"));
			medico.setNome(SQLConn.getResultset().getString("nome"));
			medico.setEspecialidade(SQLConn.getResultset().getString("especialidade"));
			medico.setCrm(SQLConn.getResultset().getString("crm"));
			medicoLista.add(medico);
			}
		SQLConn.desconecta();
		return medicoLista; 
	}
	
	
	
	public void salva(Medico medico) throws Exception {
		
		SQLConnector SQLConn = new SQLConnector();
		SQLConn.conecta();
		
		PreparedStatement preparedStatement = SQLConn.getConexao().prepareStatement(Constantes.CADASTRAR_MEDICO);
		preparedStatement.setString(1, medico.getNome());
		preparedStatement.setString(2, medico.getEspecialidade());
		preparedStatement.setString(3,medico.getCrm());
		
		
		preparedStatement.execute();
		
		SQLConn.desconecta();
	}
	
	
	
	public Medico getMedico(int idMedico) throws Exception {

		Medico medico = new Medico();
		
		SQLConnector SQLConn = new SQLConnector();

		SQLConn.conecta();
		
		PreparedStatement preparedStatement = SQLConn.getConexao().prepareStatement(Constantes.BUSCAR_MEDICO);
		preparedStatement.setInt(1, idMedico);
		ResultSet rs = preparedStatement.executeQuery();
		
		rs.first();
		medico.setId(rs.getInt("id"));
		medico.setNome(rs.getString("nome"));
		medico.setEspecialidade(rs.getString("especialidade"));
		medico.setCrm(rs.getString("crm"));
		
		SQLConn.desconecta();
		return medico; 
	}
	
	public Medico getMedico(String nome) throws Exception {

		Medico medico = new Medico();
		
		SQLConnector SQLConn = new SQLConnector();

		SQLConn.conecta();
		
		PreparedStatement preparedStatement = SQLConn.getConexao().prepareStatement(Constantes.BUSCAR_MEDICO_NOME);
		preparedStatement.setString(1, nome);
		ResultSet rs = preparedStatement.executeQuery();
		
		rs.first();
		medico.setId(rs.getInt("id"));
		medico.setNome(rs.getString("nome"));
		medico.setEspecialidade(rs.getString("especialidade"));
		medico.setCrm(rs.getString("crm"));
		
		SQLConn.desconecta();
		return medico; 
	}
	
	
	
	
	
	public void atualizarMedico(Medico medico) throws Exception {
		
		SQLConnector SQLConn = new SQLConnector();
		SQLConn.conecta();
		
		PreparedStatement preparedStatement = SQLConn.getConexao().prepareStatement(Constantes.ATUALIZAR_MEDICO);
		preparedStatement.setString(1, medico.getNome());
		preparedStatement.setString(2, medico.getEspecialidade());
		preparedStatement.setString(3, medico.getCrm());
		preparedStatement.setInt(4, medico.getId());
		preparedStatement.execute();
		
		SQLConn.desconecta();
		
	}
	
	public void excluirMedico(Medico medico) throws Exception {
		
		SQLConnector SQLConn = new SQLConnector();
		SQLConn.conecta();
		
		PreparedStatement preparedStatement = SQLConn.getConexao().prepareStatement(Constantes.EXCLUIR_MEDICO);
		preparedStatement.setInt(1, medico.getId());
		preparedStatement.execute();
		
		SQLConn.desconecta();
		
	}

}
