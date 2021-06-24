package co.com.ceiba.domain.valueobject;

import co.com.ceiba.domain.exception.WrongCylinderException;

public class VehicleInformation{
    private String color;
    private String brand;
    private int cylinder;

    public VehicleInformation(int cylinder) {
        setCylinder(cylinder);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getCylinder() {
        return cylinder;
    }

    public void setCylinder(int cylinder) {
        if(cylinder == 0){
            throw new WrongCylinderException();
        }
        this.cylinder = cylinder;
    }
}