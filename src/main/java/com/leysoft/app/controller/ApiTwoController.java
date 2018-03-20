package com.leysoft.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.leysoft.app.assembler.SaludoResourceAssembler;
import com.leysoft.app.entity.Saludo;
import com.leysoft.app.exception.NotFoundException;
import com.leysoft.app.resource.SaludoResource;
import com.leysoft.app.service.inter.SaludoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@RestController
public class ApiTwoController {
	
	@Autowired
	private SaludoService saludoService;
	
	@Autowired
	private SaludoResourceAssembler assembler;
	
	@GetMapping(value = {"/saludo"})
	@ApiOperation(value = "get-saludos", nickname = "get-saludos")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Failure")})
	public ResponseEntity<List<SaludoResource>> all() {
		List<Saludo> saludos = saludoService.findAll();
		List<SaludoResource> resurces = assembler.toResources(saludos);
		return new ResponseEntity<List<SaludoResource>>(resurces, HttpStatus.OK);
	}
	
	@GetMapping(value = {"/saludo/{id}"})
	@ApiOperation(value = "get-saludo", nickname = "get-saludo")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure")})
	public ResponseEntity<SaludoResource> get(@PathVariable("id") Long id) {
		Saludo saludo = saludoService.findById(id);
		if(saludo == null) {
			throw new NotFoundException("Not found id: " + id);
		}
		return new ResponseEntity<SaludoResource>(assembler.toResource(saludo), HttpStatus.OK);
	}
}
