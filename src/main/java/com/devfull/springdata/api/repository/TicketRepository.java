package com.devfull.springdata.api.repository;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.devfull.springdata.api.entity.Ticket;

public interface TicketRepository extends MongoRepository<Ticket, String> {

	Page<Ticket> findByUsuarioIdOrderByDataDesc(Pageable pages, String usuarioId);

	Page<Ticket> findByTituloIgnoreCaseContainingAndStatusIgnoreCaseContainingAndPrioridadeIgnoreCaseContainingOrderByDataDesc(
			String titulo, String status, String prioridad, Pageable pages);

	Page<Ticket> findByTituloIgnoreCaseContainingAndStatusIgnoreCaseContainingAndPrioridadeIgnoreCaseContainingAndUsuarioIdOrderByDataDesc(
			String titulo, String status, String prioridad, Pageable pages);
	
	Page<Ticket> findByTituloIgnoreCaseContainingAndStatusIgnoreCaseContainingAndPrioridadeIgnoreCaseContainingAndSolicitacaoUsuarioOrderByDataDesc(
			String titulo, String status, String prioridad, Pageable pages);
	
	Page<Ticket> findByNumero(Integer numero, Pageable pages);
}
