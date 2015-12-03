package org.itc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_details")
public class UserDetails{
	private int id;
	private int userId;
	private String fullName;
	private String fatherName;
	private String gender;
	private String nationality;
	private String contactNumber;
	private String address;
	private Status status;
	private Date dateofbirth;
	private ServiceType serviceType;
	private Date subDate;
	private String comment;
	
	
	public UserDetails() {
	}

	
	
	public UserDetails(int id, int userId, String fullName, String fatherName,
			String gender, String nationality, String contactNumber,
			String address, Status status, int serviceId, Date dateofbirth, ServiceType serviceType, Date subDate, String comment) {
		super();
		this.id = id;
		this.userId = userId;
		this.fullName = fullName;
		this.fatherName = fatherName;
		this.gender = gender;
		this.nationality = nationality;
		this.contactNumber = contactNumber;
		this.address = address;
		this.status = status;
		this.dateofbirth = dateofbirth;
		this.serviceType = serviceType;
		this.subDate = subDate;
		this.comment = comment;
	}
	
	
	@Id
	@Column(name ="id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id =id;
	}
	
	@Column(name ="userId")
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
	@Column(name = "fullName")
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	@Column(name = "FatherName")
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	
	@Column(name = "gender")
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Column(name = "nationality")
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	@Column(name = "contactNumber")
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	@Column(name = "address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "serviceId")
	public ServiceType getServiceType() {
		return serviceType;
	}
	
	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "statusId")
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	@Column(name = "dateofbirth")
	public Date getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	@Column(name ="subDate")
	public Date getSubDate() {
		return subDate;
	}


	public void setSubDate(Date subDate) {
		this.subDate = subDate;
	}


	@Column(name ="comment")
	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
	
	
	
	
}
