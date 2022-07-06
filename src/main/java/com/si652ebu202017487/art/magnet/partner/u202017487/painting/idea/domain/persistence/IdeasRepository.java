package com.si652ebu202017487.art.magnet.partner.u202017487.painting.idea.domain.persistence;

import java.util.List;

import com.si652ebu202017487.art.magnet.partner.u202017487.painting.idea.domain.model.entity.IdeasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeasRepository extends JpaRepository<IdeasEntity, Long> {
	List<IdeasEntity> findAll();
	List<IdeasEntity> findByAuthorId(Long authorId);
	List<IdeasEntity> findByTextQuery(String textQuery);
}