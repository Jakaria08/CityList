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
    public void addCity(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This method deletes a city from cityList.If the given city is absent in cityList then it also throws and exception.
     * @param givenCity
     *      The city to be deleted.
     */

    public void deleteCity(City givenCity){
        if(!cities.contains(givenCity))
            throw new IllegalArgumentException();

        else
            cities.remove(givenCity);
    }

    /**
     * This method returns total available city at the current moment in cityList.
     * @return
     */

    public int getCityCount(){
        return cities.size();
    }

    /**
     * This returns a sorted list of cities
     * @return
     *      Return the sorted list of cities
     */
    public List<City> getCities(int parity) {
        List<City> cityList = cities;

        if(parity==1)
            Collections.sort(cityList);

        else
            Collections.sort(cityList, new Comparator<City>() {
                @Override
                public int compare(City o1, City o2) {
                        return o1.getProvinceName().compareTo(o2.getProvinceName());
                }
            });

        return cityList;
    }
}
