package utilidades;

import modelos.Persona;
import modelos.Vehiculo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class UtilidadesVehiculo {
    public static boolean esMatriculaValida(String mat) {
        String regexNormal = "^[0-9]{4}[BCDFGHJKLMNPRSTVWXYZ]{3}$";

        String regexCGPC = "^CGPC[0-9]{4}$"; String regexCME = "^CME[0-9]{4}$";
        String regexCNP = "^CNP[0-9]{4}[A-Z]{0,2}$"; String regexE = "^E[0-9]{4}$";
        String regexEA = "^EA[0-9]{4}$"; String regexET = "^ET[0-9]{4}$";
        String regexFN = "^FN[0-9]{4}$"; String regexPGC = "^PGC[0-9]{4}[A-Z]{0,2}$";

        return Pattern.matches(regexNormal, mat) || Pattern.matches(regexCGPC, mat) ||
                Pattern.matches(regexCME, mat) || Pattern.matches(regexCNP, mat) ||
                Pattern.matches(regexE, mat) || Pattern.matches(regexEA, mat) ||
                Pattern.matches(regexET, mat) || Pattern.matches(regexFN, mat) ||
                Pattern.matches(regexPGC, mat);
    }

    public static boolean esMatriculaValida(Vehiculo veh) {
        String mat = veh.getMatricula();
        return esMatriculaValida(mat);
    }

    public static int calculaEdad(Vehiculo v){
        LocalDate fechaMat = v.getFechaMatriculacion();
        long edad = ChronoUnit.YEARS.between(fechaMat, LocalDate.now());
        return (int) edad;
    }

    public static List<Vehiculo> getVehiculos(List<Vehiculo> lV, Persona p) {
        List<Vehiculo> vehiculosDePersona = new ArrayList<>();
        for (Vehiculo vehiculo : lV) {
            if (vehiculo.getDuenyoActual().equals(p)) {
                vehiculosDePersona.add(vehiculo);
            }
        }
        return vehiculosDePersona;
    }

    public static boolean validaFechaMatriculacion(LocalDate fecha){
        return fecha.isBefore(LocalDate.now());
    }


}
