class Expendedor {
    Moneda B;
    private Deposito coca;
    private Deposito sprite;
    private Deposito monVu;
    private Deposito monVu100;

    private Deposito super8;

    private Deposito snickers;

    private int num;
    private int n1 = 1, n2 = 11, n3=111, n4=1111;

    private int aux,cual,j=0,j2=0,j3=0,j4=0;
    public static final int COCA = 1;
    public static final int SPRITE = 2;

    public static final int SUPER8=3;

    public static final int SNICKERS=4;

    public enum PrecioBebidas {
        PRECIO1(1000), PRECIO2(500), PRECIO3(600);

        private int precio;

        PrecioBebidas(int precio) {
            this.precio = precio;
        }

        public int getPrecio() {
            return precio;
        }
    }

    // Enumeración para los precios de los dulces
    public enum PrecioDulces {
        PRECIO1(500), PRECIO2(400), PRECIO3(600);

        private int precio;

        PrecioDulces(int precio) {
            this.precio = precio;
        }

        public int getPrecio() {
            return precio;
        }
    }


    private PrecioBebidas precioBebidas;
    private PrecioDulces precioDulces;
    public Expendedor(int num, PrecioBebidas precioBebidas,PrecioDulces precioDulces) {
        coca = new Deposito();
        sprite = new Deposito();
        monVu100 = new Deposito();
        monVu = new Deposito();
        snickers= new Deposito();
        super8= new Deposito();

        this.precioBebidas= precioBebidas;
        this.precioDulces=precioDulces;
        this.num=num;

        for (int i = 0; i < num; i++) {
            sprite.addBebida(new Sprite(n2));
            n2++;
        }
        for (int i = 0; i < num; i++) {
            coca.addBebida(new CocaCola(n1));
            n1++;
        }

        for (int i = 0; i < num; i++) {
            super8.addDulce(new Super8(n3));
            n3++;
        }

        for (int i = 0; i < num; i++) {
            snickers.addDulce(new Snickers(n4));
            n4++;
        }

        for (int i = 0; i < 1000; i++) {
            monVu100.addMoneda(new Moneda100());
        }
    }

    public Bebida comprarBebida(Moneda m, int cual) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException {
        this.cual=cual;
        if(m!=null) {
            aux = m.getValor() - precioBebidas.getPrecio();
            monVu.addFirstMoneda(m);
            B = m;

            if (cual == COCA && coca != null && aux >= 0) {
               j++;
               return coca.getBebida();
            } else if (cual == SPRITE && sprite != null && aux >= 0) {
                j2++;
                return sprite.getBebida();
            } else if(cual==COCA && coca==null && aux>=0) {
                NoHayProductoException p= new NoHayProductoException("no hay bebida");
                throw p;
            }  else if(cual==SPRITE && sprite==null && aux>=0) {
                NoHayProductoException p= new NoHayProductoException("no hay bebida");
                throw p;
            } else{
                PagoInsuficienteException p= new PagoInsuficienteException("valor de moneda insuficiente");
                throw p;
            }
        }
        else{ // bebida null pagoincorrectoexcepcion
            PagoIncorrectoException p= new PagoIncorrectoException("valor de moneda incorrecto");
                throw p;
            //return ((Bebida) null);
        }
    }

        public Dulce comprarDulce(Moneda m, int cualdulce) throws PagoInsuficienteException, PagoIncorrectoException, NoHayProductoException {
            this.cual = cualdulce;
            if (m!= null) {
                aux = m.getValor() - precioDulces.getPrecio();
                monVu.addFirstMoneda(m);
                B = m;

                if (cual == SNICKERS && snickers != null && aux >= 0) {
                    j3++;
                    return snickers.getDulce();
                } else if (cual == SUPER8 && super8 != null && aux >= 0) {
                    j4++;
                    return super8.getDulce();
                } else if(cual== SNICKERS && snickers==null){ //aqui nohayproductoexceptiom
                    NoHayProductoException p= new NoHayProductoException("no hay dulce");
                    throw p;
                } else if(cual==SUPER8 && super8==null){ //aqui nohayproductoexceptiom
                    NoHayProductoException p= new NoHayProductoException("no hay dulce");
                    throw p;
                } else {
                    PagoInsuficienteException p= new PagoInsuficienteException("valor de moneda insuficiente");
                    throw p;
                }
            }
            else{
                PagoIncorrectoException p= new PagoIncorrectoException("valor de moneda incorrecto");
                throw p;
            }
        }

    public Moneda getVuelto(){
        if(monVu!=null ) {
            if (aux > 0 && cual == COCA && monVu100!=null && j<=num ) {
                Moneda B;
                B = monVu100.getMoneda();
                aux = aux - B.getValor();
                return B;
            } else if (aux > 0 && cual == SPRITE && monVu100!=null && j2<=num) {
                Moneda B;
                B = monVu100.getMoneda();
                aux = aux - B.getValor();
                return B;
            }
            else if (aux > 0 && cual == SNICKERS && monVu100!=null && j3<=num ) {
                Moneda B;
                B = monVu100.getMoneda();
                aux = aux - B.getValor();
                return B;
            } else if (aux > 0 && cual == SUPER8 && monVu100!=null && j4<=num) {
                Moneda B;
                B = monVu100.getMoneda();
                aux = aux - B.getValor();
                return B;
            }  else if (aux == 0 && cual == COCA && j<=num) {
                return null;
            } else if (aux == 0 && cual == SPRITE && j2<=num) {
                return null;
            } else if (aux == 0 && cual == SNICKERS && j3<=num) {
                return null;
            } else if (aux == 0 && cual == SUPER8 && j4<=num) {
                return null;
            } else if(aux<0){
                return monVu.getMoneda();
            }
            else{
                return monVu.getMoneda();
            }
        }
        else{
            return null;
        }
    }
}
