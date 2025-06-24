package com.chronos.service;

import com.chronos.model.Package;
import com.chronos.model.Rider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DispatchCenterTest {

    private DispatchCenter dispatchCenter;

    @BeforeEach
    void setUp() {
        dispatchCenter = new DispatchCenter();
    }

    @Test
    void testPlaceOrder() {
        Package pkg = new Package("P1", Package.Priority.EXPRESS, false, 3);
        dispatchCenter.placeOrder(pkg);
        dispatchCenter.getStatus("P1"); // Should print ASSIGNED or PENDING based on rider availability
    }

    @Test
    void testAddRider() {
        Rider rider = new Rider("R1", 4.5, true);
        dispatchCenter.addRider(rider);
        dispatchCenter.getStatus("R1"); // Should be AVAILABLE
    }

    @Test
    void testUpdateRiderStatus() {
        Rider rider = new Rider("R1", 4.5, true);
        dispatchCenter.addRider(rider);

        Package pkg = new Package("P1", Package.Priority.STANDARD, false, 3);
        dispatchCenter.placeOrder(pkg);

        dispatchCenter.updateRiderStatus("R1", Rider.Status.OFFLINE);
        dispatchCenter.getStatus("P1"); // Should be PENDING
    }

    @Test
    void testPackagesAssign() {
        Rider rider = new Rider("R1", 4.5, true);
        dispatchCenter.addRider(rider);

        Package pkg = new Package("P2", Package.Priority.EXPRESS, false, 2);
        dispatchCenter.placeOrder(pkg);

        dispatchCenter.getStatus("P2"); // Should be ASSIGNED
    }

    @Test
    void testCompleteDelivery() {
        Rider rider = new Rider("R1", 4.5, true);
        dispatchCenter.addRider(rider);

        Package pkg = new Package("P3", Package.Priority.STANDARD, false, 5);
        dispatchCenter.placeOrder(pkg);

        dispatchCenter.completeDelivery("P3");
        dispatchCenter.getStatus("P3"); // Should be DELIVERED
    }

}
