package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.OrderDAO;
import dao.OrderdetailDAO;
import dao.ProductDAO;
import model.Order;
import model.Orderdetail;
import model.OrderdetailPK;

@Controller
@RequestMapping
public class ShoppingCartController {
	
	//加入購物車
	@PostMapping("/addShopping")
	public ModelAndView add(@RequestParam String pid,@RequestParam String amount,HttpSession session) {
		ModelAndView model = new ModelAndView("TheHomepage");
		Map<Integer,Integer> map = null;
		
		if(session.getAttribute("cart") == null) {
			map = new HashMap<>();
		}
		else {
			map = (Map)session.getAttribute("cart");
		}
		
		map.put(Integer.parseInt(pid), Integer.parseInt(amount));
		session.setAttribute("cart", map);
		
		return model;
	}
	
	//刪除購物車品項
	@PostMapping("/delShopping")
	public ModelAndView delShopping(@RequestParam String cartId, HttpSession session) {
		ModelAndView model = new ModelAndView("ShoppingCartPage");
		Map<Integer,Integer> map = (Map)session.getAttribute("cart");
		map.remove(Integer.parseInt(cartId));
		session.setAttribute("cart", map);
		return model;
	}

	@GetMapping("/addOrder")
	public ModelAndView addOrder(HttpSession session) {
		ModelAndView model = new ModelAndView("TheHomepage");
		
		//確認有沒有登入
		if(session.getAttribute("phone") == null) {
			model.setViewName("SigninPage");
			return model;
		}
		
		//建立Order
		SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
		String date = sdf.format(new Date());
		Order order = new Order();
		order.setOrderId(Integer.parseInt(date));
		order.setPhone((String)session.getAttribute("phone"));
		order.setStatus("N");
		Integer total = 0;
		Map<Integer, Integer> map = (Map)session.getAttribute("cart");
		for(int i=1;i<=14;i++) {
			if(map.get(i) != null) {
				total = total + ProductDAO.getOne(i).getPrice()*map.get(i);
			}
		}
		order.setTotal(total);
		OrderDAO.add(order);
		
		//建立OrderDetails
		for(int i=1;i<=14;i++) {
			if(map.get(i) != null) {
				Orderdetail orderdetail = new Orderdetail();
				OrderdetailPK id = new OrderdetailPK();
				id.setOrderId(Integer.parseInt(date));
				id.setProductId(i);
				orderdetail.setId(id);
				orderdetail.setPrice(ProductDAO.getOne(i).getPrice());
				orderdetail.setQuantity(map.get(i));
				orderdetail.setTotal(ProductDAO.getOne(i).getPrice()*map.get(i));
				OrderdetailDAO.add(orderdetail);
			}
		}
		
		return model;
	}
}
