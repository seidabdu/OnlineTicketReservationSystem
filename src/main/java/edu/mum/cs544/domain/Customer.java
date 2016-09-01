/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs544.domain;

import javax.validation.constraints.NotNull;

/**
 *
 * @author seidabdu
 */
public class Customer {
    @NotNull
     private String username;
    @NotNull
     private String password;
  public  Customer(){    
    
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
  
    
}
