package com.si652ebu202017487.art.magnet.partner.u202017487.painting.idea.service;

import com.si652ebu202017487.art.magnet.partner.u202017487.painting.idea.domain.persistence.IdeasRepository;
import com.si652ebu202017487.art.magnet.partner.u202017487.painting.idea.domain.service.IdeasService;
import com.si652ebu202017487.art.magnet.partner.u202017487.painting.idea.domain.model.entity.IdeasEntity;
import com.si652ebu202017487.art.magnet.partner.u202017487.shared.exeption.ResourceNotFoundException;
import com.si652ebu202017487.art.magnet.partner.u202017487.shared.exeption.ResourceValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class IdeasServiceImpl implements IdeasService {

	private static final String ENTITY = "Ideas";

	private final IdeasRepository ideasRepository;

	private final Validator validator;

	public IdeasServiceImpl(IdeasRepository ideasRepository, Validator validator) {
		this.ideasRepository = ideasRepository;
		this.validator       = validator;
	}

	@Override
	public List<IdeasEntity> getAll() {
		return ideasRepository.findAll();
	}

	@Override
	public Page<IdeasEntity> getAll(Pageable pageable) {
		return ideasRepository.findAll(pageable);
	}

	@Override
	public IdeasEntity create(IdeasEntity ideasEntity) {
		Set<ConstraintViolation<IdeasEntity>> violations = validator.validate(ideasEntity);
		if (!violations.isEmpty()) throw new ResourceValidationException(ENTITY, violations);
		List<IdeasEntity> ideasWithAuthorId  = ideasRepository.findByAuthorId(ideasEntity.getAuthorId());
		List<IdeasEntity> ideasWithTextQuery = ideasRepository.findByTextQuery(ideasEntity.getTextQuery());
		for (IdeasEntity ideaWithAuthorId : ideasWithAuthorId) {
			for (IdeasEntity ideaWithTextQuery : ideasWithTextQuery) {
				if (ideaWithAuthorId != null && ideaWithTextQuery != null && (Objects.equals(ideaWithAuthorId.getId(),
				                                                                             ideaWithTextQuery.getId())))
					throw new ResourceValidationException(ENTITY, "A combination of AuthorId and TextQuery already exists.");
			}
		}
		return ideasRepository.save(ideasEntity);
	}

}