import java.util.*;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Guess_the_Number2 extends javax.swing.JFrame {

    public Guess_the_Number2() {
        initComponents();
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        Introduction = new javax.swing.JLabel();
        Start_game = new javax.swing.JButton();
        Input_message = new javax.swing.JLabel();
        guessed_number = new javax.swing.JTextField();
        enter = new javax.swing.JButton();
        Output_message = new javax.swing.JLabel();
        Clue=new javax.swing.JLabel();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        //setting properties of 'Introduction' label
        Introduction.setBackground(new java.awt.Color(204, 255, 255));
        Introduction.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18));//font size 18 
        Introduction.setForeground(new java.awt.Color(255, 0, 51));//red font color
        Introduction.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Introduction.setText("Guessing a number between 1 and 100. Click 'Start Game'.");//prints this text.
        Introduction.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        //end setting properties of 'Intoduction' Label

        //setting properties of 'Start Game' button
        Start_game.setBackground(new java.awt.Color(204, 204, 255));
        Start_game.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        Start_game.setForeground(new java.awt.Color(51, 51, 255));
        Start_game.setText("Start Game");
        //response to mouse click.
        Start_game.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    Start_gameMouseClicked(evt);//call the method when mouse is clicked on the button. The method generates the number
                }
            });
        //end setting properties of 'Start Game' button.

        //setting properties of 'Input_message' label
        Input_message.setText("Enter a no. and click 'GO'");
        Input_message.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 16));//font size 16
        Input_message.setForeground(new java.awt.Color(102,102,255));//kind of purple font color 
        Input_message.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        //end setting properties of 'Input_message' label

        //setting properties of 'GO' button
        enter.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        enter.setForeground(new java.awt.Color(51, 51, 255));
        enter.setText("GO");
        //response to mouse click
        enter.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    enterMouseClicked(evt);//calls the method on clicking the 'GO' button. The method checks if number entered is equal to generated number and provides necessary hints
                }
            });
        //end setting properties of 'GO' button.

        //Setting properties of 'Output_message' Label
        Output_message.setText("There are 5 trials. The last trial has a code to find the number. Now click 'Start Game'");
        Output_message.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18));
        Output_message.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        //end setting properties of 'Output_message' Label

        //setting the layout 
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        //the horizontal layout is set
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Introduction))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(342, 342, 342)
                        .addComponent(Start_game, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Output_message)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Input_message, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(guessed_number, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(enter, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)

                .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );//end setting horizontal layout.
        //the vertical layout is set
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Introduction)
                .addGap(18, 18, 18)
                .addComponent(Start_game)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Input_message, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guessed_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enter))
                .addGap(18, 18, 18)
                .addComponent(Output_message)
                .addContainerGap(384, Short.MAX_VALUE))
        );
        //end setting vertical layout
        pack();
    }                     

    int generatedNum; // random 1-100. 

    private void Start_gameMouseClicked(java.awt.event.MouseEvent evt) {                                        
        Output_message.setForeground(new java.awt.Color(0,0,0));//black font color
        Output_message.setText("Ok. I have generated the number. Enter your guess in the field above and press 'GO' button");
        generatedNum=(int)(Math.random()*100)+1;
        trials=1;
    }                                       
    int trials=1;
    private void enterMouseClicked(java.awt.event.MouseEvent evt) {                                   
        int input=0; boolean right_input=true;
        for(int i=0;i<guessed_number.getText().length();i++)//checks for correct input
        {
            if(Character.isDigit(guessed_number.getText().charAt(i))==false)//even if one letter or special character is found in the input it cannot be a number
            {
                right_input=false;
                break;
            }
        }
        if(right_input==true)
        {
            input= Integer.valueOf(guessed_number.getText());
            if(input==generatedNum)
            {
                Output_message.setForeground(new java.awt.Color(0,153,51));
                Output_message.setText("Well done! You have guessed it in trial "+trials);
            }
            else
            { 

                Output_message.setForeground(new java.awt.Color(255,0,51));
                String s="Sorry! It is wrong. Try again"+". "+"Trial: "+trials+"/5";

                if(trials>=5)
                { 
                    s="Sorry! It is wrong. Try again"+". ";
                    s=s+" "+"Retry by clicking 'Start Game'"+". "+"The number is "+Integer.toString(generatedNum);

                }
                Output_message.setText(s);
                guessed_number.setText("");
                if(trials==2)//hints to give at trial 2
                {
                    if(generatedNum>=50)
                    {

                        Output_message.setText("Trial: "+trials+"/5 "+"Oooo! You didnt get it. Hint: The number generated is greater than or equal to 50");
                    }
                    else

                    {
                        Output_message.setText("Trial: "+trials+"/5 "+"Oooo! You didnt get it. The number generated is less than 50");}
                }
                if(trials==3) //hints to give at trial 3
                {
                    if(generatedNum>=0 && generatedNum<25)
                    {
                        Output_message.setText("Trial: "+trials+"/5 "+"No probs.Hint: The number generated is greater than or equal to 0 but less than 25");Clue.setVisible(true);
                    }
                    else if(generatedNum>=25 && generatedNum<50)
                    {    Output_message.setText("Trial: "+trials+"/5 "+"No probs.Hint: The number generated is greater than or equal to 25 but less than 50");

                    }
                    else if(generatedNum>=50 && generatedNum<75)
                    {
                        Output_message.setText("Trial: "+trials+"/5 "+"No probs.Hint: The number generated is greater than or equal to 50 but less than 75");
                    }
                    else
                    {
                        Output_message.setText("Trial: "+trials+"/5 "+"No probs.Hint: The number generated is greater than or equal to 75 but less than 100");

                    }
                }
                if(trials==4)//the code after trial 4
                {
                    int diff=generatedNum-input;
                    Output_message.setText("Trial: "+trials+"/5 "+"Hmmm...Last try. Crack this ---> Hint: difference, "+Integer.toString(diff)+", Order, generated, last number entered");

                }
            }
            trials=trials+1;
        }
        else
        {
            guessed_number.setText("");
            Output_message.setText("Sorry wrong input. Click 'Start Game'");//for wrong input like a text instead of number

        }  

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Guess_the_Number2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
                new Guess_the_Number2().setVisible(true);
            });
    }

    // Variables declaration -                      
    private javax.swing.JLabel Input_message;
    private javax.swing.JLabel Introduction;
    private javax.swing.JLabel Output_message;
    private javax.swing.JButton Start_game;
    private javax.swing.JButton enter;
    private javax.swing.JTextField guessed_number;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JLabel Clue;
 
    // End of variables declaration                   
}

