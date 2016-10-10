package com.tzm.controller;




import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tzm.service.UserService;

import common.log.HiLogger;
import common.shiro.CacheManager;
import common.utils.JsonMaps;
import common.utils.UtilValidate;
import net.sf.ehcache.Cache;



@Controller
public class newController {
	   HiLogger Logger =  HiLogger.getHiLogger(newController.class);
 
	@Resource(name="UserServiceImpl")
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	@RequestMapping(value="/testPost.do",   produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
	@ResponseBody 
	public String toIndex(HttpServletRequest request,Model model){
	 Map<String,Object> returnMap = new HashMap<>();
	 String msg = "";  
	 Logger.info("进入post 方法获取参数");
	 String username =  request.getParameter("username");
	 String passwrod =  request.getParameter("password");
	 Logger.info("username = "+username);
	 Logger.info("passwrod = "+passwrod);
	 if(UtilValidate.isEmpty(username)||UtilValidate.isEmpty(passwrod)){
	   returnMap.put("errorMsg", "用户名或密码为空");
	   return JsonMaps.parseMapToJson(returnMap);
	 }
	  Map<String,Object> columnMap = new HashMap<>();
	  columnMap.put("username", username);
	  columnMap.put("logpwd", passwrod);
	  
	 /* if(UtilValidate.isEmpty(userService.selectByMap(columnMap))){
	    returnMap.put("errorMsg", "用户名或密码错误");
	     return JsonMaps.parseMapToJson(returnMap);
	  }*/
	  UsernamePasswordToken token = new UsernamePasswordToken(username, passwrod);  
    token.setRememberMe(true);  
    Subject subject = SecurityUtils.getSubject();
    
    
    try {  
      subject.login(token);  
      if (subject.isAuthenticated()) { 
        CacheManager<String,Object> cacheManage = new CacheManager<>();
        org.apache.shiro.cache.Cache<String, Object> cache = cacheManage.getCache();
        cache.put( token.getUsername(),  token.getUsername());
        cacheManage.setCache(cache);
        System.out.println(cacheManage.get( token.getUsername())); 
        return token.getUsername();
        
        /*User user =  (User) userService.selectByMap(columnMap).get(0);
        Logger.info("*****username"+user.getNickname());
        Logger.info("*****pwd"+user.getPswd());
        returnMap.put("username", user.getNickname());
        returnMap.put("password", user.getPswd());
        return JsonMaps.parseMapToJson(returnMap);*/
      } else {  
          return "index";  
      }  
  } catch (IncorrectCredentialsException e) {  
      msg = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";  
      model.addAttribute("message", msg);  
      System.out.println(msg);  
  } catch (ExcessiveAttemptsException e) {  
      msg = "登录失败次数过多";  
      model.addAttribute("message", msg);  
      System.out.println(msg);  
  } catch (LockedAccountException e) {  
      msg = "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.";  
      model.addAttribute("message", msg);  
      System.out.println(msg);  
  } catch (DisabledAccountException e) {  
      msg = "帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.";  
      model.addAttribute("message", msg);  
      System.out.println(msg);  
  } catch (ExpiredCredentialsException e) {  
      msg = "帐号已过期. the account for username " + token.getPrincipal() + "  was expired.";  
      model.addAttribute("message", msg);  
      System.out.println(msg);  
  } catch (UnknownAccountException e) {  
      msg = "帐号不存在. There is no user with username of " + token.getPrincipal();  
      model.addAttribute("message", msg);  
      System.out.println(msg);  
  } catch (UnauthorizedException e) {  
      msg = "您没有得到相应的授权！" + e.getMessage();  
      model.addAttribute("message", msg);  
      System.out.println(msg);  
  }
    return msg;  
  
    
    }
	@RequestMapping(value="/userGet.do",  produces = {"application/json;charset=UTF-8"},method = RequestMethod.GET)
	@ResponseBody  
	public String toIndex2(HttpServletRequest request,Model model){
    return  toIndex(request,model);
    }
	
	
	@RequestMapping(value="/test2.do",method= RequestMethod.POST)
	public String registerIndex(HttpServletRequest request,Model model){
	  return  toIndex(request,model);
	  }

	


	
	
}
