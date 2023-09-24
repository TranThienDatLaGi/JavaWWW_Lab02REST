package vn.edu.iuh.fit.enums;

public enum ProductStatus {
    TRADING(1), PAUSE(0), RETIRE(-1);
    private final int code;

    public int getCode() {
        return code;
    }

    ProductStatus(int code) {
        this.code = code;
    }

    public static EmployeeStatus fromcode(int code) {
        for (EmployeeStatus status : EmployeeStatus.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid EmployeeStatus code: " + code);
    }
}
