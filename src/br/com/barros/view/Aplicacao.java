package br.com.barros.view;

import br.com.barros.controller.PacienteRepository;
import br.com.barros.model.Paciente;


/**
 * @author Luciano Barros;
 *
 */
public class Aplicacao {

	public static void main(String[] args) {
		try {
			Paciente p = new Paciente();
			PacienteRepository rRepository = new PacienteRepository();
			Menu.menu(p, rRepository);			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			Paciente p = new Paciente();
			PacienteRepository rRepository = new PacienteRepository();
			Menu.menu(p, rRepository);
		}
	}
}