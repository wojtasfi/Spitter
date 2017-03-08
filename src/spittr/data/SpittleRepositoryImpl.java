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

		return spittleList;
	}

	@Override
	public Object findOne(long spittleId) {
		Spittle spittle = spittleList.get((int) spittleId);

		return spittle;
	}

	@Override
	public void addSpittle(Spittle spittle) {
	
		spittleList.add(spittle);
	}

	

}
