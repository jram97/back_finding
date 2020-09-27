package com.finding.app.Service;

import org.springframework.stereotype.Service;

import com.finding.app.Commons.CommonServiceImple;
import com.finding.app.Documents.Countries;
import com.finding.app.Repository.CountriesRepository;

@Service
public class CountriesServiceImple extends CommonServiceImple<Countries, CountriesRepository> implements CountriesService {

}
