package com.sathasivam.dvdlibrary.dto;

import java.time.LocalDate;
import java.util.Objects;

public class Dvd {
	
	// DTO's
	private String title;
	private LocalDate releaseDate;
	private String mpaaRating;
	private String directorName;
	private String studio;
	private String userRating;
	
	public Dvd(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getMpaaRating() {
		return mpaaRating;
	}

	public void setMpaaRating(String mpaaRating) {
		this.mpaaRating = mpaaRating;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public String getUserRating() {
		return userRating;
	}

	public void setUserRating(String userRating) {
		this.userRating = userRating;
	}

	@Override
	public String toString() {
		return "Dvd [title=" + title + ", releaseDate=" + releaseDate + ", mpaaRating=" + mpaaRating + ", directorName="
				+ directorName + ", studio=" + studio + ", userRating=" + userRating + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(directorName, mpaaRating, releaseDate, studio, title, userRating);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dvd other = (Dvd) obj;
		return Objects.equals(directorName, other.directorName) && Objects.equals(mpaaRating, other.mpaaRating)
				&& Objects.equals(releaseDate, other.releaseDate) && Objects.equals(studio, other.studio)
				&& Objects.equals(title, other.title) && Objects.equals(userRating, other.userRating);
	}
	
	
	
	

}
