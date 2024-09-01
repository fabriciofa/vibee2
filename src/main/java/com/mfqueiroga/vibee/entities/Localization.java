package com.mfqueiroga.vibee.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_localization")
public class Localization implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(precision = 9, scale = 6)
	private BigDecimal latitude;

	@Column(precision = 9, scale = 6)
	private BigDecimal longitude;

	@OneToMany(mappedBy = "local")
	private Set<Beehive> beehives = new HashSet<>();

	public Localization() {

	}

	public Localization(Long id, BigDecimal latitude, BigDecimal longitude) {
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public Set<Beehive> getBeehives() {
		return beehives;
	}

	/*
	 * public void setBeehives(Set<Beehive> beehives) { this.beehives = beehives; }
	 */

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
		Localization other = (Localization) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Localization [id=" + id + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}

}
