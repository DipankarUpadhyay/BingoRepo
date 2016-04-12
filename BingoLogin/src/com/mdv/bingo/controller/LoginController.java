package com.mdv.bingo.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mdv.bingo.dao.UserDao;
import com.mdv.bingo.model.UserDetail;
import com.mdv.bingo.model.User;

@Controller
public class LoginController {
 
	@Autowired
	private UserDao userDao;	
	
	@RequestMapping(value = {"/login.do", "/"}, method = RequestMethod.GET)
	public String login(ModelMap map){
		//System.out.println("=======login=========");
		map.addAttribute("userLogin", new User());
        return "Login";
	}
		
	@RequestMapping(value="/registration.do", method=RequestMethod.GET)
	  public String signup(Model model) {
	      UserDetail userDetail = new UserDetail();
	      model.addAttribute("userSignUp", userDetail);
	      model.addAttribute("pageType", "new");
	      return "Registration";
	  } 
	
	@RequestMapping(value = "/checklogin", method = RequestMethod.POST)
	public String checklogin(@Valid @ModelAttribute("userLogin") User user,BindingResult result, ModelMap map)
	{
		System.out.println("First Name:" + user.getUsername() +" password:" + user.getPassword());
		if(result.hasErrors())
	        return "Login";
		
		User dbUser = userDao.isUserExist(user.getUsername(), "User");
		if(dbUser!=null){
			map.addAttribute("id",dbUser.getId());
			return "Welcome";
		}
		else{
			map.addAttribute("message", "Not Exist! Please check your username and passowrd");
			return login(map);
		}
	}

	 @RequestMapping(value="/signup.do", method=RequestMethod.POST)
	  public String signup(@Valid @ModelAttribute("userSignUp") UserDetail userDetail, BindingResult result, ModelMap model) {       
	      if(result.hasErrors()) {
	          return "Registration";
	      } else if(userDao.findByUserName(userDetail.getUserName(), "User")) {
	    	  System.out.println("========Username already exist====");
	          model.addAttribute("message", "User Name exists. Try another user name");
	          return "Registration";
	      } else {	
	    	  System.out.println("========try to save new user====");
	    	  if(userDao.saveUser(userDetail))	
	    		  model.addAttribute("message", "Saved User details successfully");
	    	  else
	    		  model.addAttribute("message", "Some error occured is User details");
	          return login(model);	
	      }
	 }
	 
	 @RequestMapping(value="/editGetUser.do", method=RequestMethod.GET)
	 public String editGetUser(@RequestParam Map<String,String> allRequestParams, Model model) {
		 String id = allRequestParams.get("id");
		 UserDetail userDetail = userDao.getUser(Long.parseLong(id));
	      model.addAttribute("userSignUp", userDetail);
	      model.addAttribute("pageType", "edit");
	      return "Registration";
	  }
	 
	 @RequestMapping(value="/updateUser.do", method=RequestMethod.POST)
	 public String updateProfile(@Valid @ModelAttribute("userSignUp") UserDetail userDetail, BindingResult result, ModelMap model) {       
	      if(result.hasErrors()) {
	          return "Registration";
	      /*} else if(userDao.findByUserName(userDetail.getUserName(), "UserDetail")) {
	    	  System.out.println("========Username already exist====");
	          model.addAttribute("message", "User Name exists. Try another user name");
	          return "Registration";*/
	      } else {
			 System.out.println("========try to update existing user====");
		   	  if(userDao.updateUser(userDetail))	{
		   		model.addAttribute("message", "Update User details successfully");
		   		model.addAttribute("id",userDetail.getId());
				return "Welcome";
		   	  }
		   	  else
		   		  model.addAttribute("message", "Some error occured in update User details");
	         return login(model);
	      }
	 }
	
   /* @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listEmployees(ModelMap map)
    {
    	//System.out.println("=====listEmployees/======="+map.size()+"==name==="+employeeManager.getName());
        map.addAttribute("employee", new EmpDetail());
        map.addAttribute("employeeList", employeeManager.getAllEmployees());
        System.out.println("=====listEmployees/======="+map.size());
        return "editEmployeeList";
    }
 
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute(value="employee") EmpDetail employee, BindingResult result)
    {
    	System.out.println("=====listEmployees/add=======");
        employeeManager.addEmployee(employee);
        return "redirect:/";
    }
 
    @RequestMapping("/delete/{employeeId}")
    public String deleteEmplyee(@PathVariable("employeeId") Integer employeeId)
    {
    	System.out.println("=====listEmployees/delete=======");
        employeeManager.deleteEmployee(employeeId);
        return "redirect:/";
    }
 
    public void setEmployeeManager(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }*/
}
