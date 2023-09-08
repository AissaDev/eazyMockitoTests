package modele;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

public class TestAeroport {


    private Aeroport aeroport;



    @Before
    public void setAeroport() {
        this.aeroport = new AeroportImpl();
    }



    @Test
    public void testGoHomeAucunPassagerFievreux(){

        SystemeThermique systemeThermique;
        Collection<Passager> passagers;

        Passager passager1 = EasyMock.createMock(Passager.class);
        Passager passager2 = EasyMock.createMock(Passager.class);
        Passager passager3 = EasyMock.createMock(Passager.class);

        systemeThermique = EasyMock.createMock(SystemeThermique.class);
        EasyMock.expect(systemeThermique.detecter(passager1)).andReturn(false);
        EasyMock.expect(systemeThermique.detecter(passager2)).andReturn(false);
        EasyMock.expect(systemeThermique.detecter(passager3)).andReturn(false);

        EasyMock.replay(passager1,passager2,passager3,systemeThermique);


        this.aeroport.setSystemeThermique(systemeThermique);
        passagers = Arrays.asList(passager1,passager2,passager3);

        this.aeroport.setPassagers(passagers);

        Collection<Passager> passagersFievreux = this.aeroport.goBackHome();

        Assert.assertEquals(passagersFievreux.size(),0);

    }


    @Test
    public void testGoHome2PassagersFievreux(){

        SystemeThermique systemeThermique;
        Collection<Passager> passagers;

        Passager passager1 = EasyMock.createMock(Passager.class);
        Passager passager2 = EasyMock.createMock(Passager.class);
        Passager passager3 = EasyMock.createMock(Passager.class);

        systemeThermique = EasyMock.createMock(SystemeThermique.class);
        EasyMock.expect(systemeThermique.detecter(passager1)).andReturn(true);
        EasyMock.expect(systemeThermique.detecter(passager2)).andReturn(false);
        EasyMock.expect(systemeThermique.detecter(passager3)).andReturn(true);

        EasyMock.replay(passager1,passager2,passager3,systemeThermique);


        this.aeroport.setSystemeThermique(systemeThermique);
        passagers = Arrays.asList(passager1,passager2,passager3);

        this.aeroport.setPassagers(passagers);

        Collection<Passager> passagersFievreux = this.aeroport.goBackHome();

        Assert.assertEquals(passagersFievreux.size(),2);

    }



}
