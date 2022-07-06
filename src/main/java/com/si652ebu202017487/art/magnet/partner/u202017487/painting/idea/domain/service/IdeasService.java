package com.si652ebu202017487.art.magnet.partner.u202017487.painting.idea.domain.service;

import com.si652ebu202017487.art.magnet.partner.u202017487.painting.idea.domain.model.entity.IdeasEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IdeasService {
	List<IdeasEntity> getAll();
	Page<IdeasEntity> getAll(Pageable pageable);
	IdeasEntity create(IdeasEntity ideasEntity);
}