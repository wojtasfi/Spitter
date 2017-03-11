package spittr.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import spittr.data.Spittle;

public interface SpittleRepository extends JpaRepository<Spittle, Long> {

}
