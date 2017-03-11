package spittr.data;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Spittle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long spittleId;

	@NotNull
	private String message;

	@DateTimeFormat
	@NotNull
	private Date time;

	@NotNull
	private Double longitude;

	@NotNull
	private Double latitude;

	@ManyToOne
	@JoinColumn(name = "spitter_id", insertable = false, updatable = false)
	private Spitter spitter;

	private String spitterUsername;

	public Spittle() {
	}

	public Spitter getSpitter() {
		return spitter;
	}

	public void setSpitter(Spitter spitter) {
		this.spitter = spitter;
	}

	public String getMessage() {
		return message;
	}

	public String getTime() {
		return new SimpleDateFormat("MM-dd-yyyy").format(time);
	}

	public Double getLongitude() {
		return longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Long getSpittleId() {
		return spittleId;
	}

	public void setSpittleId(Long spittleId) {
		this.spittleId = spittleId;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public String getSpitterUsername() {
		return spitterUsername;
	}

	public void setSpitterUsername(String spitterUsername) {
		this.spitterUsername = spitterUsername;
	}
}
