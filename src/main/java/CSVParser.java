/**
 * User: alexthornburg
 * Date: 2/24/14
 * Time: 6:29 PM
 */
import au.com.bytecode.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVParser {
    private String path;
    int total;

    public CSVParser(String path){
        this.path = path;
    }

    public MenuItem[]run(){
        ArrayList<MenuItem> items = new ArrayList<MenuItem>();
        try {
            CSVReader csvReader = new CSVReader(new FileReader(path));
            String[] row = null;
                while((row = csvReader.readNext())!=null){
                    if(row.length==1){
                        total = toCents(row[0]);
                    }else{
                        MenuItem item = new MenuItem();
                        item.setName(row[0]);
                        item.setCost(toCents(row[1]));
                        items.add(item);
                    }
                }

            return toArray(items);
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

    public MenuItem[] toArray(ArrayList<MenuItem> list){
        MenuItem[] items = new MenuItem[list.size()];
        int count = 0;
        for(MenuItem item:list){
           items[count] = item;
            count++;
        }
        return items;
    }
}
