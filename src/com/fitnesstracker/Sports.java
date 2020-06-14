package com.fitnesstracker;

public abstract class Sports {

    public int initialCaloriesBurnt =0;
    public double rateIncrase;
    public static double oldHeartRate = 80;
    public int caloriesBurnt;
    public static double newHeartRate = 80;
    public int time;

    public void setTime(int time){this.time = time;}

    public void caloriesBurnt(int caloriesBurntSport){caloriesBurnt= initialCaloriesBurnt +time*caloriesBurntSport;}

    public void NewHeartRateCalculation(double heartRateIncreaseSport){
        newHeartRate = newHeartRate+(newHeartRate*time*heartRateIncreaseSport);
    }

    public void heartRateIncreaseCalculation(double oldHeartRate,double newHeartRate ){rateIncrase = newHeartRate-oldHeartRate;this.oldHeartRate = newHeartRate;}

    public double getRateIncraseCalculation(){return rateIncrase;}

    public double getNewHeartRateCalculation() { return newHeartRate;}

    public int getCaloriesBurnt(){return caloriesBurnt;}
}
