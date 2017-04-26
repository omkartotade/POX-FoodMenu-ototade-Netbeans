/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse564.pox.foodmenu.ototade.netbeans.model;

/**
 *
 * @author Omkar Totade
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Omkar Totade
 */
@XmlRootElement (name = "FoodItemData")
public class FoodItems {
    
    private String currentElement;
    private String country;
    private int id;
    private String name;
    private String description;
    private String category;
    private float price;
    
    public FoodItems()
    {
        
    }
    
    public FoodItems (String country, int id, String name, String description, String category, float price)
    {
        this.country=country;
        this.id=id;
        this.name=name;
        this.description=description;
        this.category=category;
        this.price=price;
    }

    public String getCurrentElement() {
        return currentElement;
    }

    public void setCurrentElement(String currentElement) {
        this.currentElement = currentElement;
    }
    
    
    public String getCountry() {
        return country;
    }
    
    @XmlAttribute
    public void setCountry(String country) {
        this.country = country;
    }
    
    
    public int getId() {
        return id;
    }

    @XmlElement
    public void setId(int id) {
        this.id = id;
    }

    
    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    
    public String getDescription() {
        return description;
    }

    @XmlElement
    public void setDescription(String description) {
        this.description = description;
    }

    
    public String getCategory() {
        return category;
    }

    @XmlElement
    public void setCategory(String category) {
        this.category = category;
    }

    
    public float getPrice() {
        return price;
    }

    @XmlElement
    public void setPrice(float price) {
        this.price = price;
    }
    
    @Override
    public String toString ()
    {
        return new StringBuffer("Country:").append(this.country).append("ID:").append(this.id).append("Name:").append(this.name).append("Description:").append(this.description).append("Category:").append(this.category).append("Price:").append(this.price).toString();
    }
    
}
