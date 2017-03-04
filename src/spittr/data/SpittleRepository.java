package spittr.data;

import java.util.List;

public interface SpittleRepository {

	List<Spittle> findSpittles();

	Object findOne(long spittleId);


	Object save(User user);

	User findUser(String login);

	void addSpittle(Spittle spittle);
}
