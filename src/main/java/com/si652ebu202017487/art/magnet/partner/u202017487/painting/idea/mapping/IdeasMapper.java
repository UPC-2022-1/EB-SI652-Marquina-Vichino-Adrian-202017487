package com.si652ebu202017487.art.magnet.partner.u202017487.painting.idea.mapping;

import com.si652ebu202017487.art.magnet.partner.u202017487.painting.idea.resource.CreateIdeasResource;
import com.si652ebu202017487.art.magnet.partner.u202017487.painting.idea.resource.IdeasResource;
import com.si652ebu202017487.art.magnet.partner.u202017487.painting.idea.domain.model.entity.IdeasEntity;
import com.si652ebu202017487.art.magnet.partner.u202017487.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class IdeasMapper implements Serializable {

	@Autowired
	EnhancedModelMapper mapper;

	// Object Mapping
	public IdeasResource toResource(IdeasEntity model) {
		return mapper.map(model, IdeasResource.class);
	}

	public Page<IdeasResource> modelListPage(List<IdeasEntity> modelList, Pageable pageable) {
		return new PageImpl<>(mapper.mapList(modelList, IdeasResource.class), pageable, modelList.size());
	}

	public IdeasEntity toModel(CreateIdeasResource resource) {
		return mapper.map(resource, IdeasEntity.class);
	}

}
