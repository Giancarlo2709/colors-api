package com.multiplicatalent.colors.api.models.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multiplicatalent.colors.api.models.entity.Color;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long> {
	
	Page<Color> findByStatus(Integer status, Pageable page);
	
	Optional<Color> findByIdAndStatus(Long id, Integer status);
	
	Optional<Color> findByColorAndStatusAndIdNot(String color, Integer status, Long id);
	
	Optional<Color> findByNameAndStatus(String color, Integer status);

}
