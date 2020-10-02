package ro.cineseuita.data.contract.direct.entity.components;

public enum DirectAcquisitionState {
    CONDITII_REFUZATE(3),
    CONDITII_NEACCEPTATE_LA_TERMEN(4),
    OFERTA_REFUZATA(6),
    OFERTA_ACCEPTATA(7),
    OFERTA_NEACCEPTATA_LA_TERMEN(8);

    private int numVal;

    DirectAcquisitionState(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
}
