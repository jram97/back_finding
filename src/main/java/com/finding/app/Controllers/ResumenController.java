package com.finding.app.Controllers;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.finding.app.Commons.CommonController;
import com.finding.app.Commons.Response;
import com.finding.app.Config.Functions;
import com.finding.app.Config.JwtUtils;
import com.finding.app.Documents.Resumen;
import com.finding.app.Documents.Users;
import com.finding.app.Documents.DTO.PublicIdDTO;
import com.finding.app.Enums.Codes;
import com.finding.app.Enums.Messages;
import com.finding.app.Service.ResumenService;
import com.finding.app.Service.UsersService;

@PreAuthorize("hasRole('USER') or hasRole('ENTERPRISE') or hasRole('ADMIN')")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/resumen")
public class ResumenController extends CommonController<Resumen, ResumenService> {

	@Autowired
	private UsersService usersService;

	@Autowired
	private JwtUtils jwtProvider;

	@SuppressWarnings("rawtypes")
	@PostMapping("/upload")
	public ResponseEntity<?> addCV(@RequestPart(value = "cv") MultipartFile cv,
			@RequestHeader("Authorization") String token) {

		Resumen newResumen = new Resumen();
		Map uploadCv = Functions.upload(cv);
		newResumen.setNameCv(uploadCv.get("secure_url").toString());
		newResumen.setPublicId(uploadCv.get("public_id").toString());

		String alias = jwtProvider.getUserNameFromJwtToken(token.split(" ")[1]);
		Optional<Users> user = usersService.findByUsername(alias);
		newResumen.setUser(user.get());

		service.save(newResumen);
		return ResponseEntity.status(HttpStatus.CREATED).body(new Response(Codes.CREATED.getValue(), Messages.SAVE.getValue()));
	}

	@DeleteMapping("/upload/delete")
	public ResponseEntity<?> deleteCV(@RequestBody PublicIdDTO publicId) {
		Resumen resumen = service.findByPublicId(publicId.getPublicId());
		Functions.delete(resumen.getPublicId());

		service.deleteById(resumen.getId());

		return ResponseEntity.status(HttpStatus.OK).body(new Response(Codes.OK.getValue(), Messages.DELETE.getValue()));
	}
}
