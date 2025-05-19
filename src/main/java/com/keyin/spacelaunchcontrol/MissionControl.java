package com.keyin.spacelaunchcontrol;

public class MissionControl {
    SpaceWeatherChecker spaceWeatherChecker;
    public MissionControl(SpaceWeatherChecker spaceWeatherChecker) {
        this.spaceWeatherChecker = spaceWeatherChecker;
    }


    public String launchMission(){
        if(spaceWeatherChecker.isSafeToLaunch()){
            return "Mission is a go!";
        } else {
            return "Mission is scrubbed due to weather conditions.";
        }
    }
}
