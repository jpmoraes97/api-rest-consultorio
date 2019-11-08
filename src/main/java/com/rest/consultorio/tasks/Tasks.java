package com.rest.consultorio.tasks;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.rest.consultorio.model.Agendamento;
import com.rest.consultorio.model.Titulo;
import com.rest.consultorio.repository.AgendamentoRepository;
import com.rest.consultorio.repository.TituloRepository;

@EnableScheduling
@Component
public class Tasks {
	
	private static final String TIME_ZONE = "America/Sao_Paulo";
	
	@Autowired
	private JavaMailSender sender;
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	@Autowired
	private TituloRepository tituloRepository;
	
	@Autowired
	private TemplateEngine thymeleaf;
	
	
	@Scheduled(cron = "0 0 18 * * MON-FRI", zone = TIME_ZONE)
	public void lembrarTitulos() {
		List<Titulo> todos = tituloRepository.findAll();
		List<Titulo> titulos = new ArrayList<Titulo>();
		
		for(Titulo titulo : todos) {
			if(titulo.getDataVencimento().equals(LocalDate.now())) {
				titulos.add(titulo);
			}
		}
		
		Map<String, Object> variaveis = new HashMap<>();
		variaveis.put("titulos", titulos);
		String template = "mail/aviso-titulos-vencidos";
		
		Context context = new Context(new Locale("pt", "BR"));
		
		variaveis.entrySet().forEach(e -> context.setVariable(e.getKey(), e.getValue()));
		
		String mensagem = thymeleaf.process(template, context);
		
		MimeMessage msg = sender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(msg, "utf-8");
		
		try {
		
		helper.setTo("joaopedro_moraes97@outlook.com");
		helper.setSubject("Aviso de titulos vencidos");
		helper.setText(mensagem , true);
		sender.send(msg);
		
		}catch(MessagingException e) {
			e.printStackTrace();
			System.out.println("Problema com envio do E-mail");
		}
			
	}
	

	/*
	 * TAREFA VERIFICA AS 5:30 DE SEGUNDA A SEXTA OS AGENDAMENTOS
	 * QUE POSSUI NAQUELE DIA E ENVIA LEMBRETE NO EMAIL DO PACIENTE
	 * cron = "0 30 5 * * MON-FRI", zone = TIME_ZONE
	 */
	@Scheduled(cron = "0 30 5 * * MON-FRI", zone = TIME_ZONE)
	public void verificarAgendamentos() {
		
		Iterable<Agendamento> agendamentos = agendamentoRepository.findAll();
		
		for(Agendamento agendamento : agendamentos) {
			
			if(agendamento.getData().equals(LocalDate.now())) {
				
				SimpleMailMessage msg = new SimpleMailMessage();
				
				msg.setTo(agendamento.getPaciente().getEmail());
				
				msg.setSubject("Lembrete de consulta");
				
				msg.setText("Bom dia " + agendamento.getPaciente().getNome()+ " !!\n"
						+ "Estou passando para lembrar que você possui uma consulta hoje com "
						+ agendamento.getProfissional().getNome() + " às " + agendamento.getHorario() + " hrs.\n"
						+ "Se possível, chegar com uns 10 minutos de antecedência.\n"
						+ "Caso não consiga vir hoje, entre em contato para remarcar-mos a sua consulta.");
				
				sender.send(msg);
					
			}
		}
	}
	
	/*
	 * ESSA TAREFA VERIFICA TODOS OS AGENDAMENTOS CADASTRADOS E COMPARA COM A DATA ATUAL
	 * CASO O ATENDIMENTO JÁ TENHA SIDO REALIZADO, O CADASTRO É EXCLUIDO PARA LIMPAR O BANCO DE DADOS!
	 */
	@Scheduled(cron = "0 30 5 * * MON-FRI", zone = TIME_ZONE)
	public void deletaAgendamentosRealizados() {
		Iterable<Agendamento> todos = agendamentoRepository.findAll();
		for(Agendamento a : todos) {
			if(a.getData().isBefore(LocalDate.now())) {
				agendamentoRepository.delete(a);
			}
			System.out.println("Agendamentos deletados com sucesso!");
		}
	}
	
	
}