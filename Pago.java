public abstract class Pago {
    private String numero;
    private String fechaVencimiento;
    private String cvv;

    public Pago(String numero, String fechaVencimiento, String cvv) {
        setNumero(numero);
        setFechaVencimiento(fechaVencimiento);
        setCvv(cvv);
    }

    public String getNumero() { return numero; }
    public void setNumero(String valor) {
        valor = valor.replaceAll("\\s", "");
        if (!valor.matches("\\d{16}"))
            throw new IllegalArgumentException("La tarjeta debe tener 16 digitos.");
        this.numero = valor;
    }

    public String getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(String valor) {
        valor = valor.trim();
        if (valor.length() != 5 || valor.charAt(2) != '/')
            throw new IllegalArgumentException("La fecha debe tener formato MM/AA.");
        String[] partes = valor.split("/");
        int mes = Integer.parseInt(partes[0]);
        if (mes < 1 || mes > 12)
            throw new IllegalArgumentException("El mes debe estar entre 01 y 12.");
        this.fechaVencimiento = valor;
    }

    public String getCvv() { return cvv; }
    public void setCvv(String valor) {
        valor = valor.trim();
        if (!valor.matches("\\d{3}"))
            throw new IllegalArgumentException("El CVV debe tener 3 digitos.");
        this.cvv = valor;
    }

    public abstract boolean procesarPago(double total);

    @Override
    public String toString() {
        return "Numero: ************" + numero.substring(12) +
               "\nFecha: " + fechaVencimiento + "\nCVV: ***";
    }
}
