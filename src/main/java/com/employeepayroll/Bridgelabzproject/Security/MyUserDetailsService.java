package com.employeepayroll.Bridgelabzproject.Security;

import com.employeepayroll.Bridgelabzproject.Util.Authenticator.AuthRequest;
import com.employeepayroll.Bridgelabzproject.Util.Authenticator.AuthResponse;
import com.employeepayroll.Bridgelabzproject.service.JwtUtilService;
import com.employeepayroll.Bridgelabzproject.model.User;
import com.employeepayroll.Bridgelabzproject.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JwtUtilService jwtUtilService;

//    @Lazy
    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthResponse createJwtToken(AuthRequest authRequest) throws Exception {
        String username = authRequest.getUsername();
        String password = authRequest.getPassword();
        authenticate(username,password);

        UserDetails userDetails=loadUserByUsername(username);
        String newGeneratedToken= jwtUtilService.generateToken(userDetails);

        User user=userRepo.findById(username).get();
        return new AuthResponse(user,newGeneratedToken);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepo.findById(username).get();
        if(user!=null){
            return  new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    getAuthorities(user)
            );
        }
        else {
            throw  new UsernameNotFoundException("Username is not valid");

        }
    }

    public List getAuthorities(User  user){
        List authorities = new ArrayList<>();
        user.getRoles().forEach(role ->{
            authorities.add(new SimpleGrantedAuthority("ROLE"+role.getRoleName()));
        });
        return authorities;
    }
    public void authenticate(String username, String password) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }
        catch (DisabledException e){
            throw  new Exception("User is disabled");
        }
        catch (BadCredentialsException e){
            throw new Exception("Bad Credentials from User");
        }


    }
}
