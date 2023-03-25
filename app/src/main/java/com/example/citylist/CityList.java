package com.example.citylist;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    //delete
    public void delete(City city){
        if(!cities.contains(city)){
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    //count

    public int count(){
        return cities.size();
    }


    //sort by province

    class SortByProvince implements Comparator<City>{
        public int compare(@NonNull City a,@NonNull City b)
        {
            return a.getProvinceName().compareTo(b.getProvinceName());
        }
    }
    /**
     * This returns a sorted list of cities
     * @return
     *      Return the sorted list of cities
     */
    public List<City> getCities(int flag) {
        List<City> cityList = cities;
        if(flag==1) {
            Collections.sort(cityList);
        } else if (flag==-1) {
            Collections.sort(cityList,new SortByProvince());
        }
        return cityList;
    }
}
