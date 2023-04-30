package com.example.citylist;

public class City implements Comparable<City>{
    private final String city;
    private final String province;

    public City(String city, String province){
        this.city = city;
        this.province = province;
    }

    String getCityName(){
        return this.city;
    }

    String getProvinceName(){
        return this.province;
    }

    /**
     *
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
