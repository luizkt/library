package br.com.fiap.scj.library.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;

public class BookDTO {

	private Integer id;

	private String title;

	private Integer pages;

	private String isbn;

	@JsonProperty("release_date")
	private ZonedDateTime releaseDate;

	private WriterDTO writer;

	public BookDTO() {
	}

	public BookDTO(Integer id, String title, Integer pages, String isbn, ZonedDateTime releaseDate, WriterDTO writer) {
		super();
		this.id = id;
		this.title = title;
		this.pages = pages;
		this.isbn = isbn;
		this.releaseDate = releaseDate;
		this.writer = writer;
	}

	public BookDTO(CreateBookDTO createBookDTO, Integer id) {
		this.id = id;
		this.title = createBookDTO.getTitle();
		this.pages = createBookDTO.getPages();
		this.isbn = createBookDTO.getIsbn();
		this.releaseDate = createBookDTO.getReleaseDate();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public WriterDTO getWriter() {
		return writer;
	}

	public void setWriter(WriterDTO writer) {
		this.writer = writer;
	}

}
