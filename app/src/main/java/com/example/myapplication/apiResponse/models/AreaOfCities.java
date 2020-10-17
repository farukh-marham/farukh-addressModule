package com.example.myapplication.apiResponse.models;

import java.io.Serializable;

public class AreaOfCities implements Serializable {

    private String shipping_charges;

    private String name;

    private String area_id;

    private String city_id;

    public String getShipping_charges ()
    {
        return shipping_charges;
    }

    public void setShipping_charges (String shipping_charges)
    {
        this.shipping_charges = shipping_charges;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getArea_id ()
    {
        return area_id;
    }

    public void setArea_id (String area_id)
    {
        this.area_id = area_id;
    }

    public String getCity_id ()
    {
        return city_id;
    }

    public void setCity_id (String city_id)
    {
        this.city_id = city_id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [shipping_charges = "+shipping_charges+", name = "+name+", area_id = "+area_id+", city_id = "+city_id+"]";
    }

}
