package com.keyin.policecasesystem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PoliceStationTest {
    PoliceStation policeStation;
    PoliceCase policeCase;



    @BeforeEach
    public void setUp() {
        policeStation = new PoliceStation(1, "Central Station", "123 Main St", "555-1234");
        policeCase = new PoliceCase("001", "Theft", "Open");
    }
    @AfterEach
    public void tearDown() {
        policeStation = null;
        policeCase = null;
    }
    @Test
    public void testAddPoliceCase() {
        policeStation.addPoliceCase(policeCase);
        assertEquals(1, policeStation.getPoliceCases().size());
        assertEquals(policeCase, policeStation.getPoliceCases().get(0));
    }
    @Test
    void testAddPoliceCaseAddErrorNoCaseNumber(){
        policeCase.setCaseNumber(null);
        Assertions.assertThrows(NullPointerException.class, () -> {
            policeStation.addPoliceCase(policeCase);

        });

    }
    @Test
    void testAddPoliceCaseAddErrorNoCaseDescription(){
        policeCase.setDescription(null);
        Assertions.assertThrows(NullPointerException.class, () -> {
            policeStation.addPoliceCase(policeCase);

        });

    }

}

