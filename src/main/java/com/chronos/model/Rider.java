package com.chronos.model;

import java.util.ArrayList;
import java.util.List;

public class Rider {
    public enum Status {
        AVAILABLE,
        UNAVAILABLE,
        OFFLINE
    }

    private final String id;
    private double rating;
    private boolean canHandleFragile;
    private Status status;
    private List<String> packagesAssigned = new ArrayList<>();

    public Rider(String id, double rating, boolean canHandleFragile) {
        this.id = id;
        this.rating = rating;
        this.canHandleFragile = canHandleFragile;
        this.status = Status.AVAILABLE;
    }

    public String getId() {
        return id;
    }

    public double getRating() {
        return rating;
    }

    public boolean isCanHandleFragile() {
        return canHandleFragile;
    }

    public Status getStatus() {
        return status;
    }

    public List<String> getPackagesAssigned() {
        return packagesAssigned;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setCanHandleFragile(boolean canHandleFragile) {
        this.canHandleFragile = canHandleFragile;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setPackagesAssigned(List<String> packagesAssigned) {
        this.packagesAssigned = packagesAssigned;
    }
}
