package com.devfull.springdata.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.devfull.springdata.api.entity.AlteraStatus;

public interface AlteraStatusRepository extends MongoRepository<AlteraStatus, String>{
	
	Iterable<AlteraStatus> findByTicketIdOrderByDataAlteraStatusDesc(String ticketId);

}
