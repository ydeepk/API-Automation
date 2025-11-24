package models;

/**
 * Request model for creating a user.
 */
public class CreateUserRequest {

    private String name;
    private String job;

    public CreateUserRequest(String name, String job) {
        this.name = name;
        this.job = job;
    }

    /** Returns the user's name. */
    public String getName() {
        return name;
    }

    /** Returns the user's job. */
    public String getJob() {
        return job;
    }

    /** Sets the user's name. */
    public void setName(String name) {
        this.name = name;
    }

    /** Sets the user's job. */
    public void setJob(String job) {
        this.job = job;
    }
}
