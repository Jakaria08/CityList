package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;

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
        assertEquals(1, cityList.getCities(1).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(1).size());
        assertTrue(cityList.getCities(1).contains(city));
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

    //to check delete operation

    @Test
    public void testDelete()
    {
        CityList cityList=mockCityList();
        cityList.add(new City("Boyra","Khulna"));
        City city=new City("Kesobpur","Jessor");
        cityList.add(city);
        assertEquals(3,cityList.getCities(1).size());
        assertTrue(cityList.getCities(1).contains(city));
        cityList.delete(city);
        assertEquals(2,cityList.getCities(-1).size());
        assertTrue(!cityList.getCities(1).contains(city));
    }

    //to check delete exception operation

    @Test

    public void testDeleteException()
    {
        CityList cityList=new CityList();
        cityList.add(new City("Sitakundo","Chittagong"));
        City city=new City("Jaflong","Sylhet");
        assertThrows(IllegalArgumentException.class,() ->{
            cityList.delete(city);
        });
    }

    //to check count function operations

    @Test
    public void testcount()
    {
        CityList cityList=mockCityList();
        City city=new City("GEC","Chittagong");
        cityList.add(city);
        cityList.add(new City("Bonani","Dhaka"));
        assertEquals(3,cityList.count());
        cityList.delete(city);
        assertEquals(2,cityList.count());
    }

    //to check modified sorted function operations

    @Test

    public void testsort()
    {
        CityList cityList=new CityList();
        cityList.add(new City("Khalishpur","Khulna"));
        cityList.add(new City("Mirsorai","Chittagong"));
        List<City> order_by_city=cityList.getCities(1);

        assertEquals("Khalishpur",order_by_city.get(0).getCityName());
        assertEquals("Mirsorai",order_by_city.get(1).getCityName());

        List<City> order_by_province=cityList.getCities(-1);
        assertEquals("Mirsorai",order_by_province.get(0).getCityName());
        assertEquals("Khalishpur",order_by_province.get(1).getCityName());

    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities(1).get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(1)));
    }
}
