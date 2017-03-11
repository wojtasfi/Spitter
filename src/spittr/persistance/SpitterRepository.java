package spittr.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import spittr.data.Spitter;


public interface SpitterRepository extends JpaRepository<Spitter, Long>{

	Spitter findByUsername(String username);


}
