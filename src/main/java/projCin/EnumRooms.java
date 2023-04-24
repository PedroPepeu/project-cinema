package projCin;

public enum EnumRooms {
    SALA_COMUM("Sala comum", 1.0),
    SALA_3D("Sala 3D",1.2),
    SALA_XD("Sala XD",1.3),
    SALA_XD3D("Sala XD e 3D",1.4);

    private String salas;
    private double multiplicadorDasSalas;

    private EnumRooms(String salas, double multiplicadorDasSalas) {
        this.salas = salas;
        this.multiplicadorDasSalas = multiplicadorDasSalas;
    }

    public String getSalas() {
        return salas;
    }

    public double getmultiplicadorDasSalas() {
        return multiplicadorDasSalas;
    }

}
