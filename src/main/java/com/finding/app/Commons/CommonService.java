package com.finding.app.Commons;

import java.util.List;
import java.util.Optional;

public interface CommonService<E> {

	public List<E> findAll();
	
	public Optional<E> findById(String id);
	
	public E save(E entity);
	
	public void deleteById(String id);
	
	public void deleteAll();
	
}
