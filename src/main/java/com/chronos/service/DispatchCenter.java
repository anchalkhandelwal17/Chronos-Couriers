package com.chronos.service;

import com.chronos.model.Rider;
import com.chronos.model.Package;
import com.chronos.utility.PackageComparator;

import java.util.*;

public class DispatchCenter {

    private Map<String, Package> packages = new HashMap<>();
    private Map<String, Rider> riders = new HashMap<>();
    private PriorityQueue<Package> queue = new PriorityQueue<>(new PackageComparator());

    // Logic To Place order
    public void placeOrder(Package pkg) {
        packages.put(pkg.getId(), pkg);
        queue.add(pkg);
        assignPackages();
    }

    // Logic to assign packages to riders
    public void assignPackages() {
        Iterator<Package> it = queue.iterator();
        while (it.hasNext()) {
            Package pkg = it.next();
            Rider bestFit = findRiderForPackage(pkg);
            if (bestFit != null) {
                pkg.setAssignedRiderId(bestFit.getId());
                pkg.setStatus(Package.Status.ASSIGNED);
                bestFit.getPackagesAssigned().add(pkg.getId());
                it.remove();
            }
        }
    }

    // Logic to find a rider to assign a package
    private Rider findRiderForPackage(Package pkg) {
        for (Rider rider : riders.values()) {
            if (rider.getStatus() == Rider.Status.AVAILABLE &&
                    (!pkg.isFragile() || rider.isCanHandleFragile())) {
                return rider;
            }
        }
        return null;
    }

    // Logic to add rider
    public void addRider(Rider rider) {
        riders.put(rider.getId(), rider);
    }

    // Logic to update rider status
    public void updateRiderStatus(String id, Rider.Status status) {
        Rider rider = riders.get(id);
        if (rider != null) {
            rider.setStatus(status);
            if (status == Rider.Status.OFFLINE) {
                handleRiderOffline(rider);
            }
            assignPackages();
        }
    }

    // Logic to handle when the rider goes offline
    private void handleRiderOffline(Rider rider) {
        for (String pkgId : new ArrayList<>(rider.getPackagesAssigned())) {
            Package pkg = packages.get(pkgId);
            if (pkg != null && pkg.getStatus() == Package.Status.ASSIGNED) {
                pkg.setStatus(Package.Status.PENDING);
                pkg.setAssignedRiderId(null);
                queue.offer(pkg);
            }
        }
        rider.getPackagesAssigned().clear();
    }


    // Logic to simulate delivery completion
    public void completeDelivery(String packageId) {
        Package pkg = packages.get(packageId);
        if (pkg != null && pkg.getStatus() == Package.Status.ASSIGNED) {
            pkg.setStatus(Package.Status.DELIVERED);
            pkg.setDeliveryTime(System.currentTimeMillis());
        }
    }

    // Logic to get package or rider status
    public void getStatus(String id) {
        if (packages.containsKey(id)) {
            System.out.println(packages.get(id).getStatus());
        } else if (riders.containsKey(id)) {
            System.out.println(riders.get(id).getStatus());
        } else {
            System.out.println("ID not found");
        }
    }
}
