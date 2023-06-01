import org.junit.Test;
import static org.junit.Assert.*;

class TestDeposito {

    @Test
    void testAddBebida() {
       Deposito deposito = new Deposito();
        Bebida bebida = new CocaCola(1);

        //deposito vacio
        assertNotEquals(bebida,deposito.getBebida());

        //deposito con bebida
        deposito.addBebida(bebida);
        assertEquals(bebida, deposito.getBebida());
    }

    @Test
    void testAddMoneda() {
        Deposito deposito = new Deposito();
        Moneda moneda = new Moneda1000();

        //moneda null
        assertNotEquals(moneda, deposito.getMoneda());

        //moneda
        deposito.addMoneda(moneda);
        assertEquals(moneda, deposito.getMoneda());
    }

    @Test
    void testAddDulce() {
        Deposito deposito = new Deposito();
        Dulce dulce = new Snickers(1);

        //deposito vacio
        assertNotEquals(dulce, deposito.getDulce());

        //deposito con dulce
        deposito.addDulce(dulce);
        assertEquals(dulce, deposito.getDulce());
    }

}
