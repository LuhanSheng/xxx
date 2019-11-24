/**
 * 2015-2016 龙果学院 (www.roncoo.com)
 */
package com.company;

/**
 * 实体类
 * 
 * @author wujing
 */
/*public class User {
	private int id;
	private String name;
	private Date date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}*/

public class User {
	private String username;
	private String password;
	private String studentName;
	private String subject;
	public User(String username, String password, String studentName, String subject){
		this.username=username;
		this.password=password;
		this.studentName=studentName;
		this.subject=subject;
	}


	public void setUserName(String username){
		this.username=username;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getUserName(){
		return username;
	}
	public String getPassword(){
		return password;
	}
	public String getStudentName() {
		return studentName;
	}
	public String getSubject() {
		return subject;
	}
}
