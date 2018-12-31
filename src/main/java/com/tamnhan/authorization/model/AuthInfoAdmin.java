package com.tamnhan.authorization.model;

public class AuthInfoAdmin {

	private String token;
	private AdminTamNhan adminTamNhan;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public AdminTamNhan getAdminTamNhan() {
		return adminTamNhan;
	}

	public void setAdminTamNhan(AdminTamNhan adminTamNhan) {
		this.adminTamNhan = adminTamNhan;
	}

}
