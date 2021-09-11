package com.dis.disney.repository;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dis.disney.dto.IPeliculaSerieDTO;
import com.dis.disney.dto.IPeliculaSerieImgTitFecDTO;
import com.dis.disney.dto.IPeliculaSerieTit;
import com.dis.disney.dto.PeliculaSerieDTO;
import com.dis.disney.model.PeliculaSerie;


@Repository
public interface PeliculaSerieRepository extends JpaRepository<PeliculaSerie, Long> {
	@Query(  value = "select  p.titulo, p.imagen, p.calificacion, p.fecha_creacion from pelicula_serie p, genero g, genero_like gl where (p.id =gl.pelicula_serie_id and gl.genero_id =:gen_id) GROUP by p.id",   nativeQuery = true)
	public List<IPeliculaSerieDTO> peliPorGenero(@Param("gen_id") long gen_id);
	
	@Query(  value = "select ps.titulo, ps.imagen,ps.calificacion, ps.fecha_creacion from pelicula_serie ps where ps.id = :id",   nativeQuery = true)
	public IPeliculaSerieDTO buscaPorID(@Param("id") long id);
	
	@Query(value ="select  p.titulo, p.imagen, p.calificacion, p.fecha_creacion from pelicula_serie p where p.titulo =:titulo",nativeQuery = true)
	public List<IPeliculaSerieDTO> peliPorTitulo(@Param("titulo") String titulo);
	
	@Query(value ="select  p.titulo, p.imagen, p.calificacion, p.fecha_creacion from pelicula_serie p ",nativeQuery = true)
	public List<IPeliculaSerieDTO> listImgTitFech();
	
	@Query(value ="select ps.titulo from pelicula_serie ps,peli_serie_like psl,personaje p where (ps.id =psl.pelicula_serie_id  and psl.personaje_id =:id)GROUP by ps.id",nativeQuery = true)
	public List<IPeliculaSerieTit> findByPersonajeId(@Param("id") long id);
}
