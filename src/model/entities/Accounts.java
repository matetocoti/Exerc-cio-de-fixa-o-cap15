package model.entities;

//region IMPORTS
 import model.exceptions.DomainExceptions;
//endregion


public class Accounts {

    //region ATRIBUTOS
    private Integer number;
    private String holder;
    private Double balance;
    private Double withDrawLimit;
    //endregion

    //region CONSTRUTORES

    public Accounts(){

    }

    public Accounts(Integer number, String holder, Double balance, Double withDrawLimit) throws DomainExceptions{
        if(balance < 0){
            throw new DomainExceptions("Error in balance: The initial balance may not be negative");
        }
        this.number = number;//**Obs:Melhorar
        this.holder = holder;
        this.balance = balance;
        this.withDrawLimit = withDrawLimit;
    }

    //endregion

    //region GETTERS AND SETTERS

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getWithDrawLimit() {
        return withDrawLimit;
    }

    public void setWithDrawLimit(Double withDrawLimit) {
        this.withDrawLimit = withDrawLimit;
    }

    public Double getBalance(){
        return balance;
    }

    //OBS: O saldo da conta só pode ser alterado apartir dos Métodos de saque e deposito


    //endregion

    //region MÉTODOS

    public void deposit(Double amount) throws DomainExceptions {
        if(amount <= 0){
            throw new DomainExceptions("Deposit error: The amount should be more than zero");
        }
        this.balance+=amount;
    }

    public void withdraw(Double amount) throws DomainExceptions{
        if(withDrawLimit < amount){
            throw new DomainExceptions("Withdraw error: The amount exceeds withdraw limit");
        }
        if(balance <= amount) {
            throw new DomainExceptions("Withdraw error: Not enough balance");
        }

        this.balance -= amount;
    }

    //endregion

}
