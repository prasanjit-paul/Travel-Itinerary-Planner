import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class TravelPlannerGUI extends JFrame{
    private JTextField nameField;
    private JTextField descriptionField;
    private JTextArea itineraryArea;
    private LocalDate startDate;
    private LocalDate endDate;
    private Itinerary itinerary;

    public TravelPlannerGUI() {
        setTitle("Travel Itinerary Planner");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create components
        nameField = new JTextField(20);
        descriptionField = new JTextField(20);
        JButton addButton = new JButton("Add Destination");
        JButton showButton = new JButton("Show Itinerary");
        itineraryArea = new JTextArea();
        itineraryArea.setEditable(false);

        // Panel for user input
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Destination Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Description:"));
        inputPanel.add(descriptionField);
        inputPanel.add(addButton);

        // Panel for displaying itinerary
        JPanel displayPanel = new JPanel();
        displayPanel.add(showButton);

        // Add components to frame
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(itineraryArea), BorderLayout.CENTER);
        add(displayPanel, BorderLayout.SOUTH);

        // Initialize itinerary
        startDate = LocalDate.now();
        endDate = startDate.plusDays(7); // Example end date
        itinerary = new Itinerary(startDate, endDate);

        // Add button listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String description = descriptionField.getText();
                if (!name.isEmpty() && !description.isEmpty()) {
                    itinerary.addDestination(new Destination(name, description));
                    nameField.setText("");
                    descriptionField.setText("");
                    JOptionPane.showMessageDialog(null, "Destination added!");
                } else {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields.");
                }
            }
        });

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                itineraryArea.setText(itinerary.getItineraryDetails());
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TravelPlannerGUI gui = new TravelPlannerGUI();
            gui.setVisible(true);
        });
    }
}
