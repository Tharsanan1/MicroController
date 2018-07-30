package com.example.demo;
import javax.persistence.*;

@Entity
public class ModelMicro {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer time;
	 
	 private String place;
	 
	 private String temperature;
	 
	 private String moisure;
	 
	 private String humidity;

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getMoisure() {
		return moisure;
	}

	public void setMoisure(String moisure) {
		this.moisure = moisure;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	
	 
	 
}
