package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.OrderDAO;
import dao.OrderdetailDAO;
import dao.ProductDAO;
import dao.ProductkindDAO;
import dao.memberDAO;
import model.Member;
import model.Order;
import model.Orderdetail;
import model.Product;
import model.Productkind;

@Controller
public class AdministratorController {
	
	@RequestMapping("/adminLogin")
	public ModelAndView adminLogin() {
		return new ModelAndView("login");
	}
	
	//查詢全部商品
	@RequestMapping(value="/getAllKind", method=RequestMethod.GET)
	public ModelAndView getAllKind() {
		ModelAndView model = new ModelAndView("Qproduct");
		List<Product> g = ProductDAO.getAll();
		model.addObject("data",g);
		return model;
	}
	
	@RequestMapping(value="/getKind", method=RequestMethod.GET)
	public ModelAndView productKindId(@RequestParam String productKindId) {
		ModelAndView model = new ModelAndView("Qproduct");
		
		List<Product> g;
		if(productKindId.equals("all")) {
			g = ProductDAO.getAll();
		}
		else {
			g = ProductDAO.getByKind(productKindId);
		}
		
		model.addObject("data",g);
		
		return model;
	}
	
	//--------------------------------------------------------
	
	@RequestMapping(value="/getPhone", method=RequestMethod.GET)
	public ModelAndView memberPhone(@RequestParam String memberPhone) {
		ModelAndView model = new ModelAndView("Qmember");
		
		Member g = memberDAO.getOne(memberPhone);
		List<Member> list = new ArrayList();
		list.add(g);
		
		model.addObject("data",list);
		
		return model;
	}

	@RequestMapping(value="getAllMember", method=RequestMethod.GET)
	public ModelAndView getAllMember() {
		ModelAndView model = new ModelAndView("Qmember");
		List<Member> list = memberDAO.getAll();
		model.addObject("data",list);
		return model;
	}
	
	//--------------------------------------------------------
	
	
	@RequestMapping(value="/getOrderPhone", method=RequestMethod.GET)
	public ModelAndView orderPhone(@RequestParam String orderPhone) {
		ModelAndView model = new ModelAndView("Qorder");
		
		List<Order> g = OrderDAO.getByPhone(orderPhone);
				
		model.addObject("data", g);
		
		return model;
	}

	@RequestMapping(value="getAllOrder", method=RequestMethod.GET)
	public ModelAndView getAllOrder() {
		ModelAndView model = new ModelAndView("Qorder");
		List<Order> list = OrderDAO.getAll();
		model.addObject("data", list);
		return model;
	}
	
	@RequestMapping(value="/getOrderStatus", method=RequestMethod.GET)
	public ModelAndView orderStatus(@RequestParam String orderStatus) {
		ModelAndView model = new ModelAndView("Qorder");
		
		List<Order> g = OrderDAO.getByStatus(orderStatus);
				
		model.addObject("data", g);
		
		return model;
	}
	
	@PostMapping("/delOrder")
	public ModelAndView delOrder(@RequestParam String orderId) {
		List<Orderdetail> ods = OrderdetailDAO.getByOrderId(Integer.parseInt(orderId));
		for(int i=0;i<ods.size();i++) {
			OrderdetailDAO.delete(ods.get(i).getId());
		}
		
		OrderDAO.delete(Integer.parseInt(orderId));
		
		ModelAndView model = new ModelAndView("Qorder");
		List<Order> list = OrderDAO.getAll();
		model.addObject("data", list);
		return model;
	}

	@PostMapping("/enableOrder")
	public ModelAndView updateOrder(@RequestParam String orderId, @RequestParam String status) {
		Order order = OrderDAO.getOne(Integer.parseInt(orderId));
		System.out.println(status.getClass());
		if(status.equals("true")) {
			status = "Y";
		}
		else if(status.equals("false")) {
			status = "N";
		}
		order.setStatus(status);
		OrderDAO.update(order);
		
		ModelAndView model = new ModelAndView("Qorder");
		List<Order> list = OrderDAO.getAll();
		model.addObject("data", list);
		return model;
	}
	
	@PostMapping("/enableMember")
	public ModelAndView updateMember(@RequestParam String phone, @RequestParam String enabled) {
		Member member = memberDAO.getOne(phone);
		if(enabled.equals("true")) {
			enabled = "Y";
		}
		else if(enabled.equals("false")) {
			enabled = "N";
		}
		member.setEnabled(enabled);
		memberDAO.update(member);
		
		ModelAndView model = new ModelAndView("Qmember");
		List<Member> list = memberDAO.getAll();
		model.addObject("data", list);
		return model;
	}
	
	@PostMapping("/enableProduct")
	public ModelAndView updateProduct(@RequestParam String productId, @RequestParam String enabled) {
		Product product = ProductDAO.getOne(Integer.parseInt(productId));
		if(enabled.equals("true")) {
			enabled = "1";
		}
		else if(enabled.equals("false")) {
			enabled = "0";
		}
		product.setEnabled(enabled);
		ProductDAO.update(product);
		
		ModelAndView model = new ModelAndView("Qproduct");
		List<Product> list = ProductDAO.getAll();
		model.addObject("data", list);
		return model;
	}
}
