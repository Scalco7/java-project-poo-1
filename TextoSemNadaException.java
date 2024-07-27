
public class TextoSemNadaException extends Exception implements ExceptionInterface {
    public void showMessage(String field) {
        System.out.println("O " + field + " e deve conter alguma coisa.");
    }
}
