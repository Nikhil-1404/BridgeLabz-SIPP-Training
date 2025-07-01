// Superclass Device
class Device {
    String deviceId;
    String status;

    // Constructor
    Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    // Method to display device status
    void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}

// Subclass Thermostat
class Thermostat extends Device {
    double temperatureSetting;

    // Constructor
    Thermostat(String deviceId, String status, double temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    // Overriding displayStatus() to include temperature setting
    @Override
    void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}

// Main class to test the hierarchy
public class SmartHomeSystem {
    public static void main(String[] args) {
        // Creating a Thermostat object
        Thermostat thermostat = new Thermostat("THERMO-001", "On", 24.5);

        // Displaying thermostat status
        System.out.println("=== Thermostat Device Status ===");
        thermostat.displayStatus();
    }
}
