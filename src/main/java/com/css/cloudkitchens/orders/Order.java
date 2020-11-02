package com.css.cloudkitchens.orders;

/**
 * Order
 *   {
 *       "id": "0ff534a7-a7c4-48ad-b6ec-7632e36af950",
 *       "name": "Cheese Pizza",
 *       "temp": "hot", // Preferred shelf storage temperature
 *       "shelfLife": 300, // Shelf wait max duration (seconds)
 *       "decayRate": 0.45 // Value deterioration modifier
 *   }
 */
public class Order {

    private String id;

    private String name;

    private String temp;

    private String shelfLife;

    private double decayRate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(String shelfLife) {
        this.shelfLife = shelfLife;
    }

    public double getDecayRate() {
        return decayRate;
    }

    public void setDecayRate(double decayRate) {
        this.decayRate = decayRate;
    }
}
