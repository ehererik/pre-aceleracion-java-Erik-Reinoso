package com.dis.disney.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dis.disney.dto.interfaces.IPersonajeDTO;
import com.dis.disney.dto.interfaces.IPesonajeNomImgDTO;
import com.dis.disney.model.Personaje;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Long> {
	
	@Query(value="select p.nombre, p.edad, p.imagen, p.peso, p.historia from personaje p , peli_serie_like psl where ( p.id=psl.personaje_id and psl.pelicula_serie_id=:id)",nativeQuery = true)
	public List<IPersonajeDTO> findAllByPeliculaSerieId(@Param("id")long id);
	
	@Query(value="select p.nombre, p.imagen from personaje p", nativeQuery = true)
	public List<IPesonajeNomImgDTO> listAll();
	
	@Query(value="select p.nombre, p.imagen from personaje p where p.nombre like %:name%", nativeQuery = true)
	public List<IPesonajeNomImgDTO> listAllContainsName(@Param ("name")String name);
	
	@Query(value="select p.nombre, p.imagen from personaje p where p.edad = :age", nativeQuery = true)
	public List<IPesonajeNomImgDTO> listAllByAge(@Param ("age")int age);
	
	@Query(value="select p.nombre, p.imagen from personaje p, peli_serie_like psl where (p.id=psl.personaje_id and psl.pelicula_serie_id=:movies)",nativeQuery = true)
	public List<IPesonajeNomImgDTO> listAllByMovie(@Param ("movies")long id);
	
	@Query(value="select p.nombre, p.imagen, p.edad, p.peso, p.historia from personaje p where p.id=:id", nativeQuery = true)
	public IPersonajeDTO findIPersonajeByID(@Param ("id") long id);
}
