class TestExpendedor{
    @Test
    public void testComprarBebida() throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException {
        Expendedor expendedor = new Expendedor(10, 500, 400);
        Moneda monedaSuficiente = new Moneda1000();
        Moneda monedaInsuficiente = new Moneda100();

        // Verificar que se pueda comprar una bebida cuando la moneda es suficiente
        Bebida bebida = expendedor.comprarBebida(monedaSuficiente, Expendedor.COCA);
        assertNotNull(bebida);  // Verificar que la bebida no sea nula

        // Verificar que no se pueda comprar una bebida cuando la moneda es insuficiente
        try {
            Bebida bebida2 = expendedor.comprarBebida(monedaInsuficiente, Expendedor.SPRITE);
            fail("PagoInsuficienteException no fue lanzada");  // Esperamos que lance una excepción
        } catch (PagoInsuficienteException e) {
            assertEquals("valor de moneda insuficiente", e.getMessage());
        }

        Expendedor expendedorvacio= new Expendedor(0,400,300);
        expendedorvacio.comprarBebida(monedaSuficiente,Expendedor.COCA);
    }

    @Test
    public void testComprarDulce() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Expendedor expendedor = new Expendedor(10, 500, 300);
        Moneda monedaSuficiente = new Moneda500();
        Moneda monedaInsuficiente = new Moneda100();

        // Verificar que se pueda comprar un dulce cuando la moneda es suficiente
        Dulce dulce = expendedor.comprarDulce(monedaSuficiente, Expendedor.SNICKERS);
        assertNotNull(dulce);  // Verificar que el dulce no sea nulo

        // Verificar que no se pueda comprar un dulce cuando la moneda es insuficiente
        try{
            Dulce dulce2 = expendedor.comprarDulce(monedaInsuficiente, Expendedor.SUPER8);
            fail("PagoInsuficienteException no fue lanzada");  // Esperamos que lance una excepción
            assertNull(dulce2);  // Verificar que el dulce sea nulo
        } catch (PagoInsuficienteException e) {
            assertEquals("valor de moneda insuficiente", e.getMessage());
        }


        // Verificar que no se pueda comprar un dulce si no hay disponibilidad
        Expendedor expendedorsindulce = new Expendedor(1, 500, 300);

        Dulce dulce3 = expendedorsindulce.comprarDulce(monedaSuficiente, Expendedor.SNICKERS);
        Dulce dulce4 = expendedorsindulce.comprarDulce(monedaSuficiente, Expendedor.SNICKERS);
        assertNull(dulce4);  // Verificar que el dulce sea nulo

    }

    @Test
    public void testGetVuelto() throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException {
        Expendedor expendedor = new Expendedor(10, 500, 300);
        Moneda monedaSuficiente = new Moneda1000();
        Moneda monedaInsuficiente = new Moneda100();

        // Verificar que se obtenga el vuelto correcto después de comprar una bebida
        // Recordar que el metodo getVuelto() solo devuelve monedas de 100 si hay vuelto disponible
        expendedor.comprarBebida(monedaSuficiente, Expendedor.COCA);
        Moneda vuelto = expendedor.getVuelto();
        assertNotNull(vuelto);  // Verificar que el vuelto no sea nulo
        assertEquals(100, vuelto.getValor());  // Verificar que el valor del vuelto sea el esperado


        // Verificar que se devuelva la misma moneda cuando no se ha pagado lo suficiente
        try {
        expendedor.comprarBebida(monedaInsuficiente, Expendedor.SPRITE);
        fail("PagoInsuficienteException no fue lanzada");  // Esperamos que lance una excepción
        } catch (PagoInsuficienteException e) {
            assertEquals("valor de moneda insuficiente", e.getMessage());
        }
        Moneda vuelto3 = expendedor.getVuelto();
        assertNotNull(vuelto3);
        assertEquals(100, vuelto.getValor());
    }

}
