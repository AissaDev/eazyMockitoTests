package modele;

import java.util.Collection;

public interface Aeroport {
    Collection<Passager> getPassagers();

    void setPassagers(Collection<Passager> passagers);

    SystemeThermique getSystemeThermique();

    void setSystemeThermique(SystemeThermique systemeThermique);


    Collection<Passager> goBackHome();
}
