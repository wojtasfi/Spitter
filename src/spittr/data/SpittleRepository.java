package spittr.data;

import java.util.List;

public interface SpittleRepository {

	List<Spittle> findSpittle(long max, int count);

	Object findOne(long spittleId);

	void addSpittle(String message);

	Object save(User user);

	User findUser(String login);
}
