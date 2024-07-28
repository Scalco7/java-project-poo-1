
//Felipe Maciel Scalco
//RA: 25658388

public class TextoSemNadaException extends Exception implements ExceptionInterface {
    // Polimorfismo por sobreescrita
    public void showMessage(String field) {
        System.out.println("O " + field + " e deve conter alguma coisa.");
    }
}
