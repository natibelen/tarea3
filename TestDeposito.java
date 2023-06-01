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
    @Test
    void getBebida() {
        Deposito deposito = new Deposito();
        Bebida bebida = new CocaCola(1);

        deposito.addBebida(bebida);
        deposito.getBebida();

        //debe asegurarse que no retorna una bebida, ya que la saca
        assertEquals(null,deposito.getBebida());
    }

    @Test
    void getDulce() {
        Deposito deposito = new Deposito();
        Dulce dulce = new Snickers(1);

        deposito.addDulce(dulce);
        deposito.getDulce();

        //debe asegurarse que no retorna un dulce, ya que la saca
        assertEquals(null,deposito.getDulce());
    }

    @Test
    void getMoneda() {
        Deposito deposito = new Deposito();
        Moneda moneda = new Moneda1000();

        deposito.addMoneda(moneda);
        deposito.getMoneda();

        //debe asegurarse que no retorna una moneda, ya que la saca
        assertEquals(null,deposito.getMoneda());
    }
}

}
