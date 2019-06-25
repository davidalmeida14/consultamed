package br.com.consultamedica.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.consultamedica.model.Agendamento;
import br.com.consultamedica.model.Consulta;
import br.com.consultamedica.model.Contato;
import br.com.consultamedica.model.DiasAtendimento;
import br.com.consultamedica.model.Endereco;
import br.com.consultamedica.model.Medico;
import br.com.consultamedica.model.Paciente;
import br.com.consultamedica.model.enums.DiasDaSemana;
import br.com.consultamedica.model.enums.StatusConsulta;
import br.com.consultamedica.services.AgendamentoService;
import br.com.consultamedica.services.ConsultaService;
import br.com.consultamedica.services.ContatoService;
import br.com.consultamedica.services.EnderecoService;
import br.com.consultamedica.services.MedicoService;
import br.com.consultamedica.services.PacienteService;

public class Principal {
	

	public static void main(String[] args) {
		
		ContatoService service = new ContatoService();
		AgendamentoService agendamentoService = new AgendamentoService();
		PacienteService pacienteService = new PacienteService();
		EnderecoService enderecoService = new EnderecoService();
		MedicoService medicoService = new MedicoService();
		ConsultaService consultaService = new ConsultaService();
		
		System.out.println("Criando contato ");
		
//		service.editar(contato);
//		service.remover(contato.getId());
//		
//		List<Contato> contatos = service.listarContatos();
//		contatos.forEach(e->{
//			System.out.println("Nome: " + e.getNome());
//			System.out.println("Telefone: " + e.getTelefone());
//			System.out.println("Nome: " + e.getEmail());
//		});
//		
//		System.out.println("Contato: " + contato.getNome() + " cadastrado com sucesso!");
		
		Paciente paciente = new Paciente();
		paciente.setNome("David de Almeida");
		paciente.setCpf("10569116465");
		paciente.setDataNascimento(LocalDate.of(1995, 06, 06));
		paciente.setEmail("david_almeida_1@hotmail.com");
		pacienteService.salvar(paciente);
		
		Contato contato = new Contato();
		contato.setNome("David de Almeida Santos");
		contato.setEmail("david_almeida_1@hotmail.com");
		contato.setTelefone("8332332806");
		contato.setPaciente(paciente);
		service.salvar(contato);
		
		Endereco endereco = new Endereco();
		endereco.setLogradouro("Rua Antonio Claudino Leal");
		endereco.setBairro("Costa e Silva");
		endereco.setCidade("Joao Pessoa");
		endereco.setEstado("Paraiba");
		endereco.setCep("58081010");
		paciente.setEndereco(Arrays.asList(endereco));
		endereco.setPessoa(paciente);
		
		enderecoService.salvar(endereco);
		
		
		Medico medico = new Medico();
		medico.setNome("Roberto de Sales");
		medico.setCpf("03969905842");
		medico.setCrm("22154745");
		medico.setDataNascimento(LocalDate.of(1991, 06, 1));
		medicoService.salvar(medico);

		
		DiasAtendimento segunda = new DiasAtendimento(DiasDaSemana.SEGUNDA, medico);
		DiasAtendimento quarta = new DiasAtendimento(DiasDaSemana.QUARTA, medico);
		DiasAtendimento sexta = new DiasAtendimento(DiasDaSemana.SEXTA, medico);
		
		List<DiasAtendimento> dias = new ArrayList<DiasAtendimento>();
		
		dias.add(segunda);
		dias.add(quarta);
		dias.add(sexta);
		
		EntityManagerFactory em = JPAUtils.getEntityManagerFactory();
		EntityManager factory = em.createEntityManager();
		factory.getTransaction().begin();
		
		factory.persist(segunda);
		factory.persist(quarta);
		factory.persist(sexta);
		
		factory.getTransaction().commit();
		medico.setDiasAtendimento(dias);
		
		
//		
		Agendamento agendamento = new Agendamento();
		agendamento.setDataAgendamento(LocalDateTime.of(2019, 06, 25, 14, 00));
		agendamento.setStautsConsulta(StatusConsulta.AGENDADO);
		agendamento.setMedico(medico);
		agendamento.setPaciente(paciente);
//		
		agendamentoService.salvar(agendamento);
		
		Agendamento agendamento1 = new Agendamento();
		agendamento1.setDataAgendamento(LocalDateTime.of(2019, 06, 25, 15, 00));
		agendamento1.setStautsConsulta(StatusConsulta.AGENDADO);
		agendamento1.setMedico(medico);
		agendamento1.setPaciente(paciente);
//		
		agendamentoService.salvar(agendamento1);
		
		System.out.println(agendamento.getMedico().getNome());
		paciente.realizaAgendamento(agendamento);
		
		Consulta consulta = new Consulta();
		consulta.setAgendamento(agendamento);
		consulta.setMedico(medico);
		consultaService.salvar(consulta);
		
		List<Consulta> consultaPeriodo = consultaService.consultaPorPeriodo(LocalDateTime.of(2019, 06, 23, 00, 00, 00), 
													   LocalDateTime.of(2019, 06, 26, 00, 00, 00));

		System.out.println(consultaPeriodo.size());
		
		System.out.println("Cancelando consulta ...");
		System.out.println("Buscando consulta de Id 1 ...");
		
		consultaService = null;
		consultaService = new ConsultaService();
		Consulta consultaBuscada = consultaService.buscarPorId(1L);
		
		medicoService.cancelarConsulta(consultaBuscada, "Viagem para congresso");
		
		
		
		

		
	}

}
