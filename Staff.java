public class Staff extends Account {
    private String staffId;
    private String department;

    public Staff(String username, String password, String email, String staffId, String department) {
        super(username, password, email);
        this.staffId = staffId;
        this.department = department;
    }

    // Getters and setters for the attributes specific to Staff
    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // Add any other methods specific to Staff
}