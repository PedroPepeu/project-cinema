package projCin.Exception;

public class VendasException extends Exception {
    private String erroUm;
    private String erroDois;
    private String erroTres;

    public VendasException(String erroUm, String erroDois, String erroTres) {
        this.erroUm = erroUm;
        this.erroDois = erroDois;
        this.erroTres = erroTres;
    }

    public String getErroUm() {
        return erroUm;
    }

    public String getErroDois() {
        return erroDois;
    }

    public String getErroTres() {
        return erroTres;
    }

}
