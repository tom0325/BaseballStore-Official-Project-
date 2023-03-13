package controller.rest;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dao.OrderDAO;
import model.Order;

@RestController
@RequestMapping("/order/rest")
public class OrderRestController {

	@GetMapping("/getAll")
	public List<Order> getAll(){
		return OrderDAO.getAll();
	}
	
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	public Order getOne(@PathVariable("id") int id) {
		return OrderDAO.getOne(id);
	}
	
	@PostMapping("/del/{id}")
	public List<Order> delete(@PathVariable("id") int id){
		OrderDAO.delete(id);
		return OrderDAO.getAll();
	}
	
	@PostMapping("/add")
	public List<Order> add(@RequestBody Order order){
		OrderDAO.add(order);
		return OrderDAO.getAll();
	}
	
	@PostMapping("/update")
	public List<Order> update(@RequestBody Order order){
		OrderDAO.update(order);
		return OrderDAO.getAll();
	}
}
