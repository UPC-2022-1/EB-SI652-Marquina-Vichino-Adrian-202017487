package com.si652ebu202017487.art.magnet.partner.u202017487.painting.idea.resource;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateIdeasResource {
	@NotNull
	private Integer authorId;
	@NotNull
	@NotBlank
	private String textQuery;
	@NotNull
	private Integer initialSample;
}
