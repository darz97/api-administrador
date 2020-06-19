package co.com.administrador.administradorhotel.exception;

public class UsuarioExiste extends RuntimeException {
    public UsuarioExiste(String message) {
        super(message);
    }
}
