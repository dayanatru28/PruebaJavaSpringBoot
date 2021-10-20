package com.example.demo.interfaces;

import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.modelo.AdminSalones;
@Repository

public interface IAdminSalones extends CrudRepository<AdminSalones, Integer> {
	@Transactional()
	List<AdminSalones> findByIdSalonIdSalonAndFechaAndHora(int idSalon, Date fecha, Date hora);
	List<AdminSalones> findByIdCursoCodigoAndFechaAndHora(String codigo, Date fecha, Date hora);
	List<AdminSalones> findByIdSalonIdSalonAndFechaLessThan(int idSalon, Date Fecha);
	List<AdminSalones> findByIdSalonIdSalonAndFechaGreaterThanEqual(int idSalon, Date Fecha);

}
