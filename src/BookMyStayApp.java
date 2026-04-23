import java.util.HashMap;
import java.util.Map;

class RoomInventory {

    private Map<String, Integer> roomAvailability;

    public RoomInventory() {
        roomAvailability = new HashMap<>();
        initializeInventory();
    }

    private void initializeInventory() {
        roomAvailability.put("Single Room", 5);
        roomAvailability.put("Double Room", 3);
        roomAvailability.put("Suite Room", 2);
    }

    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }

    public void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }
}

public class BookMyStayApp {
    public static void main(String[] args) {
        System.out.println("Book My Stay App");

        RoomInventory inventory = new RoomInventory();

        String hotelInfo = """
            Hotel Configuration Details:
            - Single Room: beds=1, size=250sqft, price/night=1500
            - Double Room: beds=2, size=400sqft, price/night=2500
            - Suite Room:  beds=3, size=750sqft, price/night=5000
            """;
        System.out.println(hotelInfo);

        displayInventory(inventory);

        System.out.println(">> Guest books 2 Single Rooms...");

        int currentSingle = inventory.getRoomAvailability().get("Single Room");
        inventory.updateAvailability("Single Room", currentSingle - 2);

        System.out.println(">> Guest books 1 Suite Room...");
        int currentSuite = inventory.getRoomAvailability().get("Suite Room");
        inventory.updateAvailability("Suite Room", currentSuite - 1);

        System.out.println("\n>> Post-Booking Inventory State:");
        displayInventory(inventory);

        System.out.println(">> Admin manually overrides Double Room availability to 5...");
        inventory.updateAvailability("Double Room", 5);

        displayInventory(inventory);
    }

    private static void displayInventory(RoomInventory inventory) {
        System.out.println("Current Availability Map");
        Map<String, Integer> currentAvailability = inventory.getRoomAvailability();
        for (Map.Entry<String, Integer> entry : currentAvailability.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " available");
        }
    }
}