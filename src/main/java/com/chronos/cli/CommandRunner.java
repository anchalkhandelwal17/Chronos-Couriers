package com.chronos.cli;

import com.chronos.model.Package;
import com.chronos.model.Rider;
import com.chronos.service.DispatchCenter;

import java.util.Scanner;

public class CommandRunner {

    public static void run() {

        DispatchCenter dispatchCenter = new DispatchCenter();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Chronos Couriers...");
        System.out.println("Enter command or type 'exit' to quit.");

        while (true) {
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) break;
            if (input.isEmpty()) continue;

            String[] str = input.split(" ");
            String command = str[0].toUpperCase();

            try {
                switch (command) {
                    case "PLACE_ORDER":
                        Package pkg = new Package(
                                str[1],
                                Package.Priority.valueOf(str[2]),
                                Boolean.parseBoolean(str[3]),
                                Long.parseLong(str[4])
                        );
                        dispatchCenter.placeOrder(pkg);
                        break;

                    case "ADD_RIDER":
                        Rider rider = new Rider(
                                str[1],
                                Double.parseDouble(str[2]),
                                Boolean.parseBoolean(str[3])
                        );
                        dispatchCenter.addRider(rider);
                        break;

                    case "UPDATE_RIDER":
                        dispatchCenter.updateRiderStatus(str[1], Rider.Status.valueOf(str[2]));
                        break;

                    case "ASSIGN_PACKAGES":
                        dispatchCenter.assignPackages();
                        break;

                    case "COMPLETE_DELIVERY":
                        dispatchCenter.completeDelivery(str[1]);
                        break;

                    case "GET_STATUS":
                        dispatchCenter.getStatus(str[1]);
                        break;

                    default:
                        System.out.println("Unknown command.");
                }

            } catch (Exception e) {
                System.out.println("Invalid command or parameters: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
