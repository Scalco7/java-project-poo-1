//Felipe Maciel Scalco
//RA: 25658388

public class CepInvalidoException extends Exception implements ExceptionInterface {
    public void showMessage() {
        showMessage("Cep");
    }

    // Polimorfismo por sobreescrita
    public void showMessage(String field) {
        System.out.println("O " + field + " deve conter exatamente 8 caracteres");
    }
}
