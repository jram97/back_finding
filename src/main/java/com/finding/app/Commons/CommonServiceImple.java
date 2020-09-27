package com.finding.app.Commons;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

public class CommonServiceImple<E, R extends MongoRepository<E, String>> implements CommonService<E> {

	@Autowired
	protected R repository;
	
	@Override
	public List<E> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<E> findById(String id) {
		return repository.findById(id);
	}

	@Override
	public E save(E entity) {
		return repository.save(entity);
	}

	@Override
	public void deleteById(String id) {
		repository.deleteById(id);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

}
