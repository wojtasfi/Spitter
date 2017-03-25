package spittr.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Email;
import org.springframework.web.multipart.MultipartFile;

//Not used for now
public class UserForm {

	private Long id;

	private MultipartFile profilePicture;

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
	private String username;

	@NotNull
	@Email(message = "{email.size}")
	private String email;

	public UserForm(long id, String firstName, String lastName, String username, String password, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.id = id;
		this.email = email;
	}

	public UserForm(String firstName, String lastName, String username, String password, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public UserForm() {
	};

	public MultipartFile getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(MultipartFile profilePicture) {
		this.profilePicture = profilePicture;
	}
	
	public Spitter toSpitter() {
		Spitter spitter = new Spitter();
		spitter.setEmail(email);
		spitter.setFirstName(firstName);
		spitter.setLastName(lastName);
		spitter.setPassword(password);
		spitter.setUsername(username);
		return spitter;
	}


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
		return username;
	}

	public void setLogin(String login) {
		this.username = login;
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

	@Override
	public boolean equals(Object that) {
		return EqualsBuilder.reflectionEquals(this, that, "firstName", "lastName", "login", "password", "email");
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "firstName", "lastName", "login", "password", "email");
	}

}
