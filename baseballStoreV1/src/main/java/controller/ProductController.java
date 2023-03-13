package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.ProductDAO;
import model.Product;

@Controller
@RequestMapping()
public class ProductController {

	@GetMapping("offense")
	public ModelAndView itemPageOff() {
		ModelAndView model = new ModelAndView("OffensePage");
		List<Product> data = ProductDAO.getByKind("off");
		model.addObject("data", data);
		return model;
	}
	
	@GetMapping("defense")
	public ModelAndView itemPageDef() {
		ModelAndView model = new ModelAndView("DefensePage");
		List<Product> data = ProductDAO.getByKind("def");
		model.addObject("data", data);
		return model;
	}
	
	@GetMapping("pitcher")
	public ModelAndView itemPagePit() {
		ModelAndView model = new ModelAndView("PitcherPage");
		List<Product> data = ProductDAO.getByKind("pit");
		model.addObject("data", data);
		return model;
	}
}
