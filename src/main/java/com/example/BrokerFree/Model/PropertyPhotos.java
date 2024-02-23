package com.example.BrokerFree.Model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "property_photos")
public class PropertyPhotos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "photo1")
    private String photo1;
    
    @Column(name = "photo2")
    private String photo2;

	public PropertyPhotos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PropertyPhotos(Long id, String photo1, String photo2) {
		super();
		this.id = id;
		this.photo1 = photo1;
		this.photo2 = photo2;
	}

	@Override
	public String toString() {
		return "PropertyPhotos [id=" + id + ", photo1=" + photo1 + ", photo2="
				+ photo2 + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhoto1() {
		return photo1;
	}

	public void setPhoto1(String photo1) {
		this.photo1 = photo1;
	}

	public String getPhoto2() {
		return photo2;
	}

	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}

   
    
}
