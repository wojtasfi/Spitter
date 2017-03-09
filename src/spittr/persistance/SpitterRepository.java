package spittr.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spittr.data.Spitter;

@Repository
public interface SpitterRepository extends JpaRepository<Spitter, Long>{

	Spitter findByUsername(String username);


}
