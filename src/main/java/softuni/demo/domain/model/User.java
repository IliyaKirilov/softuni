package softuni.demo.domain.model;

import org.springframework.security.core.userdetails.UserDetails;
import softuni.demo.domain.model.enums.Brand;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Table(name = "users")
@Entity
public class User extends BaseEntity implements UserDetails {
    private String username;
    private String password;
    private Set<Role> authorities;
    private boolean isCredentialsNonExpired;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isEnabled;
    private Brand brand;
    private Set<Car> cars;
    private Race race;
    private int timesWon;
    private List<Offer> offers;
//    private double budget;


    @OneToMany
    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    @Column(name = "times_won")
    public int getTimesWon() {
        return timesWon;
    }

    public void setTimesWon(int timesWon) {
        this.timesWon = timesWon;
    }

    @ManyToOne
    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    @Enumerated(EnumType.STRING)
    public Brand getBrand()     {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public User() {
    }


    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    @Override
    @Column(unique = true,nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    public Set<Role> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Role> authorities) {
        this.authorities = authorities;
    }


}
