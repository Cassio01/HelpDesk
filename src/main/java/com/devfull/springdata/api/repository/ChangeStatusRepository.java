package com.devfull.springdata.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.devfull.springdata.api.entity.ChangeStatus;

public interface ChangeStatusRepository extends MongoRepository<ChangeStatus, String>{
	
	Iterable<ChangeStatus> findByTicketIdOrderByDateChangeStatusDesc(String ticketId);

}
