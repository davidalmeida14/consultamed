package br.com.consultamedica.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import br.com.consultamedica.model.Agendamento;
import br.com.consultamedica.model.Contato;
import br.com.consultamedica.model.Endereco;
import br.com.consultamedica.model.Medico;
import br.com.consultamedica.model.Paciente;
import br.com.consultamedica.model.enums.StatusConsulta;
import br.com.consultamedica.services.ContatoService;

public class Principal {
	
	public static void main(String[] args) {
		
		ContatoService service = new ContatoService();
		
		System.out.println("Criando contato ");
		
		Contato contato = new Contato();
		contato.setId(1L);
		contato.setNome("David de Almeida Santos");
		contato.setEmail("david_almeida_1@hotmail.com");
		contato.setTelefone("8332332806");
		
		//service.salvar(contato);
		//service.editar(contato);
		//service.remover(contato.getId());
		
		List<Contato> contatos = service.listarContatos();
		contatos.forEach(e->{
			System.out.println("Nome: " + e.getNome());
			System.out.println("Telefone: " + e.getTelefone());
			System.out.println("Nome: " + e.getEmail());
		});
		
		System.out.println("Contato: " + contato.getNome() + " cadastrado com sucesso!");
		
		Paciente paciente = new Paciente();
		paciente.setNome("David de Almeida");
		paciente.setCpf("10569116465");
		paciente.setDataNascimento(LocalDate.of(1995, 06, 06));
		paciente.setEmail("david_almeida_1@hotmail.com");
		
		Endereco endereco = new Endereco();
		endereco.setLogradouro("Rua Antonio Claudino Leal");
		endereco.setBairro("Costa e Silva");
		endereco.setCidade("Joao Pessoa");
		endereco.setEstado("Paraiba");
		endereco.setCep("58081010");
		paciente.setEndereco(endereco);
		
		Medico medico = new Medico();
		medico.setNome("Roberto de Sales");
		medico.setCpf("03969905842");
		medico.setCrm("22154745");
		
		Agendamento agendamento = new Agendamento();
		agendamento.setData(LocalDateTime.of(2019, 06, 25, 14, 00));
		agendamento.setStautsConsulta(StatusConsulta.AGENDADO);
		agendamento.setMedico(medico);
		agendamento.setPaciente(paciente);
		
		paciente.realizaAgendamento(agendamento);
		
	}

}
