package com.example.citylist;

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

    /**
     * This returns a sorted list of cities either by city name or by province name
     * @return
     *      Return the sorted list of cities either by city name or by province name
     */
    public List<City> getCities(int param) {
        List<City> cityList = cities;
        if(param==1){
            Collections.sort(cityList, new Comparator<City>() {
                @Override
                public int compare(City city, City t1) {
                    return city.getCityName().compareTo(t1.getCityName());
                }
            });
        }
        else{
            Collections.sort(cityList, new Comparator<City>() {
                @Override
                public int compare(City city, City t1) {
                    return city.getProvinceName().compareTo(t1.getProvinceName());
                }
            });
        }
        return cityList;
    }

    /**
     * This deletes a city to the list if that city exists
     * @param city
     *      This is the city to delete
     */
    public void delete(City city){
        if(!cities.contains(city)){
            throw new IllegalArgumentException();
        }
        else{
            cities.remove(city);
        }
    }

    /**
     * This returns the number of cities
     * @return
     *      Return the number of cities
     */
    public int count(){
        return cities.size();
    }
}
