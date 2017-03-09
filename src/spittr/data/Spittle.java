package spittr.data;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Spittle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private final Long spittleId;
	
	@NotNull
	private final String message;
	private final Date time;
	private Double longitude;
	private Double latitude;
	private static long counter=0;

	public Spittle(String message, Date time) {
		this(message, time, null, null);
		
		 
		
	}

	public Spittle(String message, Date time, Double latitude, Double longitude) {
		this.spittleId = counter;
		this.message = message;
		this.time = time;
		this.latitude = latitude;
		this.longitude = longitude;
		counter++;
	

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
}
