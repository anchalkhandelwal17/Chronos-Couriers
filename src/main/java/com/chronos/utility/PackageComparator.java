package com.chronos.utility;

import com.chronos.model.Package;
import java.util.Comparator;

public class PackageComparator implements Comparator<Package> {
    @Override
    public int compare(Package p1, Package p2) {
        if (p1.getPriority() != p2.getPriority()) {
            return p1.getPriority() == Package.Priority.EXPRESS ? -1 : 1;
        }
        if (p1.getDeadline() != p2.getDeadline()) {
            return Long.compare(p1.getDeadline(), p2.getDeadline());
        }
        return Long.compare(p1.getOrderTime(), p2.getOrderTime());
    }
}
