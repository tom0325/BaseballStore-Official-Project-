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

import dao.ProductDAO;
import model.Product;

@RestController
@RequestMapping("/product/rest")
public class ProductRestController {

	@GetMapping("/getAll")
	public List<Product> getAll(){
		return ProductDAO.getAll();
	}
	
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	public Product getOne(@PathVariable("id") int id) {
		return ProductDAO.getOne(id);
	}
	
	@PostMapping("/del/{id}")
	public List<Product> delete(@PathVariable("id") int id){
		ProductDAO.delete(id);
		return ProductDAO.getAll();
	}
	
	@PostMapping("/add")
	public List<Product> add(@RequestBody Product product){
		ProductDAO.add(product);
		return ProductDAO.getAll();
	}
	
	@PostMapping("/update")
	public List<Product> update(@RequestBody Product product){
		ProductDAO.update(product);
		return ProductDAO.getAll();
	}
	
	@RequestMapping(value="/getByKind/{id}", method=RequestMethod.GET)
	public List<Product> getByKind(@PathVariable("id") String productKindId) {
		return ProductDAO.getByKind(productKindId);
	}
}
