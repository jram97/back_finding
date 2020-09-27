package com.finding.app.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finding.app.Commons.CommonController;
import com.finding.app.Documents.Role;
import com.finding.app.Service.RolesService;

//@PreAuthorize("hasRole('USER') or hasRole('ENTERPRISE') or hasRole('ADMIN')")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/roles")
public class RolesController extends CommonController<Role, RolesService> {

}