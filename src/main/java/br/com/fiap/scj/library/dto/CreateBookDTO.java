package br.com.fiap.scj.library.dto;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateBookDTO {

	private String title;

	private Integer pages;

	private String isbn;

	@JsonProperty("release_date")
	private ZonedDateTime releaseDate;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public ZonedDateTime getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(ZonedDateTime releaseDate) {
		this.releaseDate = releaseDate;
	}
	
}
