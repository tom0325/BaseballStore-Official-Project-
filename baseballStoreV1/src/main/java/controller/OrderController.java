package controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.OrderDAO;
import model.Order;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@RequestMapping(method=RequestMethod.POST)
	public String manager() {
		return "orderManager";
	}

	@GetMapping("/getAll")
	public ModelAndView getAll() {
		List<Order> data = OrderDAO.getAll();
		ModelAndView model = new ModelAndView("result");
		model.addObject("orders", data);
		return model;
	}
	
	@PostMapping("/add")
	public ModelAndView add(@ModelAttribute Order order) {
		OrderDAO.add(order);
		List<Order> data = OrderDAO.getAll();
		ModelMap model2 = new ModelMap();
		ModelAndView model = new ModelAndView("result");

		model.addObject("orders");
		return model;
	}
	
	
	
}
