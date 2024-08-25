import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Question2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("List Organiser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(350, 190);
        frame.add(new myPanel());
        frame.setVisible(true);
    }

    public static class myPanel extends JPanel {
        LinkedList<Integer> list = new LinkedList<>();

        //Input Layout
        JPanel input = new JPanel();
        JTextField number = new JTextField(8);

        //Button Layout
        JPanel controls = new JPanel();
        JButton sort = new JButton("Sort");
        JButton shuffle = new JButton("Shuffle");
        JButton reverse = new JButton("Reverse");

        //Output
        TextField output = new TextField();

        public myPanel() {
            //Main Layout
            setLayout(new BorderLayout());
            setFocusable(true);
            requestFocusInWindow();

            //Input Layout
            input.add(new JLabel("Enter a number: "));
            number.addActionListener(new TextListener());
            input.add(number);

            //Button Layout
            sort.addActionListener(g -> {Collections.sort(list); displayList();});
            shuffle.addActionListener(g -> {Collections.shuffle(list); displayList();});
            reverse.addActionListener(g -> {Collections.reverse(list); displayList();});
            controls.add(sort);
            controls.add(shuffle);
            controls.add(reverse);

            //Add all panels to main
            add(input, BorderLayout.NORTH);
            add(output, BorderLayout.CENTER);
            add(controls, BorderLayout.SOUTH);
        }

        //Displays list
        public void displayList() {
            //Output list
            StringBuilder listString = new StringBuilder();
            for (Integer i : list) {
                listString.append(i).append(" ");
            }
            output.setText(listString.toString());
        }

        //Listens for enter key in textfield
        public class TextListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Checks if string has only numbers
                if (number.getText().chars().allMatch(Character::isDigit)){
                    Integer num = Integer.parseInt(number.getText());
                    if (!list.contains(num)) {
                        list.add(num);
                    }
                }
                displayList();
                number.setText("");
            }
        }
    }
}