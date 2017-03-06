package spittr.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class SpitterRepositoryImpl implements SpitterRepository {
	private List<Spitter> spitterList;

	public SpitterRepositoryImpl() {
		spitterList = new ArrayList<Spitter>();
		
		Spitter spitter = new Spitter("pol", "lop", "user", "password", "p@a.pl");
		spitterList.add(spitter);
		System.out.println(spitter);
	}

	@Override
	public Object save(Spitter spitter) {

		return spitterList.add(spitter);
	}

	@Override
	public Spitter findByUsername(String username) {
		
		System.out.println("inside");
		for (int i = 0; i < spitterList.size(); i++) {
			
			Spitter spitter = spitterList.get(i);
			System.out.println(spitter);
			if (spitter.getLogin().equals(username)) {
				return spitter;
			}
		}

		return null;
	}
}
