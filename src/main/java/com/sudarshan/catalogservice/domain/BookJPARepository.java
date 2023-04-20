package com.sudarshan.catalogservice.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface BookJPARepository extends JpaRepository<BookJPA,Long> {

	Optional<BookJPA> findByIsbn(String isbn);
	boolean existsByIsbn(String isbn);

	@Transactional
	void deleteByIsbn(String isbn);

}
