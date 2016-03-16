package br.com.barros.view;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.barros.controller.PacienteRepository;
import br.com.barros.model.Paciente;
/**
 * @author Luciano Barros;
 *
 */
public class Menu {
	PacienteRepository pRepository = new PacienteRepository();
	
	static public void menu(Paciente p, PacienteRepository pRepository){
		Scanner cam = new Scanner(System.in);
		System.out.println("----------------------------");
		System.out.println("Bem vindo! ");
		System.out.println("----------------------------");
		System.out.println("Menu de Cadastro de Paciente");
		System.out.println("----------------------------");
		System.out.println("1 - Criar Paciente");
		System.out.println("2 - Listar Pacientes");
		System.out.println("3 - Buscar por identificador");
		System.out.println("4 - Atualizar Paciente");
		System.out.println("5 - Remover Paciente");
		System.out.println("----------------------------");
		System.out.println("6 - Sair");
		System.out.println("----------------------------");
		
		int choice = cam.nextInt();
		
		switch (choice) {
		case 1:
			criarViewNovoCadastro(p, pRepository);
			break;
				
		case 2:
			listarViewCadastro(p, pRepository);
			break;
		case 3: 
			buscarViewIdCadastro(pRepository);
			break;
		case 4:
			atualizarViewIdCadastro(p, pRepository);
			break;
		case 5: 
			removerViewCadastro(p, pRepository);
			break;
		case 6:
			System.out.println("Até a proxima!");
			System.exit(0);
			break;
		default:
			menu(p, pRepository);
			break;
		}
		cam.close();
	}
	
	// CASO 1: VAI PRA TELA DE CADASTRAR
	static public void criarViewNovoCadastro(Paciente p, PacienteRepository pRepository){
		p = new Paciente();
		Scanner cam = new Scanner(System.in);
		System.out.println("----------------------------");
		System.out.println("Tela de Cadastro");
		System.out.println("----------------------------");
		System.out.println("Nome: "); String nome = cam.next(); p.setNome(nome);
		System.out.println("Email: "); String email = cam.next(); p.setEmail(email);		
		System.out.println("Doença: "); String doenca = cam.next(); p.setDoenca(doenca);
		System.out.println("Medico: "); String medico = cam.next(); p.setMedico(medico);
		pRepository.save(p);
		System.out.println("Paciente Salvo!");
		System.out.println("----------------------------");
		System.out.println("1 - Cadastrar outro");
		System.out.println("2 - Voltar");
		System.out.println("3 - Sair");
		System.out.println("----------------------------");
		int choice = cam.nextInt();
		switch (choice) {
		case 1:
			criarViewNovoCadastro(p, pRepository);
			break;
		case 2:
			menu(p, pRepository);
			break;
		case 3: 
			System.out.println("Até a proxima!");
			System.exit(0);
			break;
		default:
			criarViewNovoCadastro(p, pRepository);
			break;
		}
		cam.close();
	}
	
	// CASO 2: VAI PRA TELA DE LISTAR
	static public void listarViewCadastro(Paciente p, PacienteRepository pRepository){
		Scanner cam = new Scanner(System.in);
		System.out.println("----------------------------");
		System.out.println("Lista de Pacientes");
		System.out.println("----------------------------");
		ArrayList<Paciente> listPaciente = new ArrayList<Paciente>();
		listPaciente = pRepository.exibeList();
		for(Paciente paciente: listPaciente){			
			System.out.println("--------- Registro ---------");
			System.out.println("Id: " + paciente.getId());
			System.out.println("Nome: " + paciente.getNome());
			System.out.println("Email: " + paciente.getEmail());
			System.out.println("Doenca: " + paciente.getDoenca());
			System.out.println("Medico:" + paciente.getMedico());
			System.out.println("----------------------------");
		}
		System.out.println("----------------------------");
		System.out.println("1 - Voltar");
		System.out.println("2 - Sair");
		System.out.println("----------------------------");
		int choice = cam.nextInt();
		switch (choice) {
		case 1:
			menu(p, pRepository);
			break;
		case 2:
			System.out.println("Até a proxima!");
			System.exit(0);
			break;
		default:
			listarViewCadastro(p, pRepository);
			break;
		}
		cam.close();
	}
	
	// CASO 3: BUSCAR PELO ID
	static public void buscarViewIdCadastro(PacienteRepository pRepository){
		Scanner cam = new Scanner(System.in);
		System.out.println("----------------------------");
		System.out.println("Buscar pelo Id");
		System.out.println("----------------------------");
		System.out.println("Insira o Id");
		int id = cam.nextInt();
		Paciente p = new Paciente();
		p = pRepository.findById(id);
		System.out.println("Resultado da Busca: ");
		System.out.println("----------------------------");
		System.out.println("Nome: " + p.getNome()); 
		System.out.println("Email: " + p.getEmail());		
		System.out.println("Doença: " + p.getDoenca());
		System.out.println("Medico: " + p.getMedico());
		System.out.println("----------------------------");
		
		System.out.println("----------------------------");
		System.out.println("1 - Voltar");
		System.out.println("2 - Sair");
		System.out.println("----------------------------");
		int choice = cam.nextInt();
		switch (choice) {
		case 1:
			menu(p, pRepository);
			break;
		case 2:
			System.out.println("Até a proxima!");
			System.exit(0);
			break;
		default:
			buscarViewIdCadastro(pRepository);
			break;
		}	
		cam.close();
	}
	
	// CASO 4: ATUALIZAR O PACIENTE
	static public void atualizarViewIdCadastro(Paciente paciente, PacienteRepository pRepository){
		Scanner cam = new Scanner(System.in);
		System.out.println("----------------------------");
		System.out.println("Editar Paciente");
		System.out.println("Busque pelo id: ");
		int id = cam.nextInt();
		Paciente p = new Paciente();
		p = pRepository.findById(id);
		System.out.println("----------------------------");
		System.out.println("Começe a edição");
		System.out.println("Atualize NOME de: " + p.getNome() +" Para: ");
		String nome = cam.next(); p.setNome(nome);
		System.out.println("Atualize EMAIL de: " + p.getEmail() +" Para: ");
		String email = cam.next(); p.setEmail(email);		
		System.out.println("Atualize DOENCA de: " + p.getDoenca() +" Para: "); 
		String doenca = cam.next(); p.setDoenca(doenca);
		System.out.println("Atualize MEDICO de: " + p.getMedico() +" Para: ");
		String medico = cam.next(); p.setMedico(medico);
		pRepository.update(id);
		System.out.println("----------------------------");
		System.out.println("1 - Atualizar outro");
		System.out.println("2 - Voltar");
		System.out.println("3 - Sair");
		System.out.println("----------------------------");		
		int choice = cam.nextInt();
		switch (choice) {
		case 1:
			atualizarViewIdCadastro(p, pRepository);
			break;
		case 2:
			menu(p, pRepository);
			break;
		case 3:
			System.out.println("Até a proxima!");
			System.exit(0);
			break;
		default:
			atualizarViewIdCadastro(paciente, pRepository);
			break;
		}
		cam.close();
	}
	
	// CASO 5: REMOVE PELO ID DO CARA
	static public void removerViewCadastro(Paciente p, PacienteRepository rRepository){
		Scanner cam = new Scanner(System.in);
		System.out.println("----------------------------");
		System.out.println("Remover pelo Id");
		System.out.println("----------------------------");
		System.out.println("Insira o Id");
		int id = cam.nextInt();
		rRepository.delete(id);
		System.out.println("Paciente removido!");
		System.out.println("----------------------------");
		System.out.println("1 - Remover outro");
		System.out.println("2 - Voltar");
		System.out.println("3 - Sair");
		System.out.println("----------------------------");
		int choice = cam.nextInt();
		switch (choice) {
		case 1:
			removerViewCadastro(p, rRepository);
			break;
		case 2:
			menu(p, rRepository);
			break;
		case 3:
			System.out.println("Até a proxima!");
			System.exit(0);
		default:
			removerViewCadastro(p, rRepository);
			break;
		}
		cam.close();
	}
}
