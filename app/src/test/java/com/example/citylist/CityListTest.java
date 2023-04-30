package com.example.citylist;

import org.junit.Test;
import org.junit.function.ThrowingRunnable;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }


    @Test
    public void testDelete(){
        CityList list = mockCityList();
        City city = new City("Pabna","Rahshahi");
        list.add(city);

        assertEquals(2,list.count());

        list.delete(city);

        assertEquals(1,list.count());

        assertTrue(!list.getCities().contains(city));
        //assertFalse(list.getCities().contains(city));

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
    public void testDeleteException(){
        CityList cityList = mockCityList();

        City city = new City("Pabna","Rahshahi");
        //cityList.add(city);

        Throwable throwable = assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
            @Override
            public void run() throws Throwable {
                cityList.delete(city);
            }
        });
        System.out.println(throwable != null ? throwable.getCause() : "Success");
    }

    @Test
    public void  testCount(){
        CityList cityList = mockCityList();

        assertEquals(1,cityList.count());

        City city = new City("Pabna","Rahshahi");
        cityList.add(city);

        assertEquals(2,cityList.count());

    }

    @Test
    public void testSort(){
        CityList cityList = new CityList();

        cityList.add(new City("Pabna","Aahshahi"));
        cityList.add(new City("Kushtia","Khulna"));

        cityList.add(new City("Magura","Khulna"));
        cityList.add(new City("Bogra","Rahshahi"));

        cityList.add(new City("Meherpur","Khulna"));


        //sort by city name
        List<City> sortedList = cityList.getCities();
        assertTrue(isSorted(cityList.getOrigCity(),sortedList,true));

//        for (City city : sortedList) {
//            System.out.printf("%s - %s\n",city.getCityName(),city.getProvinceName());
//        }

        //sort by province
        List<City> list = cityList.getCities(true);
        assertTrue(isSorted(cityList.getOrigCity(),list,false));
    }

    private boolean isSorted(List<City> oldList,List<City> newList, boolean byName){
        if(oldList.size() != newList.size()) return false;

        if(byName) Collections.sort(oldList);
        else oldList.sort(Comparator.comparing(City::getProvinceName));

        for(int i=0; i<oldList.size(); i++){
            if(!oldList.get(i).allEquals(newList.get(i))) return false;
        }
        return true;
    }


    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }
}
