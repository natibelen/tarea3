class Comprador{
    Moneda D;
    Moneda B;
    Bebida A;
    Dulce C;
    private String sonido;
    private int vuelto;
    public Comprador(Moneda m, int cual, Expendedor exp) throws PagoIncorrectoException {

        if(cual == exp.SPRITE || cual== exp.COCA) {
            A = exp.comprarBebida(m, cual);
        }
        else if(cual == exp.SNICKERS || cual== exp.SUPER8){
            C= exp.comprarDulce(m,cual);
        }
        else{
            A= exp.comprarBebida(m,cual);
        }

        int suma = 0;

        D = exp.getVuelto();

        if (D == m && m != null) {
            vuelto = D.getValor();
        } else if (D == m && m==null) {
            vuelto = 0;
        } else {
            while (D != null && D != m) {
                vuelto = D.getValor() + suma;
                suma = vuelto;
                D = exp.getVuelto();
            }
        }
        if (cual == exp.COCA && A != null) {
            sonido = A.beber();
        } else if (cual == exp.SPRITE && A != null) {
            sonido = A.beber();
        } else if (cual == exp.SNICKERS && C != null) {
            sonido = C.comer();
        } else if (cual == exp.SUPER8 && C != null) {
            sonido = C.comer();
        } else {
            sonido = null;
        }

    }

    public int cuantoVuelto(){
        return vuelto;
    }
    public String queSacaste(){
        return sonido;
    }
}
