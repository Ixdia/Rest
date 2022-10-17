package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.ItemDao;
import com.model.Item;

@RestController
public class ItemRestController {
	
	@Autowired
	ItemDao itemDao;
	
	@GetMapping("/homeinfo")
	public String gethomeinfo()
	{
		return "Home for your API is Working fine";
	}
	
	@PostMapping("/additem")
	public ResponseEntity addItem(@RequestBody Item item)
	{
		itemDao.save(item);
		return new ResponseEntity("item added success", HttpStatus.OK);
	}
	
	@GetMapping("/getallitems")
	public List<Item> getAllItems()
	{
		return itemDao.findAll();
	}
	
	@PatchMapping("/updateitem")
	public ResponseEntity updateItem(@RequestBody Item item)
	{
		itemDao.save(item);
		return new ResponseEntity("entity updated", HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteitem")
	public ResponseEntity deleteitem(@RequestBody Item item)
	{
		itemDao.delete(item);
		return new ResponseEntity("item deleted", HttpStatus.OK);
	}
	
	@GetMapping("findbyid/{id}")
	public Item getItem(@PathVariable int id)
	{
		Item item = itemDao.getById(id);
		return item;
	}

}
