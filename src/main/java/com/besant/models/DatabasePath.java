package com.besant.models;

public class DatabasePath {
private String url;
private String username;
private String pwd;
public DatabasePath(String url, String username, String pwd) {
	super();
	this.url = url;
	this.username = username;
	this.pwd = pwd;
}
public DatabasePath() {
	super();
	// TODO Auto-generated constructor stub
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
@Override
public String toString() {
	return "DatabasePath [url=" + url + ", username=" + username + ", pwd=" + pwd + "]";
}



}
