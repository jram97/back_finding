package com.finding.app.Service;

import com.finding.app.Commons.CommonService;
import com.finding.app.Documents.Resumen;

public interface ResumenService extends CommonService<Resumen> {

	public Resumen findByPublicId(String publicId);
	
}
