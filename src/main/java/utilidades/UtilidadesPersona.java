package utilidades;

import modelos.Persona;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class UtilidadesPersona {
    // COMPROBACIÓN
    public static boolean esNIFValido(String nif) {

        Map<Integer, Character> letrasNIF = new HashMap<>();
        letrasNIF.put(0, 'T');letrasNIF.put(1, 'R');letrasNIF.put(2, 'W');
        letrasNIF.put(3, 'A');letrasNIF.put(4, 'G');letrasNIF.put(5, 'M');
        letrasNIF.put(6, 'Y');letrasNIF.put(7, 'F');letrasNIF.put(8, 'P');
        letrasNIF.put(9, 'D');letrasNIF.put(10, 'X');letrasNIF.put(11, 'B');
        letrasNIF.put(12, 'N');letrasNIF.put(13, 'J');letrasNIF.put(14, 'Z');
        letrasNIF.put(15, 'S');letrasNIF.put(16, 'Q');letrasNIF.put(17, 'V');
        letrasNIF.put(18, 'H');letrasNIF.put(19, 'L');letrasNIF.put(20, 'C');
        letrasNIF.put(21, 'K');letrasNIF.put(22, 'E');

        String regexNIF = "^\\d{8}[A-Z]$";
        String regexNIE = "^[XYZ]\\d{7}[A-Z]$";

        String nums = nif.substring(0,8);
        char letra = nif.charAt(8);

        boolean NIFValido = false;

        if (nif == null || nif.length() != 9) { return false; }

        if (nif.matches(regexNIE)) {
            char primeraletra = nif.charAt(0);
            switch (primeraletra) {
                case 'X': nums = "0" + nif.substring(1,8); break;
                case 'Y': nums = "1" + nif.substring(1,8); break;
                case 'Z': nums = "2" + nif.substring(1,8); break;
            }
        }

        if (nif.matches(regexNIF) || nif.matches(regexNIE)) {
            try {
                int digitos = Integer.parseInt(nums);
                int resto = digitos % 23;
                char c = letrasNIF.get(resto);

                NIFValido = c == letra;
            } catch (NumberFormatException e) { NIFValido = false; }
        }
        return NIFValido;
    }

    public static boolean esNIFValido(Persona p) {
        String nif = p.getNif();
        return esNIFValido(nif);
    }

    public static int getEdad(Persona p) {
        LocalDate fechaNac = p.getFechaNacimiento();
        long edad = ChronoUnit.YEARS.between(fechaNac, LocalDate.now());
        return (int) edad;
    }

    public static int getEdad(LocalDate fN) {
        long edad = ChronoUnit.YEARS.between(fN, LocalDate.now());
        return (int) edad;
    }

    public static boolean esMayorEdad(Persona p) {
        boolean mayorEdad = false;
        if (getEdad(p) > 18 ) { mayorEdad = true; }
        return mayorEdad;
    }

    public static boolean esMayorEdad(int edad) {
        boolean mayorEdad = false;
        if (edad > 18 ) { mayorEdad = true; }
        return mayorEdad;
    }

    public static boolean esMenor25(Persona p) {
        boolean menor25 = false;
        if (esMayorEdad(p) && getEdad(p) < 25 ) { menor25 = true; }
        return menor25;
    }

}
