package com.example.citylist;

/**
 * City class that contains city and province name
 */
public class City implements Comparable<City>{
    /**
     * city name
     */
    private final String city;
    /**
     * province name
     */
    private final String province;

    /**
     *  generate object of city class
     * @param city city name
     * @param province province name
     */
    public City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * getter
     * @return city name
     */
    String getCityName(){
        return this.city;
    }

    /**
     * getter for province name
     * @return province
     */
    String getProvinceName(){
        return this.province;
    }

    /**
     * check if two cities are totally equals or not
     * @param item to be compared with
     * @return true is both city and province are same
     */
    public boolean allEquals(City item){
        return city.equals(item.city) && province.equals(item.province);
    }

    @Override
    public int compareTo(City city) {
        return this.city.compareTo(city.getCityName());
    }
}
