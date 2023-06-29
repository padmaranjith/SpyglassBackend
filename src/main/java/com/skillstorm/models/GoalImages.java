package com.skillstorm.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="images")
public class GoalImages {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="image_id")
	private int imageId;
	
	@Column(name="image_name")
	private String imageName;
	
	@Column(name="imageurl")
	private String imageUrl;
	
	public GoalImages() {
	}
	
	

	public GoalImages(int imageId, String imageName, String imageUrl) {
		super();
		this.imageId = imageId;
		this.imageName = imageName;
		this.imageUrl = imageUrl;
	}



	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	

	public String getImageName() {
		return imageName;
	}



	public void setImageName(String imageName) {
		this.imageName = imageName;
	}



	@Override
	public int hashCode() {
		return Objects.hash(imageId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GoalImages other = (GoalImages) obj;
		return imageId == other.imageId;
	}
	
}
