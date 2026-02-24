public class SalarioPeao {
    private double SalarioSemana;

    public double getSalarioSemana(){
        return SalarioSemana;
    }
    public void setSalarioSemana(double SalarioSemana){
        if(SalarioSemana < 0.0){
            throw new IllegalAccessException("Teu salario tem que ser maior que  >= 0.0");
        }
        this.SalarioSemana = SalarioSemana;
    }
}
