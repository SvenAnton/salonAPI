package salon.api.model;

public class OperationResult {
    private boolean isSuccess;
    private String message;
    private Integer id;

    public OperationResult(boolean isSuccess, String message, Integer id) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.id = id;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getMessage() {
        return message;
    }

    public Integer getId() {
        return id;
    }
}

