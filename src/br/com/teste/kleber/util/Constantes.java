package br.com.teste.kleber.util;

public class Constantes {
	
	/*
	 * Stored Procedures tabela pacientes
	 */
	public static final String LISTAR_PACIENTES = "CALL FC_LISTA_PACIENTES";
	
	public static final String CADASTRAR_PACIENTE = "CALL FC_INSERE_PACIENTE (?,?)";
	
	public static final String BUSCAR_PACIENTE = "CALL FC_BUSCA_PACIENTE (?)";
	
	public static final String BUSCAR_PACIENTE_NOME = "CALL FC_BUSCA_PACIENTE_NM (?)";
	
	public static final String ATUALIZAR_PACIENTE = "CALL FC_ATUALIZA_PACIENTE (?,?,?)";
	
	public static final String EXCLUIR_PACIENTE = "CALL FC_DELETE_PACIENTE (?)";
	
	/*
	 * Stored Procedures tabela medico
	 */
	public static final String LISTAR_MEDICOS = "CALL FC_LISTA_MEDICOS";
	
	public static final String CADASTRAR_MEDICO = "CALL FC_INSERE_MEDICO (?,?,?)";
	
	public static final String BUSCAR_MEDICO = "CALL FC_BUSCA_MEDICO (?)";
	
	public static final String BUSCAR_MEDICO_NOME = "CALL FC_BUSCA_MEDICO_NM (?)";
	
	public static final String ATUALIZAR_MEDICO = "CALL FC_ATUALIZA_MEDICO (?,?,?,?)";
	
	public static final String EXCLUIR_MEDICO = "CALL FC_DELETE_MEDICO (?)";
	
	/*
	 * Stored Procedures tabela exame
	 */
	public static final String LISTAR_EXAMES = "CALL FC_LISTA_EXAMES";
	
	public static final String CADASTRAR_EXAME = "CALL FC_INSERE_EXAME (?,?,?,?,?)";
	
	public static final String BUSCAR_EXAME = "CALL FC_BUSCA_EXAME (?)";
	
	public static final String ATUALIZAR_EXAME = "CALL FC_ATUALIZA_EXAME (?,?,?,?,?,?)";
	
	public static final String EXCLUIR_EXAME = "CALL FC_DELETE_EXAME (?)";
	
	
	
	
	
	
}
