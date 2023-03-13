package controller.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dao.OrderdetailDAO;
import model.Orderdetail;
import model.OrderdetailPK;

@RestController
@RequestMapping("/orderdetail/rest")
public class OrderdetailRestController {

	@GetMapping("/getAll")
	public List<Orderdetail> getAll(){
		return OrderdetailDAO.getAll();
	}
	
	@RequestMapping(value="/get/{orderId}/{productId}", method=RequestMethod.GET)
	public Orderdetail getOne(@PathVariable("orderId") int orderId, @PathVariable("productId") int productId) {
		OrderdetailPK id = new OrderdetailPK();
		id.setOrderId(orderId);
		id.setProductId(productId);
		return OrderdetailDAO.getOne(id);
	}
	
	@PostMapping("/del/{orderId}/{productId}")
	public List<Orderdetail> delete(@PathVariable("orderId") int orderId, @PathVariable("productId") int productId){
		OrderdetailPK id = new OrderdetailPK();
		id.setOrderId(orderId);
		id.setProductId(productId);
		OrderdetailDAO.delete(id);
		return OrderdetailDAO.getAll();
	}
	
	@PostMapping("/add")
	public List<Orderdetail> add(@RequestBody Orderdetail orderdetail){
		OrderdetailDAO.add(orderdetail);
		return OrderdetailDAO.getAll();
	}
	
	@PostMapping("/update")
	public List<Orderdetail> update(@RequestBody Orderdetail orderdetail){
		OrderdetailDAO.update(orderdetail);
		return OrderdetailDAO.getAll();
	}
}
