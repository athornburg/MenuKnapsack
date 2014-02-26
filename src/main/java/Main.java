/**
 * User: alexthornburg
 * Date: 2/24/14
 * Time: 6:44 PM
 */

import java.util.Map;

public class Main {
    public static void main(String[] args){
        if((!args[0].equals("-r") || !args[0].equals("-n")) && args.length!=2){
            System.out.println("argument error pleas try again!");
        }else{
            String file = "src/main/resources/"+args[1];
            CSVParser parser = new CSVParser(file);
            Map<Integer,String> menu = parser.run();
            int total = parser.getTotal();
            int[]prices = new int[menu.size()];
            int count = 0;
            for(Map.Entry<Integer,String> entry:menu.entrySet()){
                prices[count] = entry.getKey();
                count++;
            }
            MenuSolver solver = new MenuSolver(menu);
            if(args[0].equals("-n")){
                solver.subsetSum(prices,0,0,total,"");
                String output = solver.getResult();
                if(output.equals("")){
                    System.out.println("No solutions without repitition.\n");
                }else{
                    System.out.println(output+"\n");
                }
            }else if(args[0].equals("-r")){
                int[] index = new int[prices.length*prices.length];
                index[0] = 0;
                solver.subsetWithRep(prices,total,0,prices.length,index,0);
                String output = solver.getResult();
                if(output.equals("")){
                    System.out.println("No solutions.\n");
                }else{
                    System.out.println(output+"\n");
                }
            }

        }


    }
}
