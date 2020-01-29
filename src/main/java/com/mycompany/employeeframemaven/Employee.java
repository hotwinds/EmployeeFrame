/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.employeeframemaven;

/**
 *
 * @author Александр
 */
public class Employee {
    private String name;
    private String surname;
    private int age;
    private Gender gender;
    private String address;
    private double salary;
    
    public void Employee(String name, String surname, int age, Gender gender, String address, double salary){
    this.name = name;
    this.surname = surname;
    this.age = age;
    this.gender = gender;
    this.address = address;
    this.salary = salary;
    }
    public String getName(){
        return name;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public int getAge(){
    return age;
    }
    
    public Gender getGender(){
    return gender;
    }

    public String getAddress(){
    return address;
    }
    
    public double getSalary(){
    return salary;
    }
}
