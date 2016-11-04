package com.newsmon.dto;

// login data-transfer-object
public class LoginDTO {

	private String email;
	private String pw;
	private boolean useCookie;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public boolean isUseCookie() {
		return useCookie;
	}

	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}

	@Override
	public String toString() {
		return "LoginDTO [email=" + email + ", pw=" + pw + ", useCookie=" + useCookie + "]";
	}

}
