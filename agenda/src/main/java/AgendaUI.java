import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgendaUI extends JFrame {
    private Agenda agenda;
    private JTable table;
    private DefaultTableModel tableModel;

    public AgendaUI() {
        agenda = new Agenda();

        tableModel = new DefaultTableModel(new Object[]{"Nome", "Cognome", "Orario"}, 0);
        table = new JTable(tableModel);

        JButton addButton = new JButton("Aggiungi appuntamento");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = JOptionPane.showInputDialog("Inserisci il nome:");
                String lastName = JOptionPane.showInputDialog("Inserisci il cognome:");
                String time = JOptionPane.showInputDialog("Inserisci l'orario dell'appuntamento:");
                Appointment appt = new Appointment(firstName, lastName, time);
                agenda.addAppointment(appt);
                tableModel.addRow(new Object[]{firstName, lastName, time});
            }
        });

        JButton removeButton = new JButton("Cancella appuntamento");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    String firstName = (String) tableModel.getValueAt(selectedRow, 0);
                    String lastName = (String) tableModel.getValueAt(selectedRow, 1);
                    String time = (String) tableModel.getValueAt(selectedRow, 2);
                    Appointment appt = agenda.findAppointment(firstName, lastName, time);
                    if (appt != null) {
                        agenda.removeAppointment(appt);
                        tableModel.removeRow(selectedRow);
                    }
                }
            }
        });

        JButton updateButton = new JButton("Modifica appuntamento");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    String firstName = (String) tableModel.getValueAt(selectedRow, 0);
                    String lastName = (String) tableModel.getValueAt(selectedRow, 1);
                    String time = (String) tableModel.getValueAt(selectedRow, 2);
                    Appointment oldAppointment = agenda.findAppointment(firstName, lastName, time);
                    if (oldAppointment != null) {
                        String newFirstName = JOptionPane.showInputDialog("Inserisci il nome:", firstName);
                        String newLastName = JOptionPane.showInputDialog("inserisci il cognome:", lastName);
                        String newTime = JOptionPane.showInputDialog("Inserisci l'orario dell'appuntamento:", time);
                        Appointment newAppointment = new Appointment(newFirstName, newLastName, newTime);
                        agenda.updateAppointment(oldAppointment, newAppointment);
                        tableModel.setValueAt(newFirstName, selectedRow, 0);
                        tableModel.setValueAt(newLastName, selectedRow, 1);
                        tableModel.setValueAt(newTime, selectedRow, 2);
                    }
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(addButton);
        panel.add(removeButton);
        panel.add(updateButton);

        add(scrollPane, "Center");
        add(panel, "South");

        setTitle("Agenda");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AgendaUI();
    }
}
