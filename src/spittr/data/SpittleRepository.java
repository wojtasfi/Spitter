package spittr.data;

import java.util.List;

public interface SpittleRepository {

	List<Spittle> findSpittles();

	Object findOne(long spittleId);

	void addSpittle(Spittle spittle);
}
