package hayk.harutyunyan.shop.exeption;

public class ResourceNotFound extends RuntimeException {

    private static final long serialVersionUID = 234237190745766939L;

    public ResourceNotFound(String message) {
        super(message);
    }
}