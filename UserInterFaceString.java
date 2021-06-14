import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class UserInterFaceString extends UserInterface implements ItemListener
{
    JTextField input;
    JTextField result;
    JButton buttonEq;
    Checkbox des;
    Checkbox hex;
    CalcEngineHex calcHex = new CalcEngineHex();
    CalcString calcES;


    /**
     * Create a user interface.
     *
     * @param engine The calculator engine.
     */
    public UserInterFaceString(CalcString engine)
    {
        super(engine);
        calcES = engine;
        makeFrame();
        des.setEnabled(false);
        des.setState(true);
    }

    protected void makeFrame()
    {
        frame = new JFrame();
        frame.setBounds(700,300,700,500);
        input = new JTextField();
        result = new JTextField();

        JPanel paneStringPanel = (JPanel)frame.getContentPane();
        paneStringPanel.setLayout(new BorderLayout(8, 8));
        paneStringPanel.setBorder(new EmptyBorder( 10, 10, 10, 10));
         paneStringPanel.add(input,BorderLayout.NORTH);

        buttonEq = new JButton("=");
        buttonEq.addActionListener(this::actionPreformed);

        paneStringPanel.add(buttonEq, BorderLayout.LINE_START);
        paneStringPanel.add(result, BorderLayout.SOUTH);
        CheckboxGroup grp = new CheckboxGroup();
        des = new Checkbox("decimal", grp, false);
        hex = new Checkbox("hexadecimal", grp, false);
        des.addItemListener(this);
        hex.addItemListener(this);
        paneStringPanel.add(des,BorderLayout.AFTER_LINE_ENDS);
        paneStringPanel.add(hex);
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPreformed(ActionEvent e)
    {
        if( e.getActionCommand().equals("="))
        {
            String text =input.getText();
            result.setText(calcES.evaluateInfix(text));
        }
    }

   @Override
    public void itemStateChanged(ItemEvent e)
    {
        if(e.getSource() == hex)
        {
            hex.setEnabled(false);
            des.setEnabled(true);
            result.setText("" + calcHex.getDisplayValueHex().toUpperCase());
        }
        else if (e.getSource() == des)
        {
            des.setEnabled(false);
            hex.setEnabled(true);
            result.setText("" + calc.getDisplayValue());
        }

    }
}
