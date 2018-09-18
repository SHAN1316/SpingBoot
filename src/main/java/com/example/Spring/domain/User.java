package com.example.Spring.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false, unique = true)
	private String userName;
	@Column(nullable = false)
	private String passWord;
	//unique = true是指这个字段的值在这张表里不能重复，所有记录值都要唯一，就像主键那样
	//nullable=false是这个字段在保存时必需有值，不能还是null值就调用save去保存入库
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false, unique = true)
	private String nickName;
	@Column(nullable = false)
	private String regTime;
    public  User() {
    	 super();
     }
     
	public User(Long id,String email, String nickName, String passWord, String userName, String regTime) {
		super();
		this.id = id;
		this.email = email;
		this.nickName = nickName;
		this.passWord = passWord;
		this.userName = userName;
		this.regTime = regTime;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
