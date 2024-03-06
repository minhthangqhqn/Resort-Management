package model;

public class Room extends Facility {
    private String freeService;
    public Room(String serviceId, String serviceName, double usableArea, double rentalCost, int maxPeople, String rentalType, String freeService) {
        super(serviceId, serviceName, usableArea, rentalCost, maxPeople, rentalType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" +
                "freeService='" + freeService + '\'' +
                '}';
    }
}
