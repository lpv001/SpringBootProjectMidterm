package com.midterm.demo.config;

import java.io.IOException;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        // TODO Auto-generated method stub
        
        boolean hasUserRole = false;
		boolean hasAdminRole = false;
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("CASHIER")) {
				hasUserRole = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("ADMIN")) {
				hasAdminRole = true;
				break;
			}
		}

        if (hasUserRole) {
			redirectStrategy.sendRedirect(request, response, "/giccafe/homepage");
		} else if (hasAdminRole) {
			redirectStrategy.sendRedirect(request, response, "/gicadmin/homepage");
		} else {
			throw new IllegalStateException();
		}

    }

}
