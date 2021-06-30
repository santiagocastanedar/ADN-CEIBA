package co.com.ceiba.domain.entity;

import co.com.ceiba.domain.exception.WrongCylinderException;

import static co.com.ceiba.domain.utils.Constant.CYLINDER_MIN_REQUIERE;

public class Motorcycle extends Vehicle{

    private int Cylinder;

    public Motorcycle(String plate, String entryDate, int cylinder) {
        super(plate, entryDate);
        Cylinder = cylinder;
    }

    public int getCylinder() {
        return Cylinder;
    }

    public void setCylinder(int cylinder) {
        if(cylinder < CYLINDER_MIN_REQUIERE ){
            throw new WrongCylinderException();
        }
        Cylinder = cylinder;
    }
}
