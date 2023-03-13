package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.ProductDAO;
import dao.memberDAO;
import model.Member;
import model.Product;
import model.ShoppingCart;

@Controller
@RequestMapping
public class IndexController {


	
	@RequestMapping("/home")
	public String homepage() {
		return "TheHomepage";
	}
	
	@RequestMapping("/update")
	public ModelAndView UpdatePage(HttpSession session) {
		ModelAndView model = new ModelAndView("UpdatePage");
		String phone = (String)session.getAttribute("phone");
		Member member = memberDAO.getOne(phone);
		model.addObject("member",member);
		return model;
	}
	
	@RequestMapping("/signin")
	public String SigninPage(HttpSession session) {
		//有登入的話，直接登出，回首頁
		if(session.getAttribute("phone") != null) {
			session.setAttribute("phone", null);
			session.setAttribute("name", null);
			return "TheHomepage";
		}
		
		//沒有登入的話，到登入頁面
		return "SigninPage";
	}
	
	@RequestMapping("/shoppingcart")
	public ModelAndView ShoppingCartPage(HttpSession session) {
		ModelAndView model = new ModelAndView("ShoppingCartPage");
		Map<Integer,Integer> map = (Map)session.getAttribute("cart");
		if(map == null) {
			return model;
		}
		
		List<ShoppingCart> cart = new ArrayList<>();
		for(int i=1;i<=14;i++) {
			if(map.get(i) != null) {
				Product product = ProductDAO.getOne(i);
				ShoppingCart sc= new ShoppingCart();
				sc.setId(i);
				sc.setName(product.getProductName());
				sc.setPrice(product.getPrice());
				sc.setAmount(map.get(i));
				sc.setTotal(product.getPrice()*sc.getAmount());
				cart.add(sc);
			}
		}
		
		model.addObject("cart", cart);
		return model;
	}
	
	@RequestMapping("/register")
	public String RegisterPage() {
		return "RegisterPage";
	}

	@RequestMapping("Admin")
	public String adminPage() {
		return "AdministratorPage";
	}
	
	@RequestMapping("/Admin1")
	public String qmemberpage() {
		return "AdministratorPage1";
	}

	@RequestMapping("/Admin2")
	public String qproductpage() {
		return "AdministratorPage2";
	}
	
	@RequestMapping("/Admin3")
	public String qorderpage() {
		return "AdministratorPage3";
	}
}
