package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.addCity(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(1).size());

        City city = new City("Regina", "SK");
        cityList.addCity(city);

        assertEquals(2, cityList.getCities(1).size());
        assertTrue(cityList.getCities(1).contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.addCity(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.addCity(city);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.addCity(city);

        assertEquals(0, city.compareTo(cityList.getCities(1).get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(1)));
    }

    /**
     * Here we are testing if our wish to delete a city that is absent in CityList is being denied perfectly.
     * assertTrue() function is used here to test the outcome.
     */

    @Test
    public void testDeleteCity(){
        CityList newCityList = new CityList();
        City newCity1 = new City("Balagonj","Sylhet");
        City newCity2 = new City("Gazipur","Dhaka");

        newCityList.addCity(newCity1);
        newCityList.addCity(newCity2);

        newCityList.deleteCity(newCity1);

        assertTrue(!newCityList.getCities(1).contains(newCity1));
    }

    /**
     * Here we are testing if the exception thrown when deleting a city that is not present in CityList is running.
     * assertThrows() function is used here to test the outcome.
     */

    @Test
    public void testDeleteCityException(){
        CityList newCityList = new CityList();
        City newCity1 = new City("Balagonj","Sylhet");
        City newCity2 = new City("Gazipur","Dhaka");

        newCityList.addCity(newCity1);
        newCityList.addCity(newCity2);

        newCityList.deleteCity(newCity1);

        assertThrows(IllegalArgumentException.class,()->{
            newCityList.deleteCity(newCity1);
        });
    }

    /**
     * Here we are testing if the getCityCount() method is working smoothly.
     * assertEquals() function is used here to test the outcome.
     */

    @Test
    public void testCityCount(){
        CityList newCityList = new CityList();
        City newCity1 = new City("Balagonj","Sylhet");
        City newCity2 = new City("Gazipur","Dhaka");

        newCityList.addCity(newCity1);
        newCityList.addCity(newCity2);

        int x = newCityList.getCityCount();

        assertEquals(2,x);

        newCityList.deleteCity(newCity1);

        x = newCityList.getCityCount();

        assertEquals(1,x);
    }

    /**
     * Here we are testing if the sort() method inside getCities() method is working accordingly.
     * assertEquals() function is used here to test the outcome.
     */

    @Test
    public void testCitySort(){
        CityList newCityList = new CityList();
        City newCity1 = new City("Balagonj","Sylhet");
        City newCity2 = new City("Gazipur","Dhaka");

        newCityList.addCity(newCity1);
        newCityList.addCity(newCity2);

        assertEquals(newCity1,newCityList.getCities(1).get(0));
        assertEquals(newCity1,newCityList.getCities(10).get(1));
    }
}
