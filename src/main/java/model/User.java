package model;

public class User {
	private String userName, email, password, phone;

	public User(String userName, String email, String password, String phone) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.phone = phone;

	}

	
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setCity(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", email=" + email + ", phone=" + phone + ", password="
				+ password + "]";
	}

}
