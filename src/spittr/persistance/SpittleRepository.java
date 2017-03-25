package spittr.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import spittr.entity.Spittle;

public interface SpittleRepository extends JpaRepository<Spittle, Long> {

}
