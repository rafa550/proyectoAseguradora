import modelos.*;
import java.time.LocalDate;

public class pruebaV1 {
    public static void main(String[] args) {
        // PRUEBAS CLASES
        LocalDate fecha = LocalDate.of(2005, 6, 28);
        Provincia p = new Provincia("Sevilla", "41440");
        Direccion d1 = new Direccion(1, TipoVia.Calle, "Blas Infante",  7, null, "41440", "Lora del Río", p);

        Persona p1 = new Persona(1, "Rafa", "Tirado", "Heras","55555555Z", fecha, d1, SexoFM.Masculino, "España", "rafalintirado50@gmail.com", "666666666");
        Vehiculo v1 = new Vehiculo();
        Coche coc1 = new Coche(0, "Toyota", "Corolla", "5555NNN", LocalDate.of(2016, 5, 30), "Gris", p1, 4, TipoCombust.Gasolina, Traccion.Integral, false);
        Moto m1 = new Moto(0, "Honda", "Off-Road", "1111ZZZ", LocalDate.of(2018, 2, 5), "Azul", new Persona(), 5, false);
        Conductor con1 = new Conductor(1, "Pepe", "Lopez", "Dantas", "55522255A", LocalDate.of(2005,1,31), d1 ,SexoFM.Masculino, "España", "lilpeep@gmail.com", "622222222", LocalDate.of(2024, 8, 20), 0, 6 );



        System.out.println(p1); System.out.println(v1); System.out.println(coc1); System.out.println(m1); System.out.println(con1);
    }
}
