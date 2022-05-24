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
     * Tests if the method <q>add</q> is adding cities to the cityList
     */
    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities('c').size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities('c').size());
        assertTrue(cityList.getCities('c').contains(city));
    }
    /**
     * Tests if the method <q>delete</q> is deleting cities from the cityList
     */
    @Test
    public void testDelete() {
        CityList city_List = new CityList();
        City city1 = new City("Bogra", "Rajshahi");
        city_List.add(city1);
        city_List.delete(city1);
        assertTrue(!city_List.getCities('c').contains(city1));
        assertEquals(0, city_List.getCities('c').size());
    }
    /**
     * Tests if the  method <q>add</q>  is throwing an exception when a city is already in the cityList
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
     * Tests if the  method <q>delete</q>  is throwing an exception when trying to delete a city which is not in the cityList
     */
    @Test
    public void testDeleteException() {
        CityList city_List = new CityList();
        City city1 = mockCity();
        city_List.add(city1);
        city_List.delete(city1);
        assertThrows(IllegalArgumentException.class, () -> {
            city_List.delete(city1);
        });
    }
    /**
     * Tests if the method <q>getCities</q> is working correctly or not
     */
    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities('c').get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        assertEquals(0, city.compareTo(cityList.getCities('c').get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities('c').get(1)));
    }
    /**
     * Tests if the method <q>getCities</q> is returning a sorted list of cities.It also tests whether sort by city name and sort by province name is working or not.
     */
    @Test
    public void testSort() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities('c').get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities('p').get(1)));
        assertEquals(0, mockCity().compareTo(cityList.getCities('p').get(0)));
        assertEquals(0, city.compareTo(cityList.getCities('c').get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities('c').get(1)));
    }
    /**
     * Tests if the method <q>count</q> counting the number of cities in the cityList correctly
     */
    @Test
    public void testCount(){
        CityList cityList=new CityList();
        City city1=new City("NYC","NY");
        cityList.add(city1);
        assertEquals(1,cityList.count());
        cityList.delete(city1);
        assertEquals(0,cityList.count());
    }
}
