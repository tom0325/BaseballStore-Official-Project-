package com.sb1123.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sb1123.example.service.*;
import com.sb1123.example.model.*;

@RestController
@RequestMapping(value = "/members")
public class MemberController {
	@Autowired
    private MemberService memberService;

	@RequestMapping
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("member");
		return model;
	}
	
    @RequestMapping(value="/getAll", method = RequestMethod.GET)
    public List<Member> getAllUser() {
    	//memberService.saveMember(new Member("0911", "tpe", "@","11","tom","Y"));
//    	memberService.saveMember(new Member("0922", "tpe", "@","11","tom","Y"));
//    	memberService.saveMember(new Member("0933", "tpe", "@","11","tom","Y"));
//    	memberService.saveMember(new Member("0944", "tpe", "@","11","tom","Y"));
//    	memberService.saveMember(new Member("0955", "tpe", "@","11","tom","Y"));
        //memberService.delMemberByPhone("0911");
        memberService.findOneByPhone("0922");
         
         //ModelAndView model = new ModelAndView("member");
         List<Member> list=memberService.findAll();//List.of(new Member("0911", "tpe", "@","11","tom","Y"),new Member("0922", "tpe", "@","11","tom","Y"),new Member("0933", "tpe", "@","11","tom","Y"));
         
         //model.addObject("m", list );
         return  list;
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@RequestBody Member m ) {
        m = memberService.saveMember(m);
        return "新增成功，返回用戶id為：" + m.getPhone();
    }
    
    @RequestMapping(value="/update",method = RequestMethod.POST)
    public Member updateUser(@RequestBody Member newM)
    {
    	return memberService.updateMember(newM);
    }

    @RequestMapping(value = "/find/{phone}", method = RequestMethod.GET)
    public Member findUser(@PathVariable String phone) {
        return memberService.findOneByPhone(phone);
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public String delUser(@RequestParam("phone") String phone) {
    	memberService.delMemberByPhone(phone);
        return "用戶id為：" + phone + "，已被删除!";
    }

    /*@RequestMapping(value = "/find/{name}/{age}", method = RequestMethod.GET)
    public List<Member> findUserByCodeAndName(@PathVariable("name") String name, @PathVariable("phone") String phone) {
        return memberService.findByNameAndPhone(name, phone);
    }*/
}
