package com.keyin.spacelaunchcontrol;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) 
public class MissionControlTest {

    @Mock
    private SpaceWeatherChecker spaceWeatherChecker; 

    private MissionControl missionControl;

    // This method will run before each test to help avoid code duplication
    @BeforeEach
    void setUp() {
        missionControl = new MissionControl(spaceWeatherChecker); 
    }

    @Test
    void testLaunchFailure() {
        
        when(spaceWeatherChecker.isSafeToLaunch()).thenReturn(false);

       
        String result = missionControl.launchMission();

        
        assertEquals(result, "Mission is scrubbed due to weather conditions.");
    }

    @Test
    void testLaunchSuccess() {
        
        when(spaceWeatherChecker.isSafeToLaunch()).thenReturn(true);

        
        String result = missionControl.launchMission();

        
        assertEquals(result, "Mission is a go!");
    }
}
