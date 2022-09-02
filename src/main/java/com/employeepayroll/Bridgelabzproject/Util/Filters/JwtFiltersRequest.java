package com.employeepayroll.Bridgelabzproject.Util.Filters;

import com.employeepayroll.Bridgelabzproject.Security.MyUserDetailsService;
import com.employeepayroll.Bridgelabzproject.service.JwtUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class JwtFiltersRequest extends OncePerRequestFilter {

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtilService jwtUtilService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        final String autherizationHeader =request.getHeader("Authorization");
        String username= null;
        String jwtToken = null;
        //verification of JWT
        if(autherizationHeader!= null && autherizationHeader.startsWith("Bearer ")){
            jwtToken=autherizationHeader.substring(7);
            username= jwtUtilService.extractUsername(jwtToken);
        }
        if(username!= null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails= userDetailsService.loadUserByUsername(username);
            if(jwtUtilService.validateToken(jwtToken,userDetails)){
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                        = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request,response);
    }
}
