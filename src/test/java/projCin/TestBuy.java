package projCin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.SourceType;

<<<<<<< HEAD
import ComidaCompras.Buy;
=======
import projCin.Market.Buy;
>>>>>>> fa02de62c1e3e0b641e49b562f64a694cdf41b9b

import java.sql.SQLOutput;

public class TestBuy {

    private Buy buy = new Buy();

    @BeforeEach
    public void insertsTests() {
        Buy buy = new Buy();
    }

    @Test
    public void testBuyNothing() {
        
    }

    @Test
    public void testBuyTicketWithoutFood() {

    }

    @Test
    public void testBuyTicketWithFood() {

    }

    @Test
    public void testBuyFood() {

        int chooseOption = 2;

        buy.menu(chooseOption);

        Assertions.assertEquals(buy, buy);

    }

    @Test
    public void testBuyFoodInvalid() {

        int chooseOption = 5;

        Assertions.assertEquals("Opcao invalida. Retornando para o menu.\n", buy.menu(chooseOption));

    }

    @Test
    public void testGetFoodList() {

        int chooseOption = 2;

        buy.menu(chooseOption);

        
    }
}
