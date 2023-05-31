import org.junit.Test;
import static org.junit.Assert.*;

class Testcomprador {
    @Test
    public void testCompraExitosa() throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException {
        // Configuración de prueba
        Moneda m = new Moneda1000();  // Crea un objeto Moneda válido
        int cual = Expendedor.COCA;  // Define el tipo de producto a comprar
        Expendedor exp = new Expendedor(10, Expendedor.PrecioBebidas.PRECIO2, Expendedor.PrecioDulces.PRECIO2);  // Crea un objeto Expendedor válido
        // Crea una instancia de Comprador
        Comprador comprador = new Comprador(m, cual, exp);

        // Verificación de los resultados esperados
        // Asegúrate de adaptar estas afirmaciones a los detalles específicos de tu implementación
        assertEquals(500, comprador.cuantoVuelto());
        assertEquals("cocacola", comprador.queSacaste());
    }

}
