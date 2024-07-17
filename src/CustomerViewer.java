import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerViewer extends JFrame implements ActionListener {
    private JLabel idLabel;
    private JLabel lastNameLabel;
    private final JLabel firstNameLabel;
    private JLabel phoneLabel;
    private JButton previousButton, nextButton;
    private int currentIndex = 0;

    // Sample data
    private final String[][] customers = {
            {"1", "Chenda", "Sovisal", "092888999"},
            {"2", "Kom", "Lina", "092008999"},
            {"3", "Chan", "Seyha", "092777666"}
    };

    public CustomerViewer() {
        // Create frame
        setTitle("Customer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 250); // Adjust size to match provided image
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Create labels
        idLabel = new JLabel();
        lastNameLabel = new JLabel();
        firstNameLabel = new JLabel();
        phoneLabel = new JLabel();

        // Create buttons
        previousButton = new JButton("Previous");
        nextButton = new JButton("Next");

        // Disable previous button initially
        previousButton.setEnabled(false);

        // Add action listeners
        previousButton.addActionListener(this);
        nextButton.addActionListener(this);

        // Layout components
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("ID:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(idLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Last Name:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(lastNameLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("First Name:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(firstNameLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Phone:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add(phoneLabel, gbc);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        buttonPanel.add(previousButton);
        buttonPanel.add(nextButton);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(buttonPanel, gbc);

        // Initialize with the first customer's data
        showCustomer(0);

        setVisible(true);
    }

    private void showCustomer(int index) {
        idLabel.setText(customers[index][0]);
        lastNameLabel.setText(customers[index][1]);
        firstNameLabel.setText(customers[index][2]);
        phoneLabel.setText(customers[index][3]);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == previousButton) {
            if (currentIndex > 0) {
                currentIndex--;
                showCustomer(currentIndex);
            }
        } else if (e.getSource() == nextButton) {
            if (currentIndex < customers.length - 1) {
                currentIndex++;
                showCustomer(currentIndex);
            }
        }

        // Enable/disable buttons based on current index
        previousButton.setEnabled(currentIndex > 0);
        nextButton.setEnabled(currentIndex < customers.length - 1);
    }

    public static void main(String[] args) {
        new CustomerViewer();
    }
}