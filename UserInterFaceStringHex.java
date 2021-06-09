import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterFaceStringHex extends UserInterface
{
    JTextField input;
    JTextField result;
    JButton buttonEq;
    JLabel message;


    /**
     * Create a user interface.
     *
     * @param engine The calculator engine.
     */
    CalcString calcES;
    public UserInterFaceStringHex(CalcString engine) {
        super(engine);
        calcES = engine;
        makeFrame();
    }

    protected void makeFrame()
    {
        frame = new JFrame();
        input = new JTextField();
        result = new JTextField();
        message= new JLabel("Calculator Warning");
        JPanel paneStringPanel = (JPanel)frame.getContentPane();
        paneStringPanel.setLayout(new BorderLayout(8, 8));
        paneStringPanel.setBorder(new EmptyBorder( 10, 10, 10, 10));
        paneStringPanel.add(input,BorderLayout.NORTH);
        buttonEq = new JButton("=");
        buttonEq.addActionListener(this::actionPreformed);
        paneStringPanel.add(message,BorderLayout.AFTER_LINE_ENDS);
        paneStringPanel.add(buttonEq, BorderLayout.CENTER);
        paneStringPanel.add(result, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }



    public void actionPreformed(ActionEvent e)
    {
        if( e.getActionCommand().equals("="))
        {
            String text =input.getText();

            if(text.length()<2 || hasOeratorRepetation(text) )
            {
                 message.setText("bad input");
                 result.setText("");
            }
            else
            {
                result.setText(String.valueOf(calcES.evaluateInfix(text)));
            }


        }

    }
    public boolean hasOeratorRepetation(String text)
    {
        for (int i=0;i<text.length()-1;i++)
        {
                if(CalcString.isOperator(text.charAt(i)) == CalcString.isOperator(text.charAt(i+1)) && text.charAt(i) !='(' && text.charAt(i+1) !=')')
                {
                    return true;
                }



        }
        return false;
    }
}
