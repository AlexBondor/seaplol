package ro.cineseuita.data.contract.entity.direct.components;

public enum DirectAcquisitionType {
    FURNIZARE(1),
    SERVICII(2),
    LUCRARI(3);

    private int numVal;

    DirectAcquisitionType(int numVal) {
        this.numVal = numVal;
    }

    public static DirectAcquisitionType fromVal(int val) {
        switch (val) {
            case 1:
                return FURNIZARE;
            case 2:
                return SERVICII;
            case 3:
                return LUCRARI;
            default:
                throw new RuntimeException("Direct acquisition type with id: " + val + " not mapped");
        }
    }

    public int getNumVal() {
        return numVal;
    }
}
