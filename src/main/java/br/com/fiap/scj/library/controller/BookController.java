package br.com.fiap.scj.library.controller;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.scj.library.dto.BookDTO;
import br.com.fiap.scj.library.dto.CreateBookDTO;
import br.com.fiap.scj.library.dto.WriterDTO;

@RestController
@RequestMapping("books")
public class BookController {

	List<BookDTO> bookDTOList = new ArrayList<>();

	public BookController() {
		bookDTOList.add(new BookDTO(1, "Senhor dos aneis", 200, "123645", ZonedDateTime.now().minusYears(40),
				new WriterDTO("Tolkien", 1)));

		bookDTOList.add(new BookDTO(2, "O Hobbit", 200, "123645", ZonedDateTime.now().minusYears(40),
				new WriterDTO("Tolkien", 1)));

		bookDTOList.add(new BookDTO(3, "Silmarilion", 200, "123645", ZonedDateTime.now().minusYears(40),
				new WriterDTO("Tolkien", 1)));
	}

	@GetMapping
	public List<BookDTO> getAll(@RequestParam(required = false) String title) {

		List<BookDTO> bookDTOList = this.bookDTOList;

		return bookDTOList.stream()
				.filter(bookDTO -> title == null || bookDTO.getTitle().toLowerCase().startsWith(title.toLowerCase()))
				.collect(Collectors.toList());
	}

	@GetMapping("{id}")
	public BookDTO findById(@PathVariable Integer id) {

		List<BookDTO> bookDTOList = this.bookDTOList;

		return bookDTOList.stream().filter(bookDTO -> bookDTO.getId().equals(id)).findFirst()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public BookDTO create(@RequestBody CreateBookDTO createBookDTO) {

		BookDTO bookDTO = new BookDTO(createBookDTO, bookDTOList.size() + 1);

		bookDTOList.add(bookDTO);

		return bookDTO;
	}

	@PutMapping("{id}")
	public BookDTO update(@PathVariable Integer id, @RequestBody CreateBookDTO createBookDTO) {

		BookDTO bookDTO = findById(id);

		bookDTO.setIsbn(createBookDTO.getIsbn());
		bookDTO.setPages(createBookDTO.getPages());
		bookDTO.setReleaseDate(createBookDTO.getReleaseDate());
		bookDTO.setTitle(createBookDTO.getTitle());

		return bookDTO;
	}

	@PatchMapping("{id}")
	public BookDTO update(@PathVariable Integer id, @RequestBody WriterDTO writerDTO) {

		BookDTO bookDTO = findById(id);

		bookDTO.setWriter(writerDTO);

		return bookDTO;
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Integer id) {

		BookDTO bookDTO = findById(id);
		bookDTOList.remove(bookDTO);
	}

}
