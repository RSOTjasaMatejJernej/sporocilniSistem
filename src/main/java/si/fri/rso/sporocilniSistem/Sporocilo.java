/*
 *  Copyright (c) 2014-2017 Kumuluz and/or its affiliates
 *  and other contributors as indicated by the @author tags and
 *  the contributor list.
 *
 *  Licensed under the MIT License (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  https://opensource.org/licenses/MIT
 *
 *  The software is provided "AS IS", WITHOUT WARRANTY OF ANY KIND, express or
 *  implied, including but not limited to the warranties of merchantability,
 *  fitness for a particular purpose and noninfringement. in no event shall the
 *  authors or copyright holders be liable for any claim, damages or other
 *  liability, whether in an action of contract, tort or otherwise, arising from,
 *  out of or in connection with the software or the use or other dealings in the
 *  software. See the License for the specific language governing permissions and
 *  limitations under the License.
*/
package si.fri.rso.sporocilniSistem;

import java.io.Serializable;

public class Sporocilo {

    private String idPosiljatelj;
    private String idPrejemnik;
    private String sporocilo;
    private String dateTime;

    public String getIdPosiljatelj() {
        return idPosiljatelj;
    }

    public void setIdPosiljatelj(String id) {
        this.idPosiljatelj = id;
    }

    public String getIdPrejemnik() {
        return idPrejemnik;
    }

    public void setIdPrejemnik(String id) {
        this.idPrejemnik = id;
    }

    public String getSporocilo() {
        return sporocilo;
    }

    public void setSporocilo(String id) {
        this.sporocilo = id;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
