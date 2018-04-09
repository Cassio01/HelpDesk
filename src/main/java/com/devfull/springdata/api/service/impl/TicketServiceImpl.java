package com.devfull.springdata.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devfull.springdata.api.entity.ChangeStatus;
import com.devfull.springdata.api.entity.Ticket;
import com.devfull.springdata.api.repository.ChangeStatusRepository;
import com.devfull.springdata.api.repository.TicketRepository;
import com.devfull.springdata.api.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService{
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private ChangeStatusRepository changeStatusRepository;

	@Override
	public Ticket createOrUpdate(Ticket ticket) {
		// TODO Auto-generated method stub
		return this.ticketRepository.save(ticket);
	}

	@Override
	public Ticket findById(String id) {
		// TODO Auto-generated method stub
		return this.ticketRepository.findOne(id);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		this.ticketRepository.delete(id);
		
	}

	@Override
	public Page<Ticket> listTicket(int page, int count) {
		Pageable pages = new PageRequest(page, count);
		return this.ticketRepository.findAll(pages);
	}

	@Override
	public ChangeStatus createChangeStatus(ChangeStatus changeStatus) {
		// TODO Auto-generated method stub
		return this.changeStatusRepository.save(changeStatus);
	}

	@Override
	public Iterable<ChangeStatus> listChangeStatus(String ticketId) {
		// TODO Auto-generated method stub
		return this.changeStatusRepository.findByTicketIdOrderByDateChangeStatusDesc(ticketId);
	}

	@Override
	public Page<Ticket> findByCurrentUser(int page, int count, String userId) {
		// TODO Auto-generated method stub
		Pageable pages = new PageRequest(page, count);
		return this.ticketRepository.findByUserIdOrderByDateDesc(pages, userId);
	}

	@Override
	public Page<Ticket> findByParameters(int page, int count, String title, String status, String priority) {
		Pageable pages = new PageRequest(page, count);
		return this.ticketRepository.findByTitleIgnoreCaseContainingAndStatusAndPriorityOrderByDateDesc(title, status, priority, pages);
	}

	@Override
	public Page<Ticket> findByParametersAndCurrentUser(int page, int count, String title, String status,
			String priority, String userId) {
		Pageable pages = new PageRequest(page, count);
		return this.ticketRepository.findByTitleIgnoreCaseContainingAndStatusAndPriorityAndUserIdOrderByDateDesc(title, status, priority, pages);
	}

	@Override
	public Page<Ticket> findByNumber(int page, int count, Integer number) {
		Pageable pages = new PageRequest(page, count);
		return this.ticketRepository.findByNumber(number, pages);
	}

	@Override
	public Iterable<Ticket> findAll() {
		// TODO Auto-generated method stub
		return this.ticketRepository.findAll();
	}

	@Override
	public Page<Ticket> findByParameterAndAssingedUser(int page, int count, String title, String status,
			String priority, String assingnedUser) {
		Pageable pages = new PageRequest(page, count);
		return this.ticketRepository.findByTitleIgnoreCaseContainingAndStatusAndPriorityAndAssingedUserIdOrderByDateDesc(title, status, priority, pages);
	}

}
