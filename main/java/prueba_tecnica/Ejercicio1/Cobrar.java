package prueba_tecnica.Ejercicio1;

public class Cobrar implements Runnable{
    Tarjeta tarjeta;
    double monto;


    public Cobrar(Tarjeta tarjeta, double monto) {
        this.tarjeta = tarjeta;
        this.monto = monto;
    }

    @Override
    public void run() {
        tarjeta.devolverInformación();
        tarjeta.operacionEsValida(monto);
        tarjeta.tarjetaEsValida();
        tarjeta.esDistinta(tarjeta);
        tarjeta.devolverInfoDeTasa();
    }
}
