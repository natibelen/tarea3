class TestDeposito {

    @Test
    void testAddBebida() {
        Deposito deposito = new Deposito();
        Bebida bebida = new CocaCola(1);

        deposito.addBebida(bebida);

        assertEquals(bebida, deposito.getBebida());
    }

    @Test
    void testAddMoneda() {
        Deposito deposito = new Deposito();
        Moneda moneda = new Moneda1000();

        deposito.addMoneda(moneda);

        assertEquals(moneda, deposito.getMoneda());
    }

    @Test
    void testAddDulce() {
        Deposito deposito = new Deposito();
        Dulce dulce = new Snickers(1);

        deposito.addDulce(dulce);

        assertEquals(dulce, deposito.getDulce());
    }

}
