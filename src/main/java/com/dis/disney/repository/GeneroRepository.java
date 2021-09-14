package com.dis.disney.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dis.disney.dto.interfaces.IGeneroNomDTO;
import com.dis.disney.model.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero,Long> {
	@Query (value ="select g.nombre from genero g, genero_like gl where (gl.pelicula_serie_id = :id and gl.genero_id=g.id)",nativeQuery = true)
	List<IGeneroNomDTO> buscaPorID(@Param("id") long id);
}
