package spittr.service;

import java.util.List;
import java.util.Set;

import spittr.entity.Spitter;
import spittr.entity.Spittle;


public interface SpitterService {

	void saveSpitter(Spitter spitter);

	Spitter findByUsername(String username);

	Spittle saveSpittle(Spittle spittle);

	Spittle findSpittleById(long spittleId);

	List<Spittle> findAllSpittles();

	Spittle findSpitterById(long id);

	Set<Spittle> findSpitterSpittles(Long spitterId);


}
