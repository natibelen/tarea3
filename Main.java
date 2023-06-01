package org.example;



public static void main(String[] args) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException {
        Testcomprador test1 = new Testcomprador();
        test1.testCompraExitosa();

        TestExpendedor test2= new TestExpendedor();
        test2.testComprarBebida();
        test2.testComprarDulce();
        test2.testGetVuelto();

        TestDeposito test3= new TestDeposito();
        test3.testAddBebida();
        test3.testAddDulce();
        test3.testAddMoneda();

        Moneda100Test test4= new Moneda100Test();
        test4.getValorTest();

        Moneda1000Test test5= new Moneda1000Test();
        test5.getValor();

        Moneda1500Test test6= new Moneda1500Test();
        test6.getValor();

        Moneda500Test test7= new Moneda500Test();
        test7.getValor();
        
        TestCasonormal test8= new TestCasonormal();
        test8.compraexpende();

    }
}
