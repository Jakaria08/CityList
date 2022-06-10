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
     *
     * @param city This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This deletes a city from the city list if the city exists
     *
     * @param city This is the city to delete
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException();
        } else {
            cities.remove(city);
        }
    }


    /**
     * This returns a sorted list of cities
     *
     * @param par specifies whether the list will be sorted by city name or province name<br>
     *            'c' will imply sort by city name and 'p' will imply sort by province name
     * @return Return the sorted list of cities
     */
    public List<City> getCities(char par) {
        List<City> cityList = cities;
        if (par == 'c') {
            Collections.sort(cityList);
        } else if (par == 'p') {
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
     * This counts the number of cities that is in the <b>cities</b> list
     *
     * @return returns the size of the <q>cities</q>  list
     */
    public int count() {
        return cities.size();
    }
}


