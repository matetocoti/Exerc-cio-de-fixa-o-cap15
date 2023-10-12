package application;

//region IMPORTS

import java.util.Scanner;
import java.util.Locale;

import model.entities.Accounts;
import model.exceptions.DomainExceptions;

//endregion


public class Main {
    public static void main(String[] args) {

        //region INSTANCIANDO

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        //endregion

        //region ENTRADA E SAIDA DE DADOS


        try {
            System.out.println("Enter account data");

            System.out.print("Number:");
            int number = input.nextInt();
            input.nextLine();

            System.out.print("Holder:");
            String holder = input.nextLine();

            System.out.print("Initial balance:");
            double initialBalance = input.nextDouble();

            System.out.print("Withdraw limit:");
            double withdrawLimit = input.nextDouble();

            Accounts account = new Accounts(number ,holder ,initialBalance ,withdrawLimit );

            System.out.printf("%nEnter the amount for withdraw:");
            double withdraw = input.nextDouble();

            account.withdraw(withdraw);


            System.out.printf("New balance: $ %.2f",account.getBalance());


                //Exceção inesperada|Em tempo de execução
        }
        catch (RuntimeException runtimeException)
        {
            System.out.println("Unexpected Error");
        }
        catch (DomainExceptions domainExceptions)
        {
            System.out.println(domainExceptions.getMessage());
        }


        //endregion

        //region FINALIZANDO

        input.close();

        //endregion
    }
}