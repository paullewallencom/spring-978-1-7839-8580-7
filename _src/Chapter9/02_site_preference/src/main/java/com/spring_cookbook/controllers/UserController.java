package com.spring_cookbook.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.mobile.device.site.SitePreference;
import org.springframework.mobile.device.site.SitePreferenceUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@RequestMapping("/user_list")
	public void userList(HttpServletRequest request) {
		// device detection
		Device currentDevice = DeviceUtils.getCurrentDevice(request);
		if(currentDevice == null) {
			System.out.println("no device detected");
		}
		if(currentDevice.isMobile()) {
			System.out.println("mobile");
		}
		else if(currentDevice.isTablet()) {
			System.out.println("tablet");			
		}
		else if(currentDevice.isNormal()) {
			System.out.println("normal");			
		}
		
		// site preference value
		SitePreference sitePreference = SitePreferenceUtils.getCurrentSitePreference(request);
		if(sitePreference == null) {
			System.out.println("no site preference detected");
		}
		if(sitePreference.isMobile()) {
			System.out.println("site preference: mobile");
		}
		else if(sitePreference.isTablet()) {
			System.out.println("site preference: tablet");			
		}
		else if(sitePreference.isNormal()) {
			System.out.println("site preference: normal");			
		}
	}

}
