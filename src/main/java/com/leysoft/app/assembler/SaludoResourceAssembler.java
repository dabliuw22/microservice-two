package com.leysoft.app.assembler;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.leysoft.app.controller.ApiTwoController;
import com.leysoft.app.entity.Saludo;
import com.leysoft.app.resource.SaludoResource;

@Component
public class SaludoResourceAssembler extends ResourceAssemblerSupport<Saludo, SaludoResource> {

	public SaludoResourceAssembler() {
		super(ApiTwoController.class, SaludoResource.class);
	}

	@Override
	public SaludoResource toResource(Saludo entity) {
		SaludoResource resource = new SaludoResource(entity);
		ControllerLinkBuilder linkAll = linkTo(methodOn(ApiTwoController.class).all());
		resource.add(linkAll.withRel("all"));
		return resource;
	}

	@Override
	public List<SaludoResource> toResources(Iterable<? extends Saludo> entities) {
		List<SaludoResource> resources = new ArrayList<>();
		entities.forEach(saludo -> {
			SaludoResource resource = new SaludoResource(saludo);
			ControllerLinkBuilder linkSelf = linkTo(methodOn(ApiTwoController.class).get(saludo.getId()));
			resource.add(linkSelf.withSelfRel());
			resources.add(resource);
		});
		return resources;
	}
}