/**
 * User: alexthornburg
 * Date: 2/24/14
 * Time: 6:29 PM
 */
import au.com.bytecode.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CSVParser {
    private String path;
    int total;

    public CSVParser(String path){
        this.path = path;
    }

    public Map<Integer,String> run(){
        Map<Integer,String> result = new HashMap<Integer,String>();
        try {
            CSVReader csvReader = new CSVReader(new FileReader(path));
            String[] row = null;
                while((row = csvReader.readNext())!=null){
                    if(row.length==1){
                        total = toCents(row[0]);
                    }else{
                        result.put(toCents(row[1]),row[0]);
                    }
                }
            return result;
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Check path and try again.");
        } catch (IOException e) {
            System.out.println("Error parsing CSV.");
        }
        return null;
    }

    public int getTotal(){
        return total;
    }

    public int toCents(String money){
        String sansDollarSign = money.substring(1);
        int index = sansDollarSign.indexOf('.');
        int dollars = Integer.parseInt(sansDollarSign.substring(0,index));
        int cents = Integer.parseInt(sansDollarSign.substring(index+1));
        return dollars*100+cents;
    }
}
