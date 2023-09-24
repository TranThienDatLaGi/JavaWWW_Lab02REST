package vn.edu.iuh.fit.enums;

public enum EmployeeStatus {
    WORKING(1), PAUSE(0), QUIT(-1);
    private final int code;
    EmployeeStatus(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
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
