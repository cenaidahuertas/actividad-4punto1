public abstract class Pago {

    private String numeroTarjeta;
    private String fechaVencimiento;
    private String cvv;

    public Pago(String numeroTarjeta, String fechaVencimiento, String cvv) {
        setNumeroTarjeta(numeroTarjeta);
        setFechaVencimiento(fechaVencimiento);
        setCvv(cvv);
    }

    #- Getters y Setters -------------
    
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }
    public void setNumeroTarjeta(String valor) {
        valor = valor.replaceAll("\\s+", "");
        if (!valor.matches("\\d{16}")) {
            throw new IllegalArgumentException("El número de tarjeta debe tener 16 dígitos");
        }
        this.numeroTarjeta = valor;
    }   

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }
    public void setFechaVencimiento(String valor) {
        valor = valor.trim();
        if (valor.length() != 5 || valor.charAt("\\d{2}/\\d{2}")
            throw new IllegalArgumentException("La fecha de vencimiento debe tener el formato MM/AA");
        }
        String [] partes = valor.split("/");
        if (!partes[0].matches("\\d{2}") || !partes[1].matches("\\d{2}")) {
            throw new IllegalArgumentException("La fecha de vencimiento debe tener el formato MM/AA");
        }
        int mes = Integer.parseInt(partes[0]);
        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("El mes de la fecha de vencimiento debe estar entre 01 y 12");
        }
        this.fechaVencimiento = valor;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String valor) {
        valor = valor.trim();
        if (!valor.matches("\\d{3}")) {
            throw new IllegalArgumentException("El CVV debe tener 3 dígitos");
        }
        this.cvv = valor;
    }

    # - Métodos abstractos -------------

    public abstract boolean procesarPago(double total);

    @Override
    public String toString() {
        return "Pago{" +
                "numeroTarjeta='" + numeroTarjeta + '\'' +
                ", fechaVencimiento='" + fechaVencimiento + '\'' +
                ", cvv='" + cvv + '\'' +
                '}';
        }
    

}
    
