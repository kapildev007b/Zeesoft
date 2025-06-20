package com.example.demo.security;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.GenericFilter;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TokenAuthFilter  extends GenericFilter{
	 private static final String TOKEN = "Bearer my-secret-token";
	    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
	        throws IOException, ServletException {
	        HttpServletRequest request = (HttpServletRequest) req;
	        String authHeader = request.getHeader("Authorization");

	        if (authHeader == null || !authHeader.equals(TOKEN)) {
	            ((HttpServletResponse) res).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
	            return;
	        }

	        chain.doFilter(req, res);
	    }
	

}
