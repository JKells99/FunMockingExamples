package com.keyin.spacelaunchcontrol;

public class SpaceWeatherChecker {

    // Think of this as a api call in a real world application
    // Mocking this is a good idea caise API calls get expensive if you are running this in testing and with customers
    public boolean isSafeToLaunch(){
        System.out.println("Checking space weather conditions...");
        return true;
    }
}
