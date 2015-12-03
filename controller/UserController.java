package org.itc.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Random;

import org.itc.model.Document;
import org.itc.model.Role;
import org.itc.model.ServiceType;
import org.itc.model.Status;
import org.itc.model.User;
import org.itc.model.UserDetails;
import org.itc.model.UserStatus;
import org.itc.service.DocumentService;
import org.itc.service.UserDetailsService;
import org.itc.service.UserService;
import org.itc.utility.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;



@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private DocumentService documentService;
	
	@Autowired
	private SendEmail sendEmail;;
	
	
	

	@RequestMapping(value="/login",method = RequestMethod.POST, consumes={"application/json"})
    public  @ResponseBody User getUserInfo(@RequestBody User user) {
		
    	try{
    		 
    	
 			
    		user = userService.findUser(user.getUserName(), user.getPassword(), user.getRole());
    		
    			if(user !=null)
    			{
    				System.out.println(user);
    		    	return user;
    		    	
    			}
    			else
    			{
    				
    				System.out.println(user);
    				return user;
    			}
    	    }
    	catch(Exception e)
    	        {
    	            e.printStackTrace();
    	        }

    	
    	
    	return user;

    }
	
	
	@RequestMapping(value="/forgetPassword", method = RequestMethod.POST, consumes={"application/json"})
	 public @ResponseBody User forgetPassword(@RequestBody User user) throws Exception { 
		System.out.println("inside forgetPassword");
		
	
		int length = 8;	
		String alphabet = new String("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"); 
		int n = alphabet.length();
		String newPassword = new String(); 
		Random r = new Random(); 
		for (int i=0; i<length; i++) 
		newPassword = newPassword + alphabet.charAt(r.nextInt(n)); 
		System.out.println("Password :-"+newPassword);
		/*---------------------------*/
		
		user=userService.forgetPassword(user, newPassword);
		if(user !=null)
		{
			
			sendEmail.emailSender(user);
	    	return user;
		}
		else
		{
			
			System.out.println(user);
			return user;
		}
	
		
	}
	
	
	@RequestMapping(value="/logout", method = RequestMethod.POST, consumes={"application/json"})
	public @ResponseBody void LogoutUser(@RequestBody int userId) {
		
		userService.LogoutUser(userId);
		System.out.println("inside logout");
		

	}
	
	
	@RequestMapping(value="/signup", method = RequestMethod.POST, consumes={"application/json"})
	 public @ResponseBody User addUser(@RequestBody User user) { 
		try
		{
			Role role = new Role();
			role.setRoleId(2);		
			user.setRole(role);
		
			UserStatus userstatus=new  UserStatus();
			userstatus.setUserstatusId(2);
			user.setUserstatus(userstatus);
		
			userService.addUser(user);
			return user;
		}
		catch(Exception se)
		{
			se.getMessage();
			return null;
			
		}
		
	}
	
	
	@RequestMapping(value="/userdetails", method = RequestMethod.POST, consumes={"application/json"})
	public @ResponseBody UserDetails addUserDetails(@RequestBody UserDetails userDetails) throws ParseException 
	{
		
		
		if(userDetails.getId() == 0 )
		{
		
		Status status=new Status();
		status.setStatusId(1);
		userDetails.setStatus(status);
		}
		
		userDetails =userDetailsService.addUserDetails(userDetails);
		System.out.println("Inside UserDetails block Controller Class");
		System.out.println(userDetails.getId());
		return userDetails;
		
	}
	
	
	
	@RequestMapping(value="/checkforId", method = RequestMethod.POST, consumes={"application/json"})
	public @ResponseBody UserDetails checkforId(@RequestBody User user) throws ParseException
	{
	
		
		UserDetails viewuserDetails = userDetailsService.checkforId(user);
		
		System.out.println("Inside viewuserdetails block Controller Class");
		return viewuserDetails;
		
	}
	
	
	@RequestMapping(value="/getAlldetails", method = RequestMethod.GET, produces={"application/json"})
	public @ResponseBody List<UserDetails> getAllDetails() throws ParseException
	{
		 
		List<UserDetails> viewuserDetails = userDetailsService.getAllDetails();
		  
		  System.out.println("Inside Admin Java Controller");
		  return viewuserDetails;
	}
	
	@RequestMapping(value="/getServiceTable", method = RequestMethod.GET, produces={"application/json"})
	public @ResponseBody List<ServiceType>  getServiceTableInfo() throws ParseException
	{
		
		List<ServiceType> servicetabledata = userDetailsService. getServiceTableInfo();
		System.out.println("Inside Service table");
		
		return servicetabledata;
		
		
	}
	
	@RequestMapping(value="/editUserdetails", method = RequestMethod.POST, consumes={"application/json"})
	 public @ResponseBody UserDetails editUserdetails(@RequestBody int id) throws ParseException
	{
	  
	  UserDetails viewuserDetails = userDetailsService.editUserdetails(id);
	  
	  System.out.println("Inside viewuserdetails block Controller Class");
	  return viewuserDetails;
	 
	 }
	
	
	@RequestMapping(value="/viewuserdetails", method = RequestMethod.POST, consumes={"application/json"})
	public @ResponseBody List<UserDetails> showUserDetails(@RequestBody int userId) throws ParseException
	{
	
		
		List<UserDetails> viewuserDetails = userDetailsService.showUserDetails(userId);
		
		System.out.println("Inside viewuserdetails block Controller Class");
		return  viewuserDetails;
		
	}
	
	
	@RequestMapping(value="/recordforid", method = RequestMethod.POST, produces={"application/json"})
	public @ResponseBody UserDetails recordforid(@RequestBody int id) throws ParseException
	{
	
		
		UserDetails viewuserDetailsid = userDetailsService.recordforid(id);
		
		System.out.println("Inside recordid block Controller Class");
		return viewuserDetailsid;
	
	
	}
	
	
	@RequestMapping(value = "/viewDoc", method = RequestMethod.POST, produces={"application/json"})
	
	 public @ResponseBody List<Document> viewFile(@RequestBody int id) throws IOException
	 {
		List<Document> doc = documentService.getDoc(id);
		return doc;
	 }
	
	
	
	
	@RequestMapping(value="/upload", method=RequestMethod.POST, headers=("content-type=multipart/*"))
	public @ResponseBody void handleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("id") int id ) {
		
		long currentTime = System.currentTimeMillis();
		
		try {
			  FileCopyUtils.copy(file.getBytes(), new FileOutputStream("C:Users/20451/Desktop/OLPV/WebContent/documents/"+currentTime+file.getOriginalFilename()));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		String docPath ="documents/"+currentTime+file.getOriginalFilename();
		System.out.println(docPath);
		
		Document doc = new Document(id, docPath);
		
		documentService.addItem(doc);
		
		//file.refreshLocal(IResource.DEPTH_ZERO, null);
		
	 }

}
