package GUI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class JavaFile extends Application{
  public static void main(String[] args) {

	  Application.launch(args);
	  
	  Platform.runLater(() -> {
		  TopPane instance = new TopPane();
	
	String text = instance.getSavedText();

    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
      writer.write(text);
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    try {
      BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
      String line;
      while((line = reader.readLine()) != null) {
        System.out.println(line);
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    
  
	  });
	  
	  
	 
  }

@Override
public void start(Stage arg0) throws Exception {
	// TODO Auto-generated method stub
	
}
}

