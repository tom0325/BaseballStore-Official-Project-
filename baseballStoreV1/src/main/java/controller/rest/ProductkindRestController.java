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

import dao.ProductkindDAO;
import model.Productkind;

@RestController
@RequestMapping("/productkind/rest")
public class ProductkindRestController {

	@GetMapping("/getAll")
	public List<Productkind> getAll(){
		return ProductkindDAO.getAll();
	}
	
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	public Productkind getOne(@PathVariable("id") String id) {
		return ProductkindDAO.getOne(id);
	}
	
	@PostMapping("/del/{id}")
	public List<Productkind> delete(@PathVariable("id") String id){
		ProductkindDAO.delete(id);
		return ProductkindDAO.getAll();
	}
	
	@PostMapping("/add")
	public List<Productkind> add(@RequestBody Productkind productkind){
		ProductkindDAO.add(productkind);
		return ProductkindDAO.getAll();
	}
	
	@PostMapping("/update")
	public List<Productkind> update(@RequestBody Productkind productkind){
		ProductkindDAO.update(productkind);
		return ProductkindDAO.getAll();
	}
}
