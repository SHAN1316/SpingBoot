package com.example.Spring.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.example.Spring.domain.User;
import com.example.Spring.service.UserService;
@RestController
@RequestMapping("/User")
public class UserSelectController {
	/*Date date = new Date();
	DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);        
	String formattedDate = dateFormat.format(date);*/
	//Thymeleaf应用构建
	@Resource
    UserService userService;
	@ResponseBody
	@RequestMapping(value = "/SelUser")
	public Object SelUser(Map<String,String> map) {
		List<User>  list1  =userService.getUserList();
		ModelAndView mav = new ModelAndView("/Thymeleafs/select");
		mav.addObject("list", list1);
		return  mav;
	     }
	//跳转增加页面
	@RequestMapping("/toAddUser")
    public Object toAddUser() {
		ModelAndView mav = new ModelAndView("/Thymeleafs/AddUser");
        return mav;
    }
	@RequestMapping("/AddUser")
	public Object AddUser(User user ){    
		/*user.setRegTime(formattedDate);*/
		final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss");
		user.setRegTime(dateFormat.format(new Date()));
		 userService.save(user);
		 List<User>  list1  =userService.getUserList();
			ModelAndView mav = new ModelAndView("/Thymeleafs/select");
			mav.addObject("list", list1);
		return  mav;
		//System.out.println(user);
	}
	@RequestMapping("/DelUser")
	public Object toDelete( Long id){
		 userService.delete(id);
		 List<User>  list1  =userService.getUserList();
			ModelAndView mav = new ModelAndView("/Thymeleafs/select");
			mav.addObject("list", list1);
		return  mav;
		//System.out.println(user);
	}
	@RequestMapping("/toUpdUser")
	public Object toUpdata( Long id ){
		User user =userService.findUserById(id);
		ModelAndView mav = new ModelAndView("/Thymeleafs/Updata");
		mav.addObject("user", user);
		return mav;
		//System.out.println(user);
	}
	@RequestMapping("/UpdUser")
	public Object Updata( User user){
		userService.edit(user);
		List<User>  list1  =userService.getUserList();
		ModelAndView mav = new ModelAndView("/Thymeleafs/select");
		mav.addObject("list", list1);
	    return  mav;
		//System.out.println(user);
	}
}
