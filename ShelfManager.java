package test;

import java.util.List;

public interface ShelfManager {

    Long getValidShelfByTemperature(String temp);

    List<Shelf> getAllShelves();

}
