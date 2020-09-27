package com.finding.app.Service;

import org.springframework.stereotype.Service;

import com.finding.app.Commons.CommonServiceImple;
import com.finding.app.Documents.Favorite;
import com.finding.app.Repository.FavoriteRepository;

@Service
public class FavoriteServiceImple extends CommonServiceImple<Favorite, FavoriteRepository> implements FavoriteService {

}
