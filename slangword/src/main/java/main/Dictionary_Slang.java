package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

class  Dictionary_Slang {
    private Dictionary<String, Integer> _slang_dict= new Hashtable<>();


    public void LoadData() throws IOException{
        // System.out.println("Asfdasdfsf");
        //slangword/
        //slangword\data_input\slang.txt
        //
        // Path currentRelativePath = Paths.get("");
        // String s = currentRelativePath.toAbsolutePath().toString();
        // System.out.println("Current absolute path is: " + s);
        BufferedReader br = new BufferedReader(new FileReader("slangword/data_input/slang.txt"));
        String line = br.readLine();
        while(line != null){
            System.out.println(line);
            line = br.readLine();
        }
    }
}
