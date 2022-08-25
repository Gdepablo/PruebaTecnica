package prueba_tecnica.Ejercicio1.Marcas;

import java.time.LocalDate;

import prueba_tecnica.Ejercicio1.Cardholder;
import prueba_tecnica.Ejercicio1.Tarjeta;

public class NARA extends Tarjeta {

    public NARA(Cardholder duenio, Long numero, LocalDate fechaVencimiento) {
        super(duenio, numero, fechaVencimiento);
    }

    @Override
    public double calcularTasa() {
        return LocalDate.now().getMonthValue() * 0.5;
    }}
