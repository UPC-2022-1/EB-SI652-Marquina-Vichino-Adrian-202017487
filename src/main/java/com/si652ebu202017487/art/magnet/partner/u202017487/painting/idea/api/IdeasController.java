package com.si652ebu202017487.art.magnet.partner.u202017487.painting.idea.api;

import com.si652ebu202017487.art.magnet.partner.u202017487.painting.idea.resource.CreateIdeasResource;
import com.si652ebu202017487.art.magnet.partner.u202017487.painting.idea.resource.IdeasResource;
import com.si652ebu202017487.art.magnet.partner.u202017487.painting.idea.domain.service.IdeasService;
import com.si652ebu202017487.art.magnet.partner.u202017487.painting.idea.mapping.IdeasMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Ideas")
@RestController
@RequestMapping("/api/v1/ideas")
public class IdeasController {
	private final IdeasService ideasService;
	private final IdeasMapper  mapper;

	public IdeasController(IdeasService ideasService, IdeasMapper mapper) {
		this.ideasService = ideasService;
		this.mapper       = mapper;
	}

	@Operation(summary = "Get ideas", description = "Get All ideas entities.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Idea Entities found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = IdeasResource.class))
			})
	})
	@GetMapping
	public Page<IdeasResource> getAllDemoEntities(Pageable pageable) {
		return mapper.modelListPage(ideasService.getAll(), pageable);
	}

	@Operation(summary = "Post ideas", description = "Create an idea entities.")
	@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Details of the Item to be created", required
			= true, content = @Content(schema = @Schema(implementation = CreateIdeasResource.class), mediaType =
			MediaType.APPLICATION_JSON_VALUE, examples = {
			@ExampleObject(name = "An example request.", value = "{\"authorId\":1,\"textQuery\":\"test\",\"initialSample\":1}",
					summary = "An example request.")
	}))
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Idea Entity created", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = IdeasResource.class))
			})
	})
	@PostMapping
	public IdeasResource createDemoEntity(@RequestBody CreateIdeasResource resource) {
		return mapper.toResource(ideasService.create(mapper.toModel(resource)));
	}

}
