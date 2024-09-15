package org.example.swp391.service.impl;

import org.example.swp391.entity.*;
import org.example.swp391.repository.AccountRepository;
import org.example.swp391.repository.CustomerRepository;
import org.example.swp391.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService {
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public UserServiceImpl(AccountRepository accountRepository, CustomerRepository customerRepository, EmployeeRepository employeeRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException(username);
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        Role role = customerRepository.findByAccount(account).getRole();
        if (role == null) {
            role = employeeRepository.findByAccount(account).getRole();
        }

        if (role != null) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        return new AuthUser(
                account.getUsername(),
                account.getPassword(),
                grantedAuthorities,
                account.getAccountId(),
                account.getEmail(),
                account.getRegisterDate()
        );
    }

}
