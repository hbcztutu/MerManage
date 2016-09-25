package com.tzm.controller;




import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tzm.pojo.User;
import com.tzm.service.UserService;

import common.log.HiLogger;
import common.utils.JsonMaps;
import common.utils.UtilValidate;



@Controller
public class testController {
	   HiLogger Logger =  HiLogger.getHiLogger(testController.class);
 
	@Resource(name="userServiceImpl")
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	@RequestMapping(value="/testPost.do", method = RequestMethod.POST)
    @ResponseBody  
	public String toIndex(HttpServletRequest request,Model model){
		Logger.info("进入post方法，接收到的参数为username="+request.getParameter("username")+"password="+request.getParameter("password"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Map<String, Object> returnMap = new HashMap<>();
		if(UtilValidate.isEmpty(username)||UtilValidate.isEmpty(password)){
			returnMap.put("returnCode", "99");
			returnMap.put("returnMsg", "未找到用户");
			Logger.info("返回信息"+JsonMaps.parseMapToJson(returnMap));
			return JsonMaps.parseMapToJson(returnMap);
		}
		User userLogin=new User();
		userLogin.setUsername(request.getParameter("username"));
		userLogin.setPassword(request.getParameter("password"));
		
		 User user=new User();

		if(this.userService.getLoginUser(userLogin)){
          user=this.userService.getUserByusername(userLogin.getUsername());
          System.out.println(user.toString()+"get user success");
          model.addAttribute("user", user);
          returnMap.put("user", user.getUsername());
		}else{
			
			model.addAttribute("user can not in use");
			System.out.println("can not get user");
		}
	      	return JsonMaps.parseMapToJson(returnMap);
	}
	@RequestMapping(value="/testGet.do",  produces = {"application/json;charset=UTF-8"},method = RequestMethod.GET)
	@ResponseBody  
	public String toIndex2(HttpServletRequest request,Model model){
		Logger.info("进入post方法，接收到的参数为username="+request.getParameter("username")+"password="+request.getParameter("password"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Map<String, Object> returnMap = new HashMap<>();
		if(UtilValidate.isEmpty(username)||UtilValidate.isEmpty(password)){
			returnMap.put("returnCode", "99");
			returnMap.put("returnMsg", "未找到用户");
	     Logger.info("返回信息"+JsonMaps.parseMapToJson(returnMap));

			return JsonMaps.parseMapToJson(returnMap);
		}
		User userLogin=new User();
		userLogin.setUsername(request.getParameter("username"));
		userLogin.setPassword(request.getParameter("password"));
		
		 User user=new User();

		if(this.userService.getLoginUser(userLogin)){
          user=this.userService.getUserByusername(userLogin.getUsername());
          System.out.println(user.toString()+"get user success");
          model.addAttribute("user", user);
          returnMap.put("user", user.getUsername());
		}else{
			
			model.addAttribute("user can not in use");
			System.out.println("can not get user");
		}
    Logger.info("返回信息"+JsonMaps.parseMapToJson(returnMap));

	      	return JsonMaps.parseMapToJson(returnMap);
	}
	
	
	@RequestMapping(value="/test2.do",method= RequestMethod.POST)
	public String registerIndex(HttpServletRequest request,Model model){
		
		//ModelAndView mav=new ModelAndView();

		User userRegister=new User();
		String username2=request.getParameter("username");
		String password2=request.getParameter("password");
		userRegister.setUsername(username2);
		userRegister.setPassword(password2);
		System.out.println(username2+"密码是"+password2);
		
		if(userRegister.getUsername()!=null){
			if (request.getParameter("age")==null) {
				userRegister.setAge(25);
			}else{
				userRegister.setAge(Integer.parseInt(request.getParameter("age")));
			}
			System.out.println(userRegister.getUsername()+" 显示注册的名字");
			
		}else{
			
			User user2 = new User();  
			user2.setUsername("pm");  
			user2.setPassword("pm");  
			user2.setAge(45);  			
			userRegister=user2;			
		}
		
		int id=this.userService.inster(userRegister);

        User user=this.userService.getUserById(id);
        
        System.out.println(user.toString()+"insert user success");
        
        model.addAttribute("user", user);
		
	    return "indexuser";
	}

	


	
	
}
