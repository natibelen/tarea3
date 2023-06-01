import org.junit.Test;
import static org.junit.Assert.*;

class TestCasonormal{
    @Test
    public void compraexpende() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        //1000 y 400
        Expendedor exp = new Expendedor(2,Expendedor.PrecioBebidas.PRECIO2,Expendedor.PrecioDulces.PRECIO2);
        Moneda m = null;
        Comprador c=null;
        m = new Moneda1000();
        c = new Comprador(m,exp.SPRITE,exp);
        assertEquals(500, c.cuantoVuelto());
        assertEquals("sprite", c.queSacaste());
        m = new Moneda500();
        c = new Comprador(m,exp.SPRITE,exp);
        assertEquals(0, c.cuantoVuelto());
        assertEquals("sprite", c.queSacaste());
        m = new Moneda1000();
        c = new Comprador(m,exp.SPRITE,exp);
        assertEquals(null,c.queSacaste());
        assertEquals(1000,c.cuantoVuelto());
        m = new Moneda1000();
        c = new Comprador(m,exp.COCA,exp);
        assertEquals(500, c.cuantoVuelto());
        assertEquals("cocacola", c.queSacaste());
        m = new Moneda1000();
        c = new Comprador(m,exp.COCA,exp);
        assertEquals(500, c.cuantoVuelto());
        assertEquals("cocacola", c.queSacaste());
        m = new Moneda500();
        c = new Comprador(m,exp.COCA,exp);
        assertEquals(null,c.queSacaste());
        assertEquals(500,c.cuantoVuelto());
        m = new Moneda1000();
        c = new Comprador(m,exp.COCA,exp);
        assertEquals(null,c.queSacaste());
        assertEquals(1000,c.cuantoVuelto());
        m = new Moneda500();
        c = new Comprador(m,exp.SNICKERS,exp);
        assertEquals("snickers",c.queSacaste());
        assertEquals(100,c.cuantoVuelto());
        m = new Moneda100();
        try{
            c = new Comprador(m,exp.SNICKERS,exp);
            fail("PagoInsuficienteException no fue lanzada");  // Esperamos que lance una excepción
        }catch (PagoInsuficienteException e) {
            assertEquals("valor de moneda insuficiente", e.getMessage());
        }
        m = new Moneda1000();
        c = new Comprador(m,exp.SNICKERS,exp);
        assertEquals("snickers",c.queSacaste());
        assertEquals(600,c.cuantoVuelto());
        m = null;
        try {
            c = new Comprador(m, exp.SNICKERS, exp);
            fail("PagoIncorrectoException no fue lanzada");  // Esperamos que lance una excepción
        } catch (PagoIncorrectoException e) {
            assertEquals("valor de moneda incorrecto", e.getMessage());
        }
        m = new Moneda1000();
        c = new Comprador(m,exp.SNICKERS,exp);
        assertEquals(null,c.queSacaste());
        assertEquals(1000,c.cuantoVuelto());
        m = new Moneda100();
        try{
            c = new Comprador(m,exp.SUPER8,exp);
            fail("PagoInsuficienteException no fue lanzada");  // Esperamos que lance una excepción
        }catch (PagoInsuficienteException e) {
            assertEquals("valor de moneda insuficiente", e.getMessage());
        }
        m = new Moneda1000();
        c = new Comprador(m,exp.SUPER8,exp);
        assertEquals("super8",c.queSacaste());
        assertEquals(600,c.cuantoVuelto());
        m = new Moneda500();
        c = new Comprador(m,exp.SUPER8,exp);
        assertEquals("super8",c.queSacaste());
        assertEquals(100,c.cuantoVuelto());
        m = new Moneda500();
        c = new Comprador(m,exp.SUPER8,exp);
        assertEquals(null,c.queSacaste());
        assertEquals(500,c.cuantoVuelto());

    }

}
