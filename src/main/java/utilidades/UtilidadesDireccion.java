package utilidades;

import modelos.Provincia;

import java.util.*;

public class UtilidadesDireccion {
    public static boolean esCPValido(String cp) {
        boolean resultado = false;
        if (cp.length() != 5) { return false; }

        String cad1 = cp.substring(0, 2);
        String cad2 = cp.substring(2, cp.length());
        try {
            int cod1 = Integer.parseInt(cad1);
            int cod2 = Integer.parseInt(cad2);
            if (cod1 <= 52 && cod1 >0 && cod2 <= 999 && cod2 >= 0) {
                resultado = true;
            }
        } catch (NumberFormatException e) { resultado = false; }

        return resultado;
    }

    public static final Map<String, Provincia> PROVINCIAS;

    static {
        Map<String, Provincia> mapaProvincias = new HashMap<>();
        mapaProvincias.put("Álava", new Provincia("Álava", "01"));
        mapaProvincias.put("Albacete", new Provincia("Albacete", "02"));
        mapaProvincias.put("Alicante", new Provincia("Alicante", "03"));
        mapaProvincias.put("Almería", new Provincia("Almería", "04"));
        mapaProvincias.put("Ávila", new Provincia("Ávila", "05"));
        mapaProvincias.put("Badajoz", new Provincia("Badajoz", "06"));
        mapaProvincias.put("Islas Baleares", new Provincia("Islas Baleares", "07"));
        mapaProvincias.put("Barcelona", new Provincia("Barcelona", "08"));
        mapaProvincias.put("Burgos", new Provincia("Burgos", "09"));
        mapaProvincias.put("Cáceres", new Provincia("Cáceres", "10"));
        mapaProvincias.put("Cádiz", new Provincia("Cádiz", "11"));
        mapaProvincias.put("Castellón", new Provincia("Castellón", "12"));
        mapaProvincias.put("Ciudad Real", new Provincia("Ciudad Real", "13"));
        mapaProvincias.put("Córdoba", new Provincia("Córdoba", "14"));
        mapaProvincias.put("A Coruña", new Provincia("A Coruña", "15"));
        mapaProvincias.put("Cuenca", new Provincia("Cuenca", "16"));
        mapaProvincias.put("Girona", new Provincia("Girona", "17"));
        mapaProvincias.put("Granada", new Provincia("Granada", "18"));
        mapaProvincias.put("Guadalajara", new Provincia("Guadalajara", "19"));
        mapaProvincias.put("Guipúzcoa", new Provincia("Guipúzcoa", "20"));
        mapaProvincias.put("Huelva", new Provincia("Huelva", "21"));
        mapaProvincias.put("Huesca", new Provincia("Huesca", "22"));
        mapaProvincias.put("Jaén", new Provincia("Jaén", "23"));
        mapaProvincias.put("León", new Provincia("León", "24"));
        mapaProvincias.put("Lleida", new Provincia("Lleida", "25"));
        mapaProvincias.put("La Rioja", new Provincia("La Rioja", "26"));
        mapaProvincias.put("Lugo", new Provincia("Lugo", "27"));
        mapaProvincias.put("Madrid", new Provincia("Madrid", "28"));
        mapaProvincias.put("Málaga", new Provincia("Málaga", "29"));
        mapaProvincias.put("Murcia", new Provincia("Murcia", "30"));
        mapaProvincias.put("Navarra", new Provincia("Navarra", "31"));
        mapaProvincias.put("Ourense", new Provincia("Ourense", "32"));
        mapaProvincias.put("Asturias", new Provincia("Asturias", "33"));
        mapaProvincias.put("Palencia", new Provincia("Palencia", "34"));
        mapaProvincias.put("Las Palmas", new Provincia("Las Palmas", "35"));
        mapaProvincias.put("Pontevedra", new Provincia("Pontevedra", "36"));
        mapaProvincias.put("Salamanca", new Provincia("Salamanca", "37"));
        mapaProvincias.put("Santa Cruz de Tenerife", new Provincia("Santa Cruz de Tenerife", "38"));
        mapaProvincias.put("Cantabria", new Provincia("Cantabria", "39"));
        mapaProvincias.put("Segovia", new Provincia("Segovia", "40"));
        mapaProvincias.put("Sevilla", new Provincia("Sevilla", "41"));
        mapaProvincias.put("Soria", new Provincia("Soria", "42"));
        mapaProvincias.put("Tarragona", new Provincia("Tarragona", "43"));
        mapaProvincias.put("Teruel", new Provincia("Teruel", "44"));
        mapaProvincias.put("Toledo", new Provincia("Toledo", "45"));
        mapaProvincias.put("Valencia", new Provincia("Valencia", "46"));
        mapaProvincias.put("Valladolid", new Provincia("Valladolid", "47"));
        mapaProvincias.put("Vizcaya", new Provincia("Vizcaya", "48"));
        mapaProvincias.put("Zamora", new Provincia("Zamora", "49"));
        mapaProvincias.put("Zaragoza", new Provincia("Zaragoza", "50"));
        mapaProvincias.put("Ceuta", new Provincia("Ceuta", "51"));
        mapaProvincias.put("Melilla", new Provincia("Melilla", "52"));

        PROVINCIAS = Collections.unmodifiableMap(mapaProvincias);
    }

    public static boolean compruebaCodProvincia(String cp, String prov) {
        boolean resultado = false;
        for (Map.Entry<String, Provincia> entry : PROVINCIAS.entrySet()) {
            Provincia p = entry.getValue();
            if (p.getCodigo().equals(cp.substring(0, 2)) && p.getNombre().equals(prov)) {
                resultado = true;
                break;
            }
        }
        return resultado;
    }



}
