package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    /**
     * This is a test method to add cities
     */

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(1).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(1).size());
        assertTrue(cityList.getCities(1).contains(city));
    }

    /**
     * This is a test method to throw exception for the city that already added
     */

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    /**
     * This is a test method to delete cities
     */

    @Test
    public void testDelete(){
        CityList cityList = new CityList();
        City city = new City("Chittagong", "Chittagong");
        City city1 = new City("Jashore", "Khulna");
        cityList.add(city);
        cityList.add(city1);

        cityList.delete(city);
        assertTrue(!cityList.getCities(1).contains(city));
    }

    /**
     * This is a test method to throw exception if a city is deleted that does not exist in the list
     */

    @Test
    public void testDeleteException(){
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);
        cityList.delete(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }

    /**
     * This is a test method to count number of cities
     */

    @Test
    public void testCount(){
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertEquals(1, cityList.count());

        City city1 = new City("Regina", "SK");
        cityList.add(city1);

        assertEquals(2, cityList.count());
    }

    /**
     * This is a test method that checks if the list is sorted either by cities or by provinces
     */

    @Test
    public void testGetCities() {
        CityList cityList = new CityList();
        City city = new City("Rangamati","Chittagong");
        City city1 = new City("Khulna","Khulna");
        cityList.add(city);

        assertEquals(0,city.compareTo(cityList.getCities(1).get(0)));

        cityList.add(city1);

        assertEquals(0,city1.compareTo(cityList.getCities(1).get(0)));
        assertEquals(0,city.compareTo(cityList.getCities(1).get(1)));

        assertEquals(0,city.compareTo(cityList.getCities(2).get(0)));
        assertEquals(0,city1.compareTo(cityList.getCities(2).get(1)));
    }
}
