package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;


class  Dictionary_Slang<K, V> {
    private Dictionary<K, V> _slang_dict= new Hashtable<>();


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
            String each_part[] = line.split("`");
            // System.out.println(each_part[0]);
            // System.out.println(each_part[1]);
            // System.out.println(line);
            _slang_dict.put((K)each_part[0].toLowerCase(), (V)each_part[1]);
            line = br.readLine();
        }

        long startTime = System.nanoTime();
        

        _slang_dict.keys().asIterator().forEachRemaining((key -> {

            String temp = (String)_slang_dict.get(key);
            if (temp.toLowerCase().contains("today")) {
                // System.out.println(temp);
            }
        }));

        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        System.out.println(duration);
        // System.out.println(_slang_dict.keys());
        // System.out.println(_slang_dict.get("wtft"));
    }
}
