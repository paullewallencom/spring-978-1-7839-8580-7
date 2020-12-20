package com.spring_cookbook.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.spring_cookbook.domain.User;

@Controller
public class UserController {
	
	@RequestMapping("/user_list")
	public void userList() {
	}

	@RequestMapping("addUser")
	public String addUser() {
		return "addUser";
	}
	
	@RequestMapping(value="addUser", method=RequestMethod.POST)
	public String addUser(User user, @RequestParam("file") MultipartFile formFile) {
		
		try {
		    // Create the folder "files" if necessary
		    String tomcatFolderPath = System.getProperty("catalina.home");
		    File filesFolder = new File(tomcatFolderPath + File.separator + "files");
		    if ( ! filesFolder.exists()) {
		        filesFolder.mkdirs();
		    }

		    // Create the file on server
		    File file = new File(filesFolder.getAbsolutePath() + File.separator + formFile.getName());
		    BufferedOutputStream fileStream = new BufferedOutputStream(new FileOutputStream(file));
		    fileStream.write(formFile.getBytes());
		    fileStream.close();
		    
			System.out.println(filesFolder.getAbsolutePath() + File.separator + formFile.getName());
		} catch (Exception e) {
			// deal with the exception…
		}

		return "redirect:/user_list";
	}
	
	@ModelAttribute("defaultUser")
	public User defaultUser() {
		User user = new User();

		user.setFirstName("Joe");
		user.setAge(45);		

		return user;
	}
}
