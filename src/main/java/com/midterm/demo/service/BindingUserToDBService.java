// package com.midterm.demo.service;

// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Component;

// import com.midterm.demo.models.Cashier;
// import com.midterm.demo.repositories.CashierRepository;

// @Component
// public class BindingUserToDBService implements UserDetailsService {

//     @Autowired
//     private CashierRepository repository;
    
//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//         Cashier userInfo = repository.findByName(username);
//         return null;
//     }

// }
