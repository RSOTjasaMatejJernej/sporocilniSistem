
package si.fri.rso.sporocilniSistem;

import java.util.ArrayList;
import java.util.List;


public class Database {
    private static List<Sporocilo> sporocila = new ArrayList<>();

    public static List<Sporocilo> getSporocila() {
        /*Sporocilo cus = new Sporocilo();
        cus.setIdPrejemnik("1");
        cus.setIdPosiljatelj("2");
        cus.setSporocilo("Oj. Kako si kaj? Ali si trenutno na faxu?");
        cus.setDateTime("2017-12-12 12:28:01");
        sporocila.add(cus);*/

        return sporocila;
    }

    public static List<Sporocilo> getPogovor(String idPosiljateljidPrejemnik) {
        List<Sporocilo> sporocilaReturn = new ArrayList<>();
        String[] split = idPosiljateljidPrejemnik.split("&");
        for (Sporocilo sporocilo : sporocila) {
            if (sporocilo.getIdPosiljatelj().equals(split[0]) && sporocilo.getIdPrejemnik().equals(split[1]))
                sporocilaReturn.add(sporocilo);
        }
        return sporocilaReturn;
    }

    public static Sporocilo getSporociloPosiljatelj(String idPosiljatelj) {
        for (Sporocilo sporocilo : sporocila) {
            if (sporocilo.getIdPosiljatelj().equals(idPosiljatelj))
                return sporocilo;
        }

        return null;
    }

    public static void addSporocilo(Sporocilo sporocilo) {
        sporocila.add(sporocilo);
    }

    public static void deleteSporocilo(String idPrejemnik) {
        for (Sporocilo sporocilo : sporocila) {
            if (sporocilo.getIdPrejemnik().equals(idPrejemnik)) {
                sporocila.remove(sporocilo);
                break;
            }
        }
    }
}
