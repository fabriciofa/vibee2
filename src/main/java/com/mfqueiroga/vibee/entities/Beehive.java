package com.mfqueiroga.vibee.entities;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mfqueiroga.vibee.entities.enums.Bees;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_beehive")
public class Beehive implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer bee;

	@ManyToOne
	@JoinColumn(name = "localization_id", nullable = false)
	private Localization local;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public Beehive() {

	}

	public Beehive(Long id, Bees bee, Localization local, User user) {
		super();
		this.id = id;
		setBee(bee);
		this.local = local;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Bees getBee() {
		return Bees.valueOf(bee);
	}

	public void setBee(Bees bee) {
		if (bee != null) {
			this.bee = bee.getCode();
		}
	}

	public Localization getLocal() {
		return local;
	}

	public void setLocal(Localization local) {
		this.local = local;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		Beehive other = (Beehive) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Beehive [id=" + id + ", bee=" + bee + ", local=" + local + ", user=" + user + "]";
	}

}
