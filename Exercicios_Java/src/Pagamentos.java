public class Pagamentos {
    public PagamentoPeao(String nome,double comissionRate) {

    }//que porra é comissionRate?
}
 public double earnings(){
    return getcommmisionRate() * getGrossSales();
 }
 public class BaseBonusComissionPeao extends Pagamentos {
    private double baseSalary;
 }
 public BaseBonusComissionPeao(String nome, double baseSalario){
    super(nome,comissionRate);
    this.baseSalario = baseSalario;
 }
  @Override
 public double earnings(){
    return getSalarioBase() + super.earnings();
  }