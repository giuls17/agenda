import java.util.ArrayList;

public class Agenda {
    private ArrayList<Appointment> appointments;

    public Agenda() {
        appointments = new ArrayList<>();
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void removeAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public Appointment findAppointment(String firstName, String lastName, String appointmentTime) {
        for (Appointment appt : appointments) {
            if (appt.getFirstName().equals(firstName) && appt.getLastName().equals(lastName) && appt.getAppointmentTime().equals(appointmentTime)) {
                return appt;
            }
        }
        return null;
    }

    public void updateAppointment(Appointment oldAppointment, Appointment newAppointment) {
        int index = appointments.indexOf(oldAppointment);
        if (index != -1) {
            appointments.set(index, newAppointment);
        }
    }
}
