package spittr.entity;

import org.springframework.web.multipart.MultipartFile;

public class SpittleForm {

	private Double longitude;
	private Double latitude;
	private String message;
	private MultipartFile spittlePicture;

	public SpittleForm() {

	}

	public SpittleForm(String message, Double latitude, Double longitude) {
		this.setMessage(message);
		this.latitude = latitude;
		this.longitude = longitude;

	}

	public Double getLongitude() {
		return longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public MultipartFile getSpittlePicture() {
		return spittlePicture;
	}

	public void setSpittlePicture(MultipartFile spittlePicture) {
		this.spittlePicture = spittlePicture;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
