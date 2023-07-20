import java.awt.*;
import java.awt.event.*;

public class InputWindow extends Frame
{
    private Label lblInput;
    private TextField tfInput;
    private Button btnInput;
    public int input = -1;

    private class BtnInputListener implements ActionListener
    {
        public void actionPerformed(ActionEvent evt){
            input = Integer.parseInt(tfInput.getText());
            System.out.print("source:");
            System.out.println(input);
        }


    }



    public int getInput()
    {
        return input;
    }

    public InputWindow()
    {
        setLayout(new FlowLayout()); //just start with this

        lblInput = new Label("Input taker"); //give input
        add(lblInput);

        tfInput = new TextField(input + "",  10);
        tfInput.setEditable(true);
        add(tfInput);

        btnInput = new Button("Input");
        add(btnInput);

        BtnInputListener listener = new BtnInputListener();
        btnInput.addActionListener(listener);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                System.exit(0);  // Terminate the program
            }
        });

        setTitle("source taker");
        setSize(300, 100);
        setVisible(true);
    }

}
