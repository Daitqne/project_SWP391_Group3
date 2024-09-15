package org.example.swp391.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Date;

@Getter
@Setter
public class AuthUser extends User {
    private long id;
    private String email;
    private Date createdDate;

    public AuthUser(String username, String password, Collection<? extends GrantedAuthority> authorities, long id,String email,Date createdDate) {
        super(username, password, authorities);
        this.id = id;
        this.email = email;
        this.createdDate = createdDate;
    }

}