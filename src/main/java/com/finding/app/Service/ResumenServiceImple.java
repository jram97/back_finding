package com.finding.app.Service;

import org.springframework.stereotype.Service;

import com.finding.app.Commons.CommonServiceImple;
import com.finding.app.Documents.Resumen;
import com.finding.app.Repository.ResumenRepository;

@Service
public class ResumenServiceImple extends CommonServiceImple<Resumen, ResumenRepository> implements ResumenService {

	@Override
	public Resumen findByPublicId(String publicId) {
		return repository.findByPublicId(publicId);
	}
}
