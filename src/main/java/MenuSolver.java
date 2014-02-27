/**
 * User: alexthornburg
 * Date: 2/24/14
 * Time: 6:07 PM
 */
public class MenuSolver {

    StringBuilder sb = new StringBuilder();

    MenuSolver(){
    }

    int max(int x,int y){
        if(x>y){
            return x;
        }else{
            return y;
        }
    }



    public void subsetSum(MenuItem[] prices, int index, int current, int total, String result){
        if (prices.length < index || current>total)
            return;
        for (int i = index; i < prices.length; i++) {
            if (current + prices[i].getCost() == total)   {
                sb.append(result + prices[i].getName()+"\n");
            }
            else if (current + prices[i].getCost() < total) {
                subsetSum(prices, i + 1, current + prices[i].getCost(), total, result + prices[i].getName()+" & ");
            }
        }
    }

    void subsetWithRep(MenuItem prices[],int total, int sum, int size, int index[], int n) {
        if (sum > total){
            return;
        }
        if (sum == total){
            printSums(prices, index, n);
        }
        for (int i = index[n]; i < size; i++) {
            index[n+1] = i;
            subsetWithRep(prices,total,sum + prices[i].getCost(), size, index, n+1);
        }
    }

    public void printSums(MenuItem[] prices,int index[],int n){
        for (int i = 1; i <= n; i++){
            sb.append(prices[index[i]].getName());
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
