//Felipe Maciel Scalco
//RA: 25658388

public class NumeroNegativoException extends Exception implements ExceptionInterface {
    // Polimorfismo por sobreescrita
    public void showMessage(String field) {
        System.out.println("O " + field + " deve ser maior que 0.");
    }
}
