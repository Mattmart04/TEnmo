package com.techelevator.tenmo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tenmo_user")
@Data
public class User {
   @Id
   @SequenceGenerator(name="user_sequence",sequenceName="seq_user_id", allocationSize=1)
   @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="user_sequence")
   private int userId;
   private String username;
   @JsonIgnore // prevent from being sent to client
   @Column(name = "passwordHash")
   private String password;
   @JsonIgnore
   @Transient
   private boolean activated;
   private String role;
   @Transient
   private Set<Authority> authorities = new HashSet<>();

   public User() {
      this.activated = true;
   }

   public User(int id, String username, String password, String authorities) {
      this.userId = id;
      this.username = username;
      this.password = password;
      this.role = role;
      if(authorities != null) this.setAuthorities(role);
      this.activated = true;
   }


   public User(String username, String password, String authorities) {
      this.username = username;
      this.password = password;
      this.role = authorities;
      if(authorities != null) this.setAuthorities(authorities);
      this.activated = true;
   }


   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }
   @Transient
   public boolean isActivated() {
      return activated;
   }

   public void setActivated(boolean activated) {
      this.activated = activated;
   }

   public void setRole(String role) {
      this.role = role;
      setAuthorities(role);
   }

   public String getRole() {
      return role;
   }

   public Set<Authority> getAuthorities() {
      return authorities;
   }

   public void setAuthorities(Set<Authority> authorities) {
      this.authorities = authorities;
   }

   public void setAuthorities(String authorities) {
      String[] roles = authorities.split(",");
      for(String role : roles) {
         this.authorities.add(new Authority("ROLE_" + role));
      }
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      User user = (User) o;
      return userId == user.userId &&
              activated == user.activated &&
              Objects.equals(username, user.username) &&
              Objects.equals(password, user.password) &&
              Objects.equals(authorities, user.authorities);
   }

   @Override
   public int hashCode() {
      return Objects.hash(userId, username, password, activated, authorities);
   }

   @Override
   public String toString() {
      return "User{" +
              "id=" + userId +
              ", username='" + username + '\'' +
              ", activated=" + activated +
              ", authorities=" + authorities +
              '}';
   }
}
