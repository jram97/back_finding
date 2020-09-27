package com.finding.app.Service;

import org.springframework.stereotype.Service;

import com.finding.app.Commons.CommonServiceImple;
import com.finding.app.Documents.Jobs;
import com.finding.app.Repository.JobsRepository;

@Service
public class JobsServiceImple extends CommonServiceImple<Jobs, JobsRepository> implements JobsService {

}
