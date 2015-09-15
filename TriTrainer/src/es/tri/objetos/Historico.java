package es.tri.objetos;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import es.mybatis.MyBatisConnectionFactory;
import es.tri.dao.TriTEjerciciosMapper;
import es.tri.dao.TriTEntrenosMapper;
import es.tri.dao.TriTTipoEjercicioMapper;
import es.tri.dao.model.TriTEjercicios;
import es.tri.dao.model.TriTEntrenos;
import es.tri.dao.model.TriTEntrenosExample;
import es.tri.dao.model.TriTHistorico;
import es.tri.dao.model.TriTTest;
import es.tri.dao.model.TriTTestExample;
import es.tri.dao.model.TriTTipoEjercicio;

public class Historico {
	 private Integer id_historico;
	 private String descripcion;
	 
	public Integer getId_historico() {
		return id_historico;
	}
	public void setId_historico(Integer id_historico) {
		this.id_historico = id_historico;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	 
	public static List<Historico> setHistorico (List<TriTHistorico> historico){
		int i =0;
		List<Historico> historicoReturn = new ArrayList<Historico> ();
		Historico HistoricoAux;	
		
		for (TriTHistorico lista : historico){	
			i++;
			HistoricoAux = new Historico();
			HistoricoAux.setDescripcion(lista.getDescripcion());
			HistoricoAux.setId_historico(lista.getIdHistorico());
			historicoReturn.add(HistoricoAux);
			if (i>4) return historicoReturn;
		}
		
		return historicoReturn;
		
	}
}
