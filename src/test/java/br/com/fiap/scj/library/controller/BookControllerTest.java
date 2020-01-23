package br.com.fiap.scj.library.controller;

import org.junit.Test;
import org.springframework.util.Assert;

public class BookControllerTest {

	@Test
	public void getAllTest() {
		
		BookController bookController = new BookController();
		
		Assert.notEmpty(bookController.getAll(null));
	}
	
}
