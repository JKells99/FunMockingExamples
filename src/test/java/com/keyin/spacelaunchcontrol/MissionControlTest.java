package com.keyin.spacelaunchcontrol;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // ✅ This is essential to make @Mock work
public class MissionControlTest {

    @Mock
    private SpaceWeatherChecker spaceWeatherChecker; // ✅ Mockito will inject this

    private MissionControl missionControl;

    @BeforeEach
    void setUp() {
        missionControl = new MissionControl(spaceWeatherChecker); // ✅ Inject the mock here
    }

    @Test
    void testLaunchFailure() {
        // Arrange
        when(spaceWeatherChecker.isSafeToLaunch()).thenReturn(false); // ✅ Tell the mock what to do

        // Act
        String result = missionControl.launchMission();

        // Assert
        assertEquals(result, "Mission is scrubbed due to weather conditions.");
    }

    @Test
    void testLaunchSuccess() {
        // Arrange
        when(spaceWeatherChecker.isSafeToLaunch()).thenReturn(true);

        // Act
        String result = missionControl.launchMission();

        // Assert
        assertEquals(result, "Mission is a go!");
    }
}
