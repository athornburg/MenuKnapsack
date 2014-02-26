/**
 * User: alexthornburg
 * Date: 2/24/14
 * Time: 6:07 PM
 */
import java.util.Map;
public class MenuSolver {

    int nodes =0;
    Map<Integer,String> menuList;
    StringBuilder sb = new StringBuilder();

    MenuSolver(Map<Integer,String> menuList){
        this.menuList = menuList;
    }

    int max(int x,int y){
        if(x>y){
            return x;
        }else{
            return y;
        }
    }



    public void subsetSum(int[] prices, int index, int current, int total, String result){
        if (prices.length < index || current>total)
            return;
        for (int i = index; i < prices.length; i++) {
            if (current + prices[i] == total)   {
                sb.append(result + menuList.get(prices[i])+"\n");
            }
            else if (current + prices[i] < total) {
                subsetSum(prices, i + 1, current + prices[i], total, result + menuList.get(prices[i])+" & ");
            }
        }
    }

    void subsetWithRep(int prices[],int total, int sum, int size, int index[], int n) {
        if (sum > total){
            return;
        }
        if (sum == total){
            printSums(prices, index, n);
        }
        for (int i = index[n]; i < size; i++) {
            index[n+1] = i;
            subsetWithRep(prices,total,sum + prices[i], size, index, n+1);
        }
    }

    public void printSums(int[] prices,int index[],int n){
        for (int i = 1; i <= n; i++){
            sb.append(menuList.get(prices[index[i]]));
            if(i==n){
                sb.append("\n");
            }else{
                sb.append(" & ");
            }
        }
    }

    public String getResult(){
        return sb.toString();
    }

}
