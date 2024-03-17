package controle_fluxo;

public class ParametrosInvalidosException extends Exception {
    
    public ParametrosInvalidosException() {
        super("Parâmetros inválidos! Por favor, informe valores numéricos em ordem crescente.");
    }

    public ParametrosInvalidosException(String message) {
        super(message);
    }
}
