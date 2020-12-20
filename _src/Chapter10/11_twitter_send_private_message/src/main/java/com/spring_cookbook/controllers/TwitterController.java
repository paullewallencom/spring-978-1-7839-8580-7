package com.spring_cookbook.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.social.connect.Connection;
import org.springframework.social.oauth1.AuthorizedRequestToken;
import org.springframework.social.oauth1.OAuth1Operations;
import org.springframework.social.oauth1.OAuth1Parameters;
import org.springframework.social.oauth1.OAuthToken;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TwitterController {
	
	private static final String API_KEY = "YtAG8npnZkUFDghkF2V3ykm0P";
	private static final String API_SECRET = "RQ6hGGALfEaWGh6Vu03xcFtM1ibicW8IwSUBKaLG4drvVXXaay";
	private static final String CALLBACK_URL = "http://142.58.52.113:8080/spring_webapp/tw/callback";
	private static final String REQUEST_TOKEN_NAME = "requestToken";
	private static final String TOKEN_NAME = "twitterToken";

	@RequestMapping("/tw")
	public String tw(HttpServletRequest request, Model model) {
		OAuthToken token = (OAuthToken) request.getSession().getAttribute(TOKEN_NAME);
		if(token == null) {
			return "redirect:/tw/login";			
		}

		TwitterConnectionFactory connectionFactory = new TwitterConnectionFactory(API_KEY, API_SECRET);
		Connection<Twitter> connection = connectionFactory.createConnection(token);
		Twitter twitter = connection.getApi();
		if( ! twitter.isAuthorized()) {
			return "redirect:/tw/login";			
		}

		twitter.directMessageOperations().sendDirectMessage("LyndenChamber", "Hi, please ignore this message. I'm just testing the Twitter API.Thank you! :)");
		
		return "tw";
	}
	
	@RequestMapping("/tw/login")
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		TwitterConnectionFactory connectionFactory = new TwitterConnectionFactory(API_KEY, API_SECRET);
			OAuth1Operations oauthOperations = connectionFactory.getOAuthOperations();
			
			OAuthToken requestToken = oauthOperations.fetchRequestToken(CALLBACK_URL, null);			
			request.getSession().setAttribute(REQUEST_TOKEN_NAME, requestToken);
			String authorizeUrl = oauthOperations.buildAuthenticateUrl(requestToken.getValue(), OAuth1Parameters.NONE);
			
			response.sendRedirect(authorizeUrl);
	}
		
	@RequestMapping("/tw/callback")
	public String callback(String oauth_token, String oauth_verifier, HttpServletRequest request) {
		TwitterConnectionFactory connectionFactory = new TwitterConnectionFactory(API_KEY, API_SECRET);

		OAuthToken requestToken = (OAuthToken) request.getSession().getAttribute(REQUEST_TOKEN_NAME);		
		OAuth1Operations oAuthOperations = connectionFactory.getOAuthOperations();
		OAuthToken token = oAuthOperations.exchangeForAccessToken(new AuthorizedRequestToken(requestToken, oauth_verifier), null);
		
		request.getSession().setAttribute(TOKEN_NAME, token);
		
		return "redirect:/tw";
	}
}
