package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class  Dictionary_Slang<K, V> {
    private Dictionary<K, V> _slang_dict = new Hashtable<>();

    public void LoadData() throws IOException{
        // System.out.println("Asfdasdfsf");
        //slangword/
        //slangword\data_input\slang.txt
        //
        // Path currentRelativePath = Paths.get("");
        // String s = currentRelativePath.toAbsolutePath().toString();
        // System.out.println("Current absolute path is: " + s);
        Dictionary<K, V> temp_dict = new Hashtable<>();
        _slang_dict = temp_dict;
        BufferedReader br = new BufferedReader(new FileReader("slangword/data_input/slang.txt"));
        String line = br.readLine();
        while(line != null){
            String each_part[] = line.split("`");
            // System.out.println(each_part[0]);
            // System.out.println(each_part[1]);
            List<String> list;
            
            if (_slang_dict.get((K)each_part[0].toLowerCase()) != null) {
                list = (List)_slang_dict.get((K)each_part[0].toLowerCase());
                list.add(each_part[1]);
            } else {
                list = new ArrayList<String>();
                list.add(each_part[1]);
                _slang_dict.put((K)each_part[0].toLowerCase(), (V)list);
            }
            // System.out.println(_slang_dict.get((K)each_part[0].toLowerCase()));
            // _slang_dict.put((K)each_part[0].toLowerCase(), (V)each_part[1]);
            // System.out.println(_slang_dict.get((K)each_part[0].toLowerCase()));
            line = br.readLine();
        }

        // long startTime = System.nanoTime();
        

        // _slang_dict.keys().asIterator().forEachRemaining((key -> {
        //     // System.out.println(key);
        //     V temp = _slang_dict.get(key);
        //     ArrayList list = (ArrayList)temp;
        //     for (int i = 0; i < list.size(); i++){
        //         //System.out.println(list.get(i));
        //         if (((String)list.get(i)).toLowerCase().contains("today")){
        //             System.out.println(list.get(i));
        //         }
        //     }
        //     // if (temp.toLowerCase().contains("today")) {
        //     //     // System.out.println(temp);
        //     // }
        // }));

        // System.out.print(_slang_dict.keys());
        // long endTime = System.nanoTime();

        // long duration = (endTime - startTime);
        // System.out.println(duration);
        // System.out.println(_slang_dict.keys());
        // System.out.println(_slang_dict.get("wtft"));
    }

    public Vector<String> vector_search(String Search){
        Vector<String> results = new Vector<String>();
        V temp = _slang_dict.get(Search.toLowerCase());
        ArrayList list = (ArrayList)temp;
        if (list == null)return results;
        for (int i = 0; i < list.size(); i++){
            results.add(((String)list.get(i)));
        }
        // System.out.print(temp);
        return results;
    }

    public Vector<String> defi_search(String Search){
        Vector<String> results = new Vector<String>();
        _slang_dict.keys().asIterator().forEachRemaining((key -> {
            // System.out.println(key);
            ArrayList temp = (ArrayList)_slang_dict.get(key);
            for (int i = 0; i < temp.size(); i++){
                if (((String)temp.get(i)).toLowerCase().contains(Search.toLowerCase())) {
                    results.add(key.toString().toUpperCase() + "-" + temp.get(i));
                    // System.out.println(temp);
                }
            }
            
        }));
        // System.out.print(temp);
        // results.add(temp);
        return results;
    }

    public Boolean check_exist(String slang){
        Boolean flag = true;
        if (_slang_dict.get(slang.toLowerCase()) == null){
            return false;
        }
        return flag;
    };

    public void add_slang(String slang, String defi){
        List<String> list;
        System.out.println(_slang_dict.get(slang));
        list = new ArrayList<String>();
        // list = (List)_slang_dict.get((K)slang.toLowerCase());
        list.add(defi);
        _slang_dict.put((K)slang.toLowerCase(), (V)list);
    }

    public void remove_slang(String slang){
        _slang_dict.remove(slang);
    }

    public String get_random_slang(){
        String resultz = new String("");
        Random rd = new Random();
        int randInt = rd.nextInt(_slang_dict.size());
        // HashMap<K, V> map = _slang_dict;
        // List<String> keys = new ArrayList<String>(_slang_dict.keySet());
        Integer index = 0;
        _slang_dict.keys().asIterator().forEachRemaining((key -> {
            // System.out.println(key);
            if (randInt == index){
                ArrayList temp = (ArrayList)_slang_dict.get(key);
                for (int i = 0; i < temp.size(); i++){
                    resultz.replaceAll(resultz, key.toString().toUpperCase() + "-" + temp.get(i));
                }
                
                // return resultz;
            }
            
        }));
        return resultz;
    }
}
