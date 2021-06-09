import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
public class UserInterfaceHex extends UserInterface  implements ItemListener
{
    private CalcEngineHex calcHex;
    public Checkbox decimal;
    public Checkbox hexadecimal;

    // this Object to put the Hexadecimal buttons on
    public JPanel buttonHexPanel;

    //Constructor
    public UserInterfaceHex(CalcEngineHex engine)
    {
        super(engine);
        this.calcHex=engine;
        setVisible(false);
        makeFrameHex();
        frame.setVisible(true);
        hexadecimal.setEnabled(false);
        hexadecimal.setState(true);
    }

    //Design the Window
    public void makeFrameHex()
    {
        frame = new JFrame(calc.getTitle());

        JPanel contentPane = (JPanel)frame.getContentPane();
        contentPane.setLayout(new BorderLayout(8, 8));
        contentPane.setBorder(new EmptyBorder( 10, 10, 10, 10));

        display = new JTextField();
        contentPane.add(display, BorderLayout.NORTH);

        buttonHexPanel = new JPanel();
        JPanel buttonPanel = new JPanel(new GridLayout(4, 6));
        addButton(buttonHexPanel, "A");
        addButton(buttonHexPanel, "B");
        addButton(buttonHexPanel, "C");
        addButton(buttonHexPanel, "D");
        addButton(buttonHexPanel, "E");
        addButton(buttonHexPanel, "F");

        addButton(buttonPanel, "1");
        addButton(buttonPanel, "2");
        addButton(buttonPanel, "3");
        addButton(buttonPanel, "4");
        addButton(buttonPanel, "5");
        addButton(buttonPanel, "6");

        addButton(buttonPanel, "7");
        addButton(buttonPanel, "8");
        addButton(buttonPanel, "9");
        addButton(buttonPanel, "Clear");
        addButton(buttonPanel, "?");
        addButton(buttonPanel, "*"); //multiplication

        addButton(buttonPanel, "0");
        addButton(buttonPanel, "+");
        addButton(buttonPanel, "-");
        addButton(buttonPanel, "=");

        CheckboxGroup grp = new CheckboxGroup();
        decimal = new Checkbox("decimal", grp, false);
        hexadecimal = new Checkbox("hexadecimal", grp, false);
        decimal.addItemListener(this);
        hexadecimal.addItemListener(this);

        buttonPanel.add(decimal);
        buttonPanel.add(hexadecimal);


        contentPane.add(buttonPanel, BorderLayout.CENTER);
        contentPane.add(buttonHexPanel,BorderLayout.AFTER_LAST_LINE);

        status = new JLabel(calc.getAuthor());
        contentPane.add(status, BorderLayout.SOUTH);

        frame.pack();
    }

    //Execute this every time a button has pressed
    public void actionPerformed(ActionEvent event)
    {
        String command = event.getActionCommand();
        if(     command.equals("A") ||
                command.equals("B") ||
                command.equals("C") ||
                command.equals("D") ||
                command.equals("E") ||
                command.equals("F") ||
                command.equals("Clear") )
        {
            calcHex.numberPressedHex(command);
            redisplayHex();
        }
        else
        {
            super.actionPerformed(event);
            if(hexadecimal.getState())
            {
                redisplayHex();
            }
            else
            {
                redisplay();
            }
        }
    }

    //Display the Value in Hexadecimal
    private void redisplayHex()
    {
        display.setText("" + calcHex.getDisplayValueHex().toUpperCase());
    }

    //Execute this every time the Calculator mode changes
    public void itemStateChanged(ItemEvent e)
    {
        //switch from hexadecimal to decimal mode
        if(e.getSource() == hexadecimal)
        {
            hexadecimal.setEnabled(false);
            decimal.setEnabled(true);
            redisplayHex();
            greyTheButtons();
        }
        else if (e.getSource() == decimal)
        {
            decimal.setEnabled(false);
            hexadecimal.setEnabled(true);
            redisplay();
            greyTheButtons();
        }
    }

    //to make the Hexadecimal buttons gray and disable
    public void greyTheButtons()
    {
        for (Component button : buttonHexPanel.getComponents() )
        {
            if(button.isEnabled())
            {
                button.setEnabled(false);
            }
            else
            {
                button.setEnabled(true);
            }
        }
    }

}
