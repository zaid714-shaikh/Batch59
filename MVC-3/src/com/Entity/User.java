package com.Entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;

	@Column(unique = true, nullable = false)
	private String uname;

	@Column(unique = true)
	private String upassword;

	private String uaddress;

	@CreationTimestamp
	private LocalDateTime registerdDate;

	private int age;

	
	
	public String getUpassword() {
		return upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUaddress() {
		return uaddress;
	}

	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}

	public LocalDateTime getRegisterdDate() {
		return registerdDate;
	}

	public void setRegisterdDate(LocalDateTime registerdDate) {
		this.registerdDate = registerdDate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upassword=" + upassword + ", uaddress=" + uaddress
				+ ", registerdDate=" + registerdDate + ", age=" + age + "]";
	}

}
