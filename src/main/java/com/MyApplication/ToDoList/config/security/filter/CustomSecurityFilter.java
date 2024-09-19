package com.MyApplication.ToDoList.config.security.filter;

import com.MyApplication.ToDoList.config.security.TokenService;
import com.MyApplication.ToDoList.domain.user.MyUser;
import com.MyApplication.ToDoList.domain.user.MyUserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@Component
public class CustomSecurityFilter extends OncePerRequestFilter {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private MyUserService myUserService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoverToken(request);
        if (token != null) {
            var login = tokenService.validateToken(token);
            MyUser user = (MyUser) myUserService.loadUserByUsername(login.isEmpty() ? null : login);

            var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder
                    .getContext()
                    .setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if(token == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Header: \"Authorization\" não encontrado");
        }
        return token.replace("Bearer ", "");
    }
}
