package com.mfqueiroga.vibee.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.mfqueiroga.vibee.entities.enums.Diseases;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_notification")
public class Notification implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "local_id")
	private Localization local;
	
	private Instant date;
	private Integer disease;
	private Boolean active = true;
	
	public Notification() {
		
	}

	public Notification(Long id, User user, Localization local, Instant date, Diseases disease, Boolean active) {
		this.id = id;
		this.user = user;
		this.local = local;
		this.date = date;
		setDisease(disease);
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Localization getLocal() {
		return local;
	}

	public void setLocal(Localization local) {
		this.local = local;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public Diseases getDisease() {
		return Diseases.valueOf(disease);
	}

	public void setDisease(Diseases disease) {
		if(disease != null) {
			this.disease = disease.getCode();
		}
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notification other = (Notification) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Notification [id=" + id + ", user=" + user + ", local=" + local + ", date=" + date + ", disease="
				+ disease + ", active=" + active + "]";
	}
	
	
}
