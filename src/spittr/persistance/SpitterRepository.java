package spittr.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import spittr.entity.Spitter;
import spittr.entity.Spittle;


public interface SpitterRepository extends JpaRepository<Spitter, Long>{

	Spitter findByUsername(String username);

	Spittle findById(Long id);

}
