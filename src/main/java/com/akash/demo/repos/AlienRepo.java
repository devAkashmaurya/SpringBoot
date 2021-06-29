package com.akash.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.akash.demo.model.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer>{

	List<Alien> findByAname(String aname);
	List<Alien> findByAidGreaterThan(int aid);
	
	@Query("from Alien where aname=?1 order by aname")
	List<Alien> findByAnameSorted(String aname);
}
