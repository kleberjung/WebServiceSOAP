package br.com.teste.kleber.webservice;

import br.com.teste.kleber.dao.ExameDAO;
import br.com.teste.kleber.model.Exame;

public class Service {
	
	public Exame getExame(int id){
	
	Exame exame = new Exame();
	
		ExameDAO exameDAO = new ExameDAO();
		
		try {
			exame = exameDAO.getExame(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exame;
	}
}
