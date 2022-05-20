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
        assertEquals(1, cityList.getCities('c').size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities('c').size());
        assertTrue(cityList.getCities('c').contains(city));
    }

    @Test
    public void testDelete() {
        CityList city_List = new CityList();
        City city1 = new City("Bogra", "Rajshahi");
        city_List.add(city1);
        city_List.delete(city1);
        assertTrue(!city_List.getCities('c').contains(city1));
        assertEquals(0, city_List.getCities('c').size());
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

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities('c').get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        assertEquals(0, city.compareTo(cityList.getCities('c').get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities('c').get(1)));
    }
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
