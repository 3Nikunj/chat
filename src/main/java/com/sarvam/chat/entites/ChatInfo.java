package com.sarvam.chat.entites;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="chat_logs")
public class ChatInfo {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	private Date date;
	@Column(name="request")
	private String req;
	@Column(name="response")
	private String res;
	
	public ChatInfo() {}
	public ChatInfo(Long id, String req, String res, Date date) {
		this.id = id;
		this.date = date;
		this.req = req;
		this.res = res;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getReq() {
		return req;
	}
	public void setReq(String req) {
		this.req = req;
	}
	public String getRes() {
		return res;
	}
	public void setRes(String res) {
		this.res = res;
	}
	
	
}
