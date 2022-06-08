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


    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    /**
     * Create two cities city1 and city2
     * then add function is called for adding the cities
     * then delete function called for delete a city city1
     * then check that city1 is not exist in the list
     */
    @Test
    public void testDelete()
    {
        CityList cityList = new CityList();
        City city1 = new City("Gaibandha", "Rangpur");
        City city2 = new City("Shatkhira", "Khulna");
        cityList.add(city1);
        cityList.add(city2);

        cityList.delete(city1);
        assertTrue(!cityList.getCities().contains(city1));
    }

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
     * Create two cities city1 and city2
     * then add function is called for adding the cities
     * then delete function called for delete a city city1
     *
     * again want to delete city1 but exception called
     */
    @Test
    public void testDeleteException()
    {
        CityList cityList = new CityList();
        City city1 = new City("Gaibandha", "Rangpur");
        City city2 = new City("Shatkhira", "Khulna");
        cityList.add(city1);
        cityList.add(city2);

        cityList.delete(city1);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city1);
        });
    }

    /**
     * Create two cities city1 and city2
     * then add function is called for adding the cities
     * count the added city expected value is 2
     * after delete one city the expected value is 1
     */
    @Test
    public void testCunt()
    {
        CityList cityList = new CityList();
        City city1 = new City("Gaibandha", "Rangpur");
        City city2 = new City("Shatkhira", "Khulna");
        cityList.add(city1);
        cityList.add(city2);
        assertEquals(2, cityList.count());

        cityList.delete(city1);
        assertEquals(1, cityList.count());
    }

    /**
     * first add one city then check index 0
     * then add new city
     * where getCity function sort by city name
     */
    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    /**
     * Create two cities city1 and city2
     * then add function is called for adding the cities
     * firstly sort by city name, where city1 in index 0 and city2 in index 1
     * secondly sort by province name, where city1 in index 1 and city2 in index 0
     */
    @Test
    public void textSort()
    {
        CityList cityList = new CityList();
        City city1 = new City("Gaibandha", "Rangpur");
        cityList.add(city1);

        City city2 = new City("Shatkhira", "Khulna");
        cityList.add(city2);

        assertEquals(0,city1.compareTo(cityList.sortCities(1).get(0)));
        assertEquals(0,city2.compareTo(cityList.sortCities(1).get(1)));

        assertEquals(0,city1.compareTo(cityList.sortCities(2).get(1)));
        assertEquals(0,city2.compareTo(cityList.sortCities(2).get(0)));
    }
}
