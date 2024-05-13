
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class gridLayout extends JFrame{
    public static int []veriler = new int[3];
    public gridLayout(){
        try {
            FileReader fr = new FileReader("C:\\Users\\EREN\\Documents\\NetBeansProjects\\hft9\\NO_test.txt");
            BufferedReader br = new BufferedReader(fr);
            
            String line = br.readLine();
            
            while(line !=null){
                String [] parcalar = line.split(" ");
                
                switch(parcalar[0]){
                    case "sayi":
                        veriler[0]=Integer.parseInt(parcalar[1]);
                        break;
                    case "satir":
                        veriler[1]=Integer.parseInt(parcalar[1]);
                        break;   
                    case "sutun":
                        veriler[2]=Integer.parseInt(parcalar[1]);
                        break;      
                }
                line = br.readLine();
            }
            
            
            br.close();
            
           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(gridLayout.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(gridLayout.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        setLayout(new GridLayout(veriler[1],veriler[2]));
        for(int i =0; i<veriler[0]; i++){
            JLabel myLabel = new JLabel();
            myLabel.setText(String.valueOf(i));
            add(myLabel);
            
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new gridLayout();
    }
}
