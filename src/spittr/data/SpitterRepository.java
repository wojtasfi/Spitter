package spittr.data;

public interface SpitterRepository {

	Object save(Spitter user);

	Spitter findByUsername(String login);

}
