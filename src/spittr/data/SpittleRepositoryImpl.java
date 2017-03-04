package spittr.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class SpittleRepositoryImpl implements SpittleRepository {

	private List<Spittle> spittleList;
	private List<User> userList;

	public SpittleRepositoryImpl() {
		spittleList = new ArrayList<Spittle>();
		userList = new ArrayList<User>();
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

	@Override
	public Object save(User user) {
		// TODO Auto-generated method stub

		return userList.add(user);
	}

	@Override
	public User findUser(String login) {
		// TODO Auto-generated method stub
		for(int i =0; i< userList.size(); i++){
			User user = userList.get(i);
			if(user.getLogin().equals(login)){
				return user;
			}
		}
		
		return null;
	}

}
