package com.rest.consultorio.service;

import java.io.InputStream;
import java.time.LocalDate;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.consultorio.dto.TituloEstatisticaProfissional;
import com.rest.consultorio.model.Titulo;
import com.rest.consultorio.repository.TituloRepository;
import com.rest.consultorio.service.exceptions.ResourceNotFoundException;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class TituloService {
	
	@Autowired
	private TituloRepository tituloRepository;
	
	
	public Titulo buscar(Long id) {
		Titulo titulo = tituloRepository.findTituloById(id);
		if(titulo == null) {
			throw new ResourceNotFoundException("Titulo com ID : " +id+ " não foi localizado!");
		}
		return titulo;
	}
	
	public Titulo salvar(Titulo titulo) {
		return tituloRepository.save(titulo);
	}
	
	public Titulo atualizar(Long id, Titulo titulo) {
		Titulo entity = tituloRepository.findTituloById(id);
		if(titulo == null) {
			throw new ResourceNotFoundException("Titulo com ID : " +id+ " não foi localizado!");
		}
		BeanUtils.copyProperties(titulo, entity, "id");
		tituloRepository.save(entity);
		return entity;
	}
	
	public void deletar(Long id) {
		Titulo titulo = tituloRepository.findTituloById(id);
		if(titulo == null) {
			throw new ResourceNotFoundException("Titulo com ID : " +id+ " não foi localizado ou já foi deletado!");
		}
		tituloRepository.delete(titulo);
	}
	
	public byte[] relatorioPorProfissional(LocalDate inicio, LocalDate fim) throws Exception {
		List<TituloEstatisticaProfissional> dados = tituloRepository.porProfissional(inicio, fim);
		
		Map<String, Object> params = new HashMap<>();
		params.put("DT_INICIO", Date.valueOf(inicio));
		params.put("DT_FIM", Date.valueOf(fim));
		params.put("REPORT_LOCALE", new Locale("pt", "BR"));
		
		InputStream inputStream = this.getClass().getResourceAsStream(
				"/relatorios/titulo-por-profissional.jasper");
		
		JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, params,
				new JRBeanCollectionDataSource(dados));
		
		return JasperExportManager.exportReportToPdf(jasperPrint);
		
	}

}