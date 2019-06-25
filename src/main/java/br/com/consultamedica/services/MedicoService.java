package br.com.consultamedica.services;

import java.time.LocalDateTime;
import java.util.List;

import br.com.consultamedica.DAO.MedicoDAO;
import br.com.consultamedica.model.Agendamento;
import br.com.consultamedica.model.Consulta;
import br.com.consultamedica.model.Medico;
import br.com.consultamedica.model.enums.StatusConsulta;

public class MedicoService implements IGerenciador<Medico> {

	MedicoDAO medicoDAO = new MedicoDAO();
	ConsultaService consultaService = new ConsultaService();
	AgendamentoService agendamentoService = new AgendamentoService();
	
	@Override
	public void salvar(Medico medico) {
		this.medicoDAO.salvar(medico);
	}

	@Override
	public void remover(Long id) {
		this.medicoDAO.remover(id);
	}

	@Override
	public List<Medico> listar() {
		return this.medicoDAO.listar();
	}

	@Override
	public void editar(Medico medico) {
		this.medicoDAO.editar(medico);
		
	}

	@Override
	public Medico buscaPorId(Long id) {
		return this.medicoDAO.buscarPorId(id);
	}

	@Override
	public Medico buscaPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Medico buscaPorEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void cancelarConsulta(Consulta consulta, String descricaoCancelamento) {
		
		LocalDateTime dataCancelamento = LocalDateTime.now();
		
		Agendamento agendamentoBuscado = agendamentoService.buscaPorId(consulta.getAgendamento().getId());
		agendamentoBuscado.setDataCancelamento(dataCancelamento);
		agendamentoBuscado.setDescricaoCancelamento(descricaoCancelamento);
		agendamentoBuscado.setStautsConsulta(StatusConsulta.CANCELADO);
		
		agendamentoService.editar(agendamentoBuscado);
		
		consulta.setAgendamento(agendamentoBuscado);
		consulta.setDataCancelamentoConsulta(dataCancelamento);
		consulta.setStatusConsulta(StatusConsulta.CANCELADO);
		
		consultaService.dao.editar(consulta);
	}

}
