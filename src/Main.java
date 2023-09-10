import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class CarService {
    private Map<String, Map<String, Integer>> services; //here Key for the map is carType and value will be the serviceType

    public CarService() {
        services = new HashMap<>();

        // Define service codes and prices for different car types
        Map<String, Integer> basicService = new HashMap<>(); //this Map will contain Service type and value will be the price for the service
        basicService.put("HATCHBACK", 2000);
        basicService.put("SEDAN", 2500);
        basicService.put("SUV", 3000);

        Map<String, Integer> engineFixing = new HashMap<>();
        engineFixing.put("HATCHBACK", 5000);
        engineFixing.put("SEDAN", 6000);
        engineFixing.put("SUV", 7000);

        Map<String, Integer> clutchFixing = new HashMap<>();
        clutchFixing.put("HATCHBACK", 4000);
        clutchFixing.put("SEDAN", 4500);
        clutchFixing.put("SUV", 5000);

        Map<String, Integer> gearFixing = new HashMap<>();
        gearFixing.put("HATCHBACK", 3500);
        gearFixing.put("SEDAN", 4000);
        gearFixing.put("SUV", 4500);

        Map<String, Integer> brakeFixing = new HashMap<>();
        brakeFixing.put("HATCHBACK", 3000);
        brakeFixing.put("SEDAN", 3500);
        brakeFixing.put("SUV", 4000);

        // Add all the services
        services.put("BS01", basicService);
        services.put("EF01", engineFixing);
        services.put("CF01", clutchFixing);
        services.put("GF01", gearFixing);
        services.put("BF01", brakeFixing);
        // Add more services here
    }

    public int calculateTotalBill(String carType, String[] serviceCodes) {
        int totalBill = 0;

        for (String code : serviceCodes) {
            if (services.containsKey(code)) {
                Map<String, Integer> servicePrices = services.get(code);
                if (servicePrices.containsKey(carType)) {
                    totalBill += servicePrices.get(carType);
                }
            }
        }

        if (totalBill > 10000) {
            System.out.println("Complimentary cleaning included");
        }

        return totalBill;
    }
}

public class Main {
    public static void main(String[] args) {
        CarService carService = new CarService();

        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter The Type of Car (Hatchback/Sedan/SUV):");
        String carType = sc.nextLine().toUpperCase();

        System.out.println("Please Enter Number of Services:");
        int serviceCount = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        String[] serviceCodes = new String[serviceCount];
        for (int i = 0; i < serviceCount; i++) {
            System.out.println("Please Enter code-" + (i + 1));
            serviceCodes[i] = sc.nextLine().toUpperCase();
        }

        int totalBill = carService.calculateTotalBill(carType, serviceCodes);
        System.out.println("Type of Car: " + carType);
        System.out.println("Service Codes: " + String.join(", ", serviceCodes));
        System.out.println("Total Bill: ₹" + totalBill);
    }
}
