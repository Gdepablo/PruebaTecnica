package prueba_tecnica.Ejercicio1;

import java.time.LocalDate;

public abstract class Tarjeta {
Cardholder duenio;
long numero;
LocalDate fechaVencimiento;
int saldo;
protected double limiteDeTasa = 0.05;

public Tarjeta(Cardholder duenio, long numero, LocalDate fechaVencimiento){
    this.duenio = duenio;
    this.numero = numero;
    this.fechaVencimiento = fechaVencimiento;
}

public void agregarGasto(double monto) {
    if(operacionEsValida(monto))
    saldo -= monto;
    else throw new ConsumoExcedidoException("Lo sentimos, no podemos validar esa operacion ya que ha excedido su limite de consumo");
}

public boolean operacionEsValida(double monto) {
return monto < 1000;
}

public boolean tarjetaEsValida() {
    return fechaVencimiento.isAfter(LocalDate.now()); 
}

public abstract double calcularTasa();

//Como dice que la tasa es hasta el 5% entonces introduzco una validacion para evitar que supere el 5%
public double validarTasa() {
    if (calcularTasa() < limiteDeTasa) {
        return calcularTasa();}
        else throw new TasaSuperadaException("La tasa calculada no puede superar el 5%");
    }

public void devolverInfoDeTasa() {
    System.out.println("El prestador de su tarjeta es " + this.getClass().getSimpleName() + "Y su tasa de prestacion es: " + calcularTasa());
}

//Como no se aclara, yo planteo que para que una tarjeta sea distinta a otra, debo tener distinto serial.
public boolean esDistinta(Tarjeta tarjeta) {
    return this.numero != tarjeta.numero;
}

public void devolverInformación() {
    System.out.println("El dueño de la tarjeta es " + duenio + "Su número de tarjeta corresponde a " + numero + "Con fecha de vencimiento: " + fechaVencimiento);
}

}

