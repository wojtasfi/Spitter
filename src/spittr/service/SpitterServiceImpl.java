package spittr.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import spittr.entity.Spitter;
import spittr.entity.Spittle;
import spittr.persistance.SpitterRepository;
import spittr.persistance.SpittleRepository;

@Service
public class SpitterServiceImpl implements SpitterService {

	@Autowired
	private SpitterRepository spitterRepository;

	@Autowired
	private SpittleRepository spittleRepository;

	@Override
	@CachePut("spitterCache")
	public void saveSpitter(Spitter spitter) {

		spitterRepository.save(spitter);
	}

	@Cacheable("spitterCache")
	public Spitter findByUsername(String username) {
		// TODO Auto-generated method stub
		return spitterRepository.findByUsername(username);
	}

	@Override
	public Spittle findSpitterById(long id) {
		// TODO Auto-generated method stub
		return spitterRepository.findById(id);
	}

	@Override
	public Spittle saveSpittle(Spittle spittle) {
		return spittleRepository.save(spittle);

	}

	@Override
	public Spittle findSpittleById(long spittleId) {
		// TODO Auto-generated method stub
		return spittleRepository.findOne(spittleId);
	}

	@Override
	public List<Spittle> findAllSpittles() {

		return spittleRepository.findAll();
	}

	@Override
	public Set<Spittle> findSpitterSpittles(Long spitterId) {

		Spitter spitter = spitterRepository.findOne(spitterId);
		return spitter.getSpittles();
	}

}
