package com.example.demo.entity;

import java.sql.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "submissions")
public class Submission {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;
	    private String email;
	    private String ipAddress;
	    private String city;
	    private String state;
	    private String country;
	    private String latitude;
	    private String longitude;
	    
	    @Column(columnDefinition = "TEXT")
	    private String systemInfo;

	    @Column(columnDefinition = "TEXT")
	    private String browserInfo;

	    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getIpAddress() {
			return ipAddress;
		}

		public void setIpAddress(String ipAddress) {
			this.ipAddress = ipAddress;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getLatitude() {
			return latitude;
		}

		public void setLatitude(String latitude) {
			this.latitude = latitude;
		}

		public String getLongitude() {
			return longitude;
		}

		public void setLongitude(String longitude) {
			this.longitude = longitude;
		}

		public String getSystemInfo() {
			return systemInfo;
		}

		public void setSystemInfo(String systemInfo) {
			this.systemInfo = systemInfo;
		}

		public String getBrowserInfo() {
			return browserInfo;
		}

		public void setBrowserInfo(String browserInfo) {
			this.browserInfo = browserInfo;
		}

		public Timestamp getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Timestamp createdAt) {
			this.createdAt = createdAt;
		}

		public Submission(Long id, String name, String email, String ipAddress, String city, String state,
				String country, String latitude, String longitude, String systemInfo, String browserInfo,
				Timestamp createdAt) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.ipAddress = ipAddress;
			this.city = city;
			this.state = state;
			this.country = country;
			this.latitude = latitude;
			this.longitude = longitude;
			this.systemInfo = systemInfo;
			this.browserInfo = browserInfo;
			this.createdAt = createdAt;
		}

		public Submission() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
}
