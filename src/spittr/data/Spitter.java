package spittr.data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class Spitter {

	private Long id;

	@NotNull
	@Size(min = 5, max = 25, message = "{password.size}")
	private String password;

	@NotNull
	@Size(min = 2, max = 30, message = "{firstName.size}")
	private String firstName;

	@NotNull
	@Size(min = 2, max = 30, message = "{lastName.size}")
	private String lastName;

	@NotNull
	@Size(min = 2, max = 6, message = "{login.size}")
	private String login;

	@NotNull
	@Email(message = "{email.size}")
	private String email;

	public Spitter(long id, String firstName, String lastName, String login, String password, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
		this.id = id;
		this.email = email;
	}

	public Spitter(String firstName, String lastName, String login, String password, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
		this.email = email;
	}

	public Spitter() {
	};

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
/*
	@Override
	public boolean equals(Object that) {
		return EqualsBuilder.reflectionEquals(this, that, "firstName", "lastName", "login", "password", "email");
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "firstName", "lastName", "login", "password", "email");
	}
*/
}
