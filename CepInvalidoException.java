public class CepInvalidoException extends Exception implements ExceptionInterface {
    public void showMessage() {
        showMessage("Cep");
    }

    public void showMessage(String field) {
        System.out.println("O " + field + " deve conter exatamente 8 caracteres");
    }
}
