package com.chronos.model;

public class Package {

    public enum Priority {
        EXPRESS,
        STANDARD
    }

    public enum Status {
        PENDING,
        ASSIGNED,
        PICKED,
        DELIVERED
    }

    private final String id;
    private Priority priority;
    private boolean fragile;
    private long orderTime;
    private long deadline;
    private Status status;
    private long pickupTime;
    private long deliveryTime;
    private String assignedRiderId;

    public Package(String id, Priority priority, boolean fragile, long orderTime, long deadline) {
        this.id = id;
        this.priority = priority;
        this.fragile = fragile;
        this.orderTime = orderTime;
        this.deadline = deadline;
        this.status = Status.PENDING;
        this.pickupTime = -1;
        this.deliveryTime = -1;
        this.assignedRiderId = null;
    }

    public String getId() {
        return id;
    }

    public Priority getPriority() {
        return priority;
    }

    public boolean isFragile() {
        return fragile;
    }

    public long getOrderTime() {
        return orderTime;
    }

    public long getDeadline() {
        return deadline;
    }

    public Status getStatus() {
        return status;
    }

    public long getPickupTime() {
        return pickupTime;
    }

    public long getDeliveryTime() {
        return deliveryTime;
    }

    public String getAssignedRiderId() {
        return assignedRiderId;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setFragile(boolean fragile) {
        this.fragile = fragile;
    }

    public void setOrderTime(long orderTime) {
        this.orderTime = orderTime;
    }

    public void setDeadline(long deadline) {
        this.deadline = deadline;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setPickupTime(long pickupTime) {
        this.pickupTime = pickupTime;
    }

    public void setDeliveryTime(long deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public void setAssignedRiderId(String assignedRiderId) {
        this.assignedRiderId = assignedRiderId;
    }
}
