package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private final List<City> cities = new ArrayList<>();

    /**
     * default constructor of CityList class
     */
    public CityList() {
    }

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
     * make a copy of original list then return
     * @return return copy of original list
     */
    public List<City> getOrigCity(){
        return new ArrayList<>(cities);
    }


    /**
     * This returns a sorted list of cities
     * @return
     *      Return the sorted list of cities
     */
    public List<City> getCities() {
//        List<City> cityList = cities;
        List<City> cityList = new ArrayList<>(cities);
        Collections.sort(cityList);
        return cityList;
    }


    /**
     * sort cities by city or province
     * @param sortByProvince true for sorting by province else false
     * @return sorted cities without affecting original list
     */
    public List<City> getCities(boolean sortByProvince){
        List<City> temp = new ArrayList<>(cities);
        Collections.sort(temp,new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                return sortByProvince ? o1.getProvinceName().compareTo(o2.getProvinceName()) : o1.getCityName().compareTo(o2.getCityName());
            }
        });

        return temp;
    }

    //----------------------------------------------------------------------------------------------------------------//

    /**
     * delete city if exists otherwise throws exception
     * @param city to be deleted
     */
    public void delete(City city){
        if(cities.contains(city)){
            cities.remove(city);
        }
        else{
            throw new IllegalArgumentException("City doesn't exist");
        }
    }

    /**
     * calculate total cities
     * @return total number of cities
     */
    public int count(){
        return cities.size();
    }

}
