# Chronos Couriers Dispatch System

Chronos Couriers is a command-line based dispatch system
that prioritizes fast deliveries, assigns packages
to riders based on urgency and availability.

## 🚀 Features

* Priority-based dispatching (EXPRESS > STANDARD)
* Fragile item assigning to suitable riders
* Dynamic rider status updates and reassignment
* Simple CLI-based command execution


---

## 🏗️ Project Structure

```
chronos-couriers/
├── src/
│   ├── main/java/com/chronos/
│   │   ├── Main.java
│   │   ├── cli/CommandRunner.java
│   │   ├── model/Package.java
│   │   ├── model/Rider.java
│   │   ├── service/DispatchCenter.java
│   │   └── utility/PackageComparator.java
│   └── test/java/com/chronos/service/DispatchCenterTest.java
└── pom.xml
```

---

## 🛠️ Requirements

* Java 11+
* Maven (for build and run)

---

## 📦 Build & Run

### Step 1: Clone the Repository

```
git clone https://github.com/anchalkhandelwal17/Chronos-Couriers.git
cd Chronos-Couriers
```

### Step 2: Compile and Package

```
mvn clean package
```

### Step 3: Run the Application

```
java -cp target/chronos-couriers-1.0-SNAPSHOT.jar com.chronos.Main
```

---

## 🧪 Run Tests

```
mvn test
```

---

## 🧾 Supported Commands

| Command                                            | Description                             |
|----------------------------------------------------|-----------------------------------------|
| `PLACE_ORDER <id> <priority> <fragile> <deadline>` | Place a new package order               |
| `ADD_RIDER <id> <rating> <canHandleFragile>`       | Register a new rider                    |
| `UPDATE_RIDER - AVAILABLE, UNAVAILABLE, OFFLINE`   | Change rider status                     |                                            
| `ASSIGN_PACKAGES`                                  | Force re-check for package assignment   |                                             
| `COMPLETE_DELIVERY <packageId>`                    | Mark a package as delivered             |                                              
| `GET_STATUS <packageId or riderId>`                | View current status of package or rider |                                  
| `exit`                                             | Quit the application                    |                                             
---

## ✅ Sample Usage

```
> ADD_RIDER R1 4.8 true
> PLACE_ORDER P1 EXPRESS false 3
> ASSIGN_PACKAGES
> COMPLETE_DELIVERY P1
> GET_STATUS P1
```

---

## 📜 License

This project is for assessment purpose.

---

## 🧠 Author

Anchal Khandelwal
