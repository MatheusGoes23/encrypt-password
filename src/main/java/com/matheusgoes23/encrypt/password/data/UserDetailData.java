package com.matheusgoes23.encrypt.password.data;

import com.matheusgoes23.encrypt.password.model.UserModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class UserDetailData implements UserDetails {

    private final Optional<UserModel> optionalUser;

    public UserDetailData(Optional<UserModel> optionalUser) {
        this.optionalUser = optionalUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return optionalUser.orElse(new UserModel()).getPassword();
    }

    @Override
    public String getUsername() {
        return optionalUser.orElse(new UserModel()).getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
