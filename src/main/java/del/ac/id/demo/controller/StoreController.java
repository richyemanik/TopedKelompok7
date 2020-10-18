package del.ac.id.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import del.ac.id.demo.jpa.Item;
import del.ac.id.demo.jpa.Store;
import del.ac.id.demo.jpa.StoreRepository;


@RestController
public class StoreController {

	@Autowired StoreRepository storeRepository;
	@Autowired MongoTemplate mongoTemp;
		
	@RequestMapping("/store")
	public ModelAndView store() {
		List<Store> stores = storeRepository.findAll();
		List<Item> items = mongoTemp.findAll(Item.class);
		ModelAndView s = new ModelAndView("store");
		s.addObject("stores", stores);
		s.addObject("items", items);
		s.setViewName("store");
		return s;
		
	}
	
}
