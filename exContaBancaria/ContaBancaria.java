public class ContaBancaria {
    private double saldo;
    private double chequeEspecial;
    private double limiteChequeEspecial;
    private double taxaChequeEspecial;

    public ContaBancaria(double saldo, double chequeEspecial, double limiteChequeEspecial, double taxaChequeEspecial) {
        this.saldo = saldo;
        this.chequeEspecial = chequeEspecial;
        this.limiteChequeEspecial = limiteChequeEspecial;
        this.taxaChequeEspecial = taxaChequeEspecial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public double getTaxaChequeEspecial() {
        return taxaChequeEspecial;
    }

    public void setTaxaChequeEspecial(double taxaChequeEspecial) {
        this.taxaChequeEspecial = taxaChequeEspecial;
    }
    
    public double consultarSaldo(){
        return saldo;
    }

    public double consultarChequeEspecial(){
        return chequeEspecial;
    }

    public void depositar(double valor){
        double deposito = saldo + valor;
        setSaldo(deposito);
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
        } else if (valor <= saldo + chequeEspecial) {
            double diferenca = valor - saldo;
            saldo = 0;
            chequeEspecial -= diferenca;
            System.out.println("Saque realizado usando o cheque especial.");
        } else {
            System.out.println("Saldo insuficiente, incluindo o cheque especial.");
        }
        System.out.println("Saldo Atual: " + saldo);
        System.out.println("Cheque Especial Atual: " + chequeEspecial);
    }
    
    public void pagarBoleto(double valor){
        if (valor > saldo) {
            double pegaCheque = valor - saldo;
            setSaldo(0);
            setChequeEspecial(chequeEspecial - pegaCheque);
            System.out.println("Saldo Indisponivel! Usamos o cheque especial para pagar.");
            System.out.println("Saldo Atual: " + consultarSaldo());
            System.out.println("Cheque Especial Atual: " + consultarChequeEspecial());
        } else {
            saldo = saldo - valor;
            System.out.println("Boleto pago! Saldo Atual: " + consultarSaldo());
        }
    }
    public double calcularTaxaChequeEspecial() {
        double valorUsado = limiteChequeEspecial - chequeEspecial;
        return valorUsado * 0.20; // 20% de taxa sobre o valor usado
    }
    
    public boolean verificarUsoCheEspecial() {
        return chequeEspecial < limiteChequeEspecial;
    }
    

}
