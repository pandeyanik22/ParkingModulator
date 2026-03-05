package model;


public class ParkingSlot {
    private int slotId;
    private int levelId;
    private int slotNumber;

    public ParkingSlot(int slotId, int levelId, int slotNumber) {
        this.slotId = slotId;
        this.levelId = levelId;
        this.slotNumber = slotNumber;
    }

    public int getSlotId() { return slotId; }
    public int getLevelId() { return levelId; }
    public int getSlotNumber() { return slotNumber; }
}

