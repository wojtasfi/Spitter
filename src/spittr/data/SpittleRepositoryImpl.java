package spittr.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class SpittleRepositoryImpl implements SpittleRepository {

	private List<Spittle> spittleList;
	

	public SpittleRepositoryImpl() {
		spittleList = new ArrayList<Spittle>();
		
	}

	@Override
	public List<Spittle> findSpittles() {

		/*
		 * spittleList.add(new Spittle("Hello", new Date()));
		 * spittleList.add(new Spittle("Raz dwa trzy...", new Date()));
		 * spittleList.add(new Spittle("News", new Date())); spittleList.add(new
		 * Spittle("Facts", new Date()));
		 */

		return spittleList;
	}

	@Override
	public Object findOne(long spittleId) {
		// TODO Auto-generated method stub
		Spittle spittle = spittleList.get((int) spittleId);
		

		return spittle;
	}

	@Override
	public void addSpittle(Spittle spittle) {
		// TODO Auto-generated method stub

		
		spittleList.add(spittle);
	}

	

}
