package com.si652ebu202017487.art.magnet.partner.u202017487.painting.idea.domain.model.entity;

import lombok.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import javax.persistence.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ideas")
public class IdeasEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private Long authorId;

	@NotNull
	@NotBlank
	private String textQuery;

	@NotNull
	private Integer initialSample;
}
