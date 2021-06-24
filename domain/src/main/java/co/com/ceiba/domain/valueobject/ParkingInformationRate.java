package co.com.ceiba.domain.valueobject;

import co.com.ceiba.domain.exception.WrongRateException;

public class ParkingInformationRate {
    private double rateCarPerHour;
    private double rateCarPerDay;
    private double rateMotorcyclePerHour;
    private double rateMotorcyclePerDay;
    private int hourStartDay;
    private int hourEndDay;

    public ParkingInformationRate(double rateCarPerHour, double rateCarPerDay, double rateMotorcyclePerHour, double rateMotorcyclePerDay, int hourStartDay, int hourEndDay) {
        setRateCarPerDay(rateCarPerDay);
        setRateCarPerHour(rateCarPerHour);
        setRateMotorcyclePerDay(rateMotorcyclePerDay);
        setRateMotorcyclePerHour(rateMotorcyclePerHour);
        this.hourStartDay = hourStartDay;
        this.hourEndDay = hourEndDay;
    }

    public double getRateCarPerHour() {
        return rateCarPerHour;
    }

    public void setRateCarPerHour(double rateCarPerHour) {
        if(!validateRate(rateCarPerHour)){
            //TODO
            throw new WrongRateException();
        }
        this.rateCarPerHour = rateCarPerHour;
    }

    public double getRateCarPerDay() {
        return rateCarPerDay;
    }

    public void setRateCarPerDay(double rateCarPerDay) {
        if(!validateRate(rateCarPerDay)){
            //TODO
            throw new WrongRateException();
        }
        this.rateCarPerDay = rateCarPerDay;
    }

    public double getRateMotorcyclePerHour() {
        return rateMotorcyclePerHour;
    }

    public void setRateMotorcyclePerHour(double rateMotorcyclePerHour) {
        if(!validateRate(rateMotorcyclePerHour)){
            //TODO
            throw new WrongRateException();
        }
        this.rateMotorcyclePerHour = rateMotorcyclePerHour;
    }

    public double getRateMotorcyclePerDay() {
        return rateMotorcyclePerDay;
    }

    public void setRateMotorcyclePerDay(double rateMotorcyclePerDay) {
        if(!validateRate(rateMotorcyclePerDay)){
            //TODO
            throw new WrongRateException();
        }
        this.rateMotorcyclePerDay = rateMotorcyclePerDay;
    }

    public int getHourStartDay() {
        return hourStartDay;
    }

    public void setHourStartDay(int hourStartDay) {
        this.hourStartDay = hourStartDay;
    }

    public int getHourEndDay() {
        return hourEndDay;
    }

    public void setHourEndDay(int hourEndDay) {
        this.hourEndDay = hourEndDay;
    }

    private boolean validateRate(double rate){
        if(rate <= 0){
            return false;
        }else{
            return true;
        }

    }
}
