package br.com.barros.controller;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.barros.model.Paciente;

/**
 * @author Luciano Barros;
 *
 */
public class PacienteRepository {
	
	EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud");
	EntityManager gerente = fabrica.createEntityManager();
	
	public PacienteRepository(){
		super();
	}
	
	public PacienteRepository(EntityManagerFactory fabrica, EntityManager gerente ){
		this.fabrica = fabrica;
		this.gerente = gerente;
	}
	
	public void save(Paciente p){
		gerente.getTransaction().begin();
		gerente.persist(p);
		gerente.getTransaction().commit();
	}
	
	public Paciente findById(Integer id){
		gerente.getTransaction().begin();
		Paciente p = new Paciente();
		p = gerente.find(Paciente.class, id);
		gerente.getTransaction().commit();
		return p;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Paciente> exibeList(){
		gerente.getTransaction().begin();
		ArrayList<Paciente> ĺistPaciente = new ArrayList<Paciente>();
		String query = "select * from Paciente";
		Query consulta = gerente.createNativeQuery(query, Paciente.class);
		ĺistPaciente = (ArrayList<Paciente>) consulta.getResultList();
		gerente.getTransaction().commit();
		return ĺistPaciente;
	}
	
	public void update(int id){
		gerente.getTransaction().begin();
		Paciente p = new Paciente();
		p = gerente.find(Paciente.class, id);
		gerente.merge(p);
		gerente.getTransaction().commit();
	}
	
	public void delete(int id){
		gerente.getTransaction().begin();
		Paciente p = new Paciente();
		p = gerente.find(Paciente.class, id);
		gerente.remove(p);
		gerente.getTransaction().commit();
	}
}