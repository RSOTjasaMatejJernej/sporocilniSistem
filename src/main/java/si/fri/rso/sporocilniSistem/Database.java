
package si.fri.rso.sporocilniSistem;

import java.util.ArrayList;
import java.util.List;


public class Database {
    private static List<Sporocilo> sporocila = new ArrayList<>();

    public static List<Sporocilo> getSporocila() {
        Sporocilo cus = new Sporocilo();
        cus.setIdPrejemnik("1");
        cus.setIdPosiljatelj("2");
        cus.setSporocilo("Oj. Kako si kaj? Ali si trenutno na faxu?");
        cus.setDateTime("2017-12-12 12:28:01");
        sporocila.add(cus);

        return sporocila;
    }

    public static Sporocilo getSporociloPrejemnik(String idPrejemnik) {
        for (Sporocilo sporocilo : sporocila) {
            if (sporocilo.getIdPrejemnik().equals(idPrejemnik))
                return sporocilo;
        }

        return null;
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
