public class NumeroNegativoException extends Exception implements ExceptionInterface {
    public void showMessage(String field) {
        System.out.println("O " + field + " deve ser maior que 0.");
    }
}
