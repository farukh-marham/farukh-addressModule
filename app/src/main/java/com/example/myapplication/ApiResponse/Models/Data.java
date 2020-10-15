package com.example.myapplication.ApiResponse.Models;

import java.io.Serializable;
import java.util.List;

public class Data implements Serializable {

    private List<Cities> cities;

    private List<UserAddress> user_address;

    private List<AreaOfCities> areas_of_cities;

    public List<Cities> getCities ()
    {
        return cities;
    }

    public void setCities (List<Cities> cities)
    {
        this.cities = cities;
    }

    public List<UserAddress> getUser_address ()
    {
        return user_address;
    }

    public void setUser_address (List<UserAddress> user_address)
    {
        this.user_address = user_address;
    }

    public List<AreaOfCities> getAreas_of_cities ()
    {
        return areas_of_cities;
    }

    public void setAreas_of_cities (List<AreaOfCities> areas_of_cities)
    {
        this.areas_of_cities = areas_of_cities;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [cities = "+cities+", user_address = "+user_address+", areas_of_cities = "+areas_of_cities+"]";
    }
}
