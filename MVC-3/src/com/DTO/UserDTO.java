package com.DTO;

public class UserDTO {

	private String uname;

	private String uaddress;

	private int age;
	
	

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserDTO [uname=" + uname + ", uaddress=" + uaddress + ", age=" + age + "]";
	}

}
