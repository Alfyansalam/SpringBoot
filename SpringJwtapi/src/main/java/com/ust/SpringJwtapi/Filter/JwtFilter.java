package com.ust.SpringJwtapi.Filter;

import java.io.IOException;





import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ust.SpringJwtapi.Services.UserService;
import com.ust.SpringJwtapi.Utility.JwtUtility;









@Component
public class JwtFilter extends OncePerRequestFilter {
    
    private static final HttpServletRequest HttpServletRequest = null;





  private static final ServletResponse HttpServletResponse = null;





  private static final String authorization = null;





  @Autowired
    private JwtUtility jwtUtility;
    
    @Autowired
    private UserService userService;
    
    @Override
    protected void doFilterInternal(javax.servlet.http.HttpServletRequest request, HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {    String token = null;
    String userName = null;
    
    if(null != authorization && authorization.startsWith("Bearer")) {
        token = authorization.substring(7);
        userName = jwtUtility.getUsernameFromToken(token);        
    }
    
    if(null != userName && SecurityContextHolder.getContext().getAuthentication()==null) {
        UserDetails userDetails = userService.loadUserByUsername(userName);
        
        if(jwtUtility.validateToken(token, userDetails)) {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
            
            usernamePasswordAuthenticationToken.setDetails(
                    new WebAuthenticationDetailsSource().buildDetails(HttpServletRequest));
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
    }





filterChain.doFilter(HttpServletRequest, HttpServletResponse);
    }
}
