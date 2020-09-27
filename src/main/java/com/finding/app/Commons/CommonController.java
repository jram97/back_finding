package com.finding.app.Commons;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.finding.app.Enums.Codes;
import com.finding.app.Enums.Messages;


public class CommonController<E, S extends CommonService<E>> {

	@Autowired
	protected S service;
	
	@GetMapping
	public ResponseEntity<?> showAll(){
		return ResponseEntity.status(HttpStatus.OK).body(new Response(Codes.OK.getValue(), Messages.SUCCESS.getValue(), service.findAll()));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> details(@PathVariable String id){
		Optional<E> entity = service.findById(id);
		if(!entity.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response(Codes.NOT_FOUND.getValue(), Messages.NOT_FOUND.getValue()));
		}
		return ResponseEntity.status(HttpStatus.OK).body(new Response(Codes.OK.getValue(), Messages.SUCCESS.getValue(), Arrays.asList(entity.get())));
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody E entity){
		E entityNew = service.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(new Response(Codes.CREATED.getValue(), Messages.SAVE.getValue(), Arrays.asList(entityNew)));
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteAll(){
		service.deleteAll();
		return ResponseEntity.status(HttpStatus.OK).body(new Response(Codes.OK.getValue(), Messages.DELETE_ALL.getValue()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable String id){
		service.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body(new Response(Codes.OK.getValue(), Messages.DELETE.getValue()));
	}
}