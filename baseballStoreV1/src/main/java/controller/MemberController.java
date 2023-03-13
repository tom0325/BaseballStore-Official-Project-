package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.OrderDAO;
import dao.memberDAO;
import model.Member;
import model.Order;

@Controller
@RequestMapping
public class MemberController {

	@PostMapping("/addMember")
	public ModelAndView add(@ModelAttribute Member member) {
		memberDAO.addMember(member);
		ModelAndView model = new ModelAndView("SigninPage");
		
		
		
		return model;
	}
	
	@PostMapping(value="/login")
	public ModelAndView query(@RequestParam String phone,@RequestParam String password,HttpSession session) 
	{	
		Member member = memberDAO.getOne(phone);
		ModelAndView model = new ModelAndView("TheHomepage");
		if(member != null) {
			if(password.equals(member.getPassword())) {
				session.setAttribute("phone", member.getPhone());
				session.setAttribute("name", member.getName());
			}
		}
		return model;
	}
	
	@PostMapping("/updateMember")
	public ModelAndView update(@ModelAttribute Member member, HttpSession session) {
		memberDAO.update(member);
		session.setAttribute("name", member.getName());
		ModelAndView model = new ModelAndView("TheHomepage");
		return model;
	}
}
