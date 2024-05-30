public class Appointment extends Person {
    private String appointmentTime;

    public Appointment(String firstName, String lastName, String appointmentTime) {
        super(firstName, lastName);
        this.appointmentTime = appointmentTime;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    @Override
    public String toString() {
        return super.toString() + " at " + appointmentTime;
    }
}
