package br.com.consultamedica.services;

import java.time.LocalDateTime;
import java.util.List;

import br.com.consultamedica.DAO.AgendamentoDAO;
import br.com.consultamedica.model.Agendamento;
import br.com.consultamedica.model.enums.StatusConsulta;

public class AgendamentoService implements IGerenciador<Agendamento> {

	AgendamentoDAO dao;

	public AgendamentoService() {
		dao = new AgendamentoDAO();
	}

	@Override
	public void salvar(Agendamento agendamento) {
		List<Agendamento> allAgendamentos = this.listar();
		this.validarAgendamento(allAgendamentos, agendamento);
		this.dao.salvar(agendamento);
	}

	@Override
	public void remover(Long id) {
		this.dao.remover(id);
	}

	@Override
	public List<Agendamento> listar() {
		return this.dao.listar();
	}

	@Override
	public void editar(Agendamento agendamento) {
		this.dao.editarAgendamento(agendamento);

	}

	@Override
	public Agendamento buscaPorId(Long id) {
		return this.dao.buscarAgendamentoPorId(id);
	}

	@Override
	public Agendamento buscaPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Agendamento buscaPorEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public void reagendar(Agendamento agendamento) {

		List<Agendamento> allAgendamentos = this.listar();

		this.validarAgendamento(allAgendamentos, agendamento);

		Agendamento agendamentoBuscado = this.buscaPorId(agendamento.getId());

		if (!agendamentoBuscado.getDataAgendamento().isEqual(agendamento.getDataAgendamento())) {
			agendamento.setStautsConsulta(StatusConsulta.REAGENDADO);
			this.dao.editarAgendamento(agendamento);
		}

	}

	public void validarAgendamento(List<Agendamento> allAgendamentos, Agendamento agendamento) {
		
		allAgendamentos.forEach(a -> {
			if (a.getDataAgendamento().isEqual(agendamento.getDataAgendamento())
					&& a.getMedico().getId().equals(agendamento.getMedico().getId())) {
				throw new RuntimeException("Nao pode haver dois agendamentos na mesma data para o mesmo médico");
			}
		});

		if (agendamento.getDataAgendamento().isBefore(LocalDateTime.now())) {
			throw new RuntimeException("Data de agendamento não pode ser anterior a data atual");
		}
	}

}
