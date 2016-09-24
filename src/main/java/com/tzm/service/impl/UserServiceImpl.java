package com.tzm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tzm.Dao.UserMapper;
import com.tzm.pojo.User;
import com.tzm.service.UserService;




	@Service("userServiceImpl")
	public class UserServiceImpl implements UserService { 
		
		@Autowired
	    private UserMapper userDao; 
	    
	    public User getUserById(int id) {  
	        // TODO Auto-generated method stub 
	    	System.out.println(id+this.userDao.selectByPrimaryKey(id).getUsername());
	    	
	        return this.userDao.selectByPrimaryKey(id);  
	    }  
	  
	    


		public Boolean getLoginUser(User userLogin) {
			// TODO Auto-generated method stub
		if(userLogin.getUsername().equals("")||(userLogin.getPassword().equals(""))){
			return false;
		}else{
			
			User user=new User();
			if(this.userDao.selectLogin(userLogin.getUsername())!=null){
				
				user=userDao.selectLogin(userLogin.getUsername());

				if(user.toString().isEmpty()){
					
					return false;
				}else{
					
					if(user.getPassword().equals(userLogin.getPassword())){
						return true;
					}else{
						return false;
				}
				}
			}else{
				return false;
			}
		  }
		}




		public User user(User user) {
			// TODO Auto-generated method stub
			return null;
		}




		public User selectLogin(String username) {
			// TODO Auto-generated method stub
			return this.userDao.selectLogin(username);
		}




		public User selectByPrimaryKey(int i) {
			// TODO Auto-generated method stub
			return this.userDao.selectByPrimaryKey(i);
		}




		public User getUserByusername(String username) {
			// TODO Auto-generated method stub
			return this.userDao.selectLogin(username);
		}


		public int inster(User user) {
			// TODO Auto-generated method stub
			int i=this.userDao.insert(user);
			return i;
		}


	





	    
	}  

