package model.exceptions;

//Classe para tratar exceções|Subclasse de exception|Classe de exceções personalizadas
public class DomainExceptions extends Exception {

    //Só estou pegando o que preciso da super|Exception
    public DomainExceptions(String msg){super(msg);}

}
