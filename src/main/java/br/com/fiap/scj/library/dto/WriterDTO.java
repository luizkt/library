package br.com.fiap.scj.library.dto;

public class WriterDTO {

	private String name;

	private Integer id;

	public WriterDTO() {
	}

	public WriterDTO(String name, Integer id) {
		super();
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
