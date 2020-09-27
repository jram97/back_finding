package com.finding.app.Service;

import org.springframework.stereotype.Service;

import com.finding.app.Commons.CommonServiceImple;
import com.finding.app.Documents.Role;
import com.finding.app.Repository.RoleRepository;

@Service
public class RolesServiceImple extends CommonServiceImple<Role, RoleRepository> implements RolesService {

}
