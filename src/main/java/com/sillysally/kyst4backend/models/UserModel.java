package com.sillysally.kyst4backend.models;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;

@Entity
public class UserModel implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String email;

    @NotEmpty
    @Size(min=2, max=50)
    private String username;

    @NotEmpty
    @Size(min=6, max=200)
    private String password;

    public UserModel() {

    }

    public UserModel setId(Long id) {
        this.id = id;
        return this;
    }
    public Long getId() {
        return id;
    }

    public UserModel setEmail(String email) {
        this.email = email;
        return this;
    }
    public String getEmail() {
        return email;
    }
    public UserModel setPassword(String password) {
        this.password = password;
        return this;
    }
    public String getPassword() {
        return password;
    }
    public UserModel setUsername(String username) {
        this.username = username;
        return this;
    }
    public String getUsername() {
        return username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
