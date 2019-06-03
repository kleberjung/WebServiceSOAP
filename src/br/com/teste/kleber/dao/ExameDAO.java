package br.com.teste.kleber.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.teste.kleber.model.Exame;
import br.com.teste.kleber.model.Medico;
import br.com.teste.kleber.model.Paciente;
import br.com.teste.kleber.util.Constantes;

public class ExameDAO {
	
	public List<Exame> getLista() throws Exception {
		List<Exame> exameLista = new ArrayList<Exame>();
		SQLConnector SQLConn = new SQLConnector();

		SQLConn.conecta();
		
		SQLConn.exec(Constantes.LISTAR_EXAMES);


		while (SQLConn.getResultset().next()) {
			Exame exame = new Exame();
			Medico medico = new Medico();
			Paciente paciente = new Paciente();
			exame.setId(SQLConn.getResultset().getInt("id"));
			exame.setExame(SQLConn.getResultset().getString("exame"));
			exame.setResponsavel(SQLConn.getResultset().getString("responsavel"));
			exame.setResultado(SQLConn.getResultset().getString("resultado"));
			
			medico = this.getMedico(SQLConn.getResultset().getInt("idMedico"));
			exame.setMedico(medico);

			paciente = this.getPaciente(SQLConn.getResultset().getInt("idPaciente"));
			exame.setPaciente(paciente);

			exameLista.add(exame);
			}

		SQLConn.desconecta();
		return exameLista; 
	}
	
	
	public void salva(Exame exame) throws Exception {
		
		SQLConnector SQLConn = new SQLConnector();
		SQLConn.conecta();
		
		
		Medico medico = new Medico();
		medico = getMedico(exame.getMedico().getNome());
		exame.setMedico(medico);
		
		Paciente paciente = new Paciente();
		paciente = getPaciente(exame.getPaciente().getNome());
		exame.setPaciente(paciente);
		
		PreparedStatement preparedStatement = SQLConn.getConexao().prepareStatement(Constantes.CADASTRAR_EXAME);
		preparedStatement.setString(1, exame.getExame());
		preparedStatement.setString(2, exame.getResponsavel());
		preparedStatement.setString(3,exame.getResultado());
		preparedStatement.setInt(4,exame.getMedico().getId());
		preparedStatement.setInt(5,exame.getPaciente().getId());
		
		preparedStatement.execute();
		
		SQLConn.desconecta();
	}
	
	public Exame getExame(int idExame) throws Exception{
		Exame exame = new Exame();
		
		SQLConnector SQLConn = new SQLConnector();
		
		SQLConn.conecta();
		
		PreparedStatement preparedStatement = SQLConn.getConexao().prepareStatement(Constantes.BUSCAR_EXAME);
		preparedStatement.setInt(1,idExame);
		ResultSet rs = preparedStatement.executeQuery();
		
		rs.first();
		exame.setId(rs.getInt("id"));
		exame.setExame(rs.getString("exame"));
		exame.setResponsavel(rs.getString("responsavel"));
		exame.setResultado(rs.getString("resultado"));
		
		Medico medico = new Medico();
		medico = this.getMedico(rs.getInt("idMedico"));
		exame.setMedico(medico);

		Paciente paciente = new Paciente();
		paciente = this.getPaciente(rs.getInt("idPaciente"));
		exame.setPaciente(paciente);
		
		SQLConn.desconecta();
		
		return exame;
	}
	
	public void atualizarExame(Exame exame) throws Exception {
		
		SQLConnector SQLConn = new SQLConnector();
		SQLConn.conecta();
		
		Medico medico = new Medico();
		medico = getMedico(exame.getMedico().getNome());
		exame.setMedico(medico);
		
		Paciente paciente = new Paciente();
		paciente = getPaciente(exame.getPaciente().getNome());
		exame.setPaciente(paciente);
		
		PreparedStatement preparedStatement = SQLConn.getConexao().prepareStatement(Constantes.ATUALIZAR_EXAME);
		preparedStatement.setString(1, exame.getExame());
		preparedStatement.setString(2, exame.getResponsavel());
		preparedStatement.setString(3, exame.getResultado());
		preparedStatement.setInt(4, exame.getMedico().getId());
		preparedStatement.setInt(5, exame.getPaciente().getId());
		preparedStatement.setInt(6, exame.getId());
		
		preparedStatement.execute();
		
		SQLConn.desconecta();
		
	}

	public void excluirExame(Exame exame) throws Exception {
		
		SQLConnector SQLConn = new SQLConnector();
		SQLConn.conecta();
		
		PreparedStatement preparedStatement = SQLConn.getConexao().prepareStatement(Constantes.EXCLUIR_EXAME);
		preparedStatement.setInt(1, exame.getId());
		preparedStatement.execute();
		
		SQLConn.desconecta();
		
	}
	
	
	
	
	
	
	
	private Medico getMedico(int idMedico) throws Exception {
		Medico medico = new Medico();
		MedicoDAO medicoDAO = new MedicoDAO();
		medico = medicoDAO.getMedico(idMedico);
		return medico;
	}
	

	
	private Medico getMedico(String nmMedico) throws Exception {
		Medico medico = new Medico();
		MedicoDAO medicoDAO = new MedicoDAO();
		medico = medicoDAO.getMedico(nmMedico);
		return medico;
	}
	
	private Paciente getPaciente(int idPaciente) throws Exception {
		Paciente paciente = new Paciente();
		PacienteDAO pacienteDAO = new PacienteDAO();
		paciente = pacienteDAO.getPaciente(idPaciente);
		return paciente;
	}
	
	private Paciente getPaciente(String nmPaciente) throws Exception {
		Paciente paciente = new Paciente();
		PacienteDAO pacienteDAO = new PacienteDAO();
		paciente = pacienteDAO.getPaciente(nmPaciente);
		return paciente;
	}

	
	
	

}
