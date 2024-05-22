package com.cglia.bms.controller;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cglia.bms.model.Book;
import com.cglia.bms.service.BookService;

@Controller(value="bmsController")
public class BMSController {
	
	@Autowired
	private BookService service;
	
	@GetMapping({"/","/home"})
	public String showHome() {
		return "Home";
	}
	@GetMapping("/add")
	public String addBook(HttpServletRequest request) {
		return "AddBook";
	}
	//To-Do     ---double posting problem
	@RequestMapping(path="/save", method=RequestMethod.POST)
	public String saveBook(@ModelAttribute Book book, HttpServletRequest request, RedirectAttributes attrs) {
		System.out.println(book);
		Integer id=service.saveBook(book);
		attrs.addFlashAttribute("bookid", id);
		
		
		if(id>0) {
			attrs.addFlashAttribute("successmsg","Book saved successfully with ID:"+id);
		}else {
			attrs.addFlashAttribute("failuremsg","An error occurred. Please try again...");
		}
		
		return "redirect:/getAll";
	}
	@RequestMapping(path="/getAll", method=RequestMethod.GET)
	public String getAllBook(HttpServletRequest request) {
		List<Book> bookList=service.getAllBooks();
		
		request.setAttribute("bookList", bookList);
		System.out.println(bookList);
		return "ShowAllBook";
	}
	@GetMapping("/getBook")
	public String getBookByID(@RequestParam("id") Integer id, HttpServletRequest request) {
		
		Book book=service.getBookById(id);
		request.setAttribute("book",book);
		return "UpdateBook";
		
	}
	
	@PostMapping("/update")
	public String updateBook(@ModelAttribute Book book, RedirectAttributes attrs) {
		int count=service.updateBook(book);
		attrs.addFlashAttribute("updatecount", count);
		if(count>0) {
			attrs.addFlashAttribute("updated","Book with ID: "+book.getId()+" is updated successfully.");
		}else {
			attrs.addFlashAttribute("notupdated","An error occurred. Please try again...");
		}
		return "redirect:/getAll";
		
	}
	
	@PostMapping("/delete")
	public String deleteBook(HttpServletRequest request, RedirectAttributes attrs) {
		Integer id=null;
		int count=0;
		if(Objects.nonNull(request.getParameter("idtodelete"))) {
			id=Integer.parseInt(request.getParameter("idtodelete"));
		}
		if(Objects.nonNull(id)) {
			count=service.deleteBookById(id);
			attrs.addFlashAttribute("deletecount", count);
		}
		
		if(count>0) {
			attrs.addFlashAttribute("deleted","Book with ID: "+id+" is deleted successfully.");
		}else {
			attrs.addFlashAttribute("notdeleted","An error occurred. Please try again...");
		}
		return "redirect:/getAll";
		
	}
	
}
