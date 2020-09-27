package com.finding.app.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finding.app.Commons.CommonController;
import com.finding.app.Documents.Users;
import com.finding.app.Service.UsersService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/users")
public class UsersController extends CommonController<Users, UsersService> {

}
