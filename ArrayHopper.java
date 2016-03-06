import java.util.*;
import java.lang.*;

public class MinPath{
    public int minPath(int[] path){
        
        int[] min = new int[path.length];
        
        Arrays.fill(min, Integer.MAX_VALUE);
        min[0] = 0;
        for (int i = 1; i < min.length; i++){
            for (int j = 0; j < i; j++){
                if (j + path[j] >= i){
                    min[i] = min[j] + 1;
                    break;
                }
            }
        }
        
        return min[min.length-1] == Integer.MAX_VALUE ? -1 : min[min.length-1];
    }

    public int EvalPath(int[] path){
        
        List<Integer> list = new ArrayList<Integer>();
        int id = 0;
        int minPath = 0;
        int reach;
        while (true){
            int maxReach = -1;
            int maxId = id;
          
            try {
            for (int i = 0; i <= path[id]; i++){
                int curId = id + i;
                reach = curId + path[curId];

             if (reach > maxReach){
                    maxReach = reach;
                    maxId = curId;
                        }
                    }
                 }
                catch (ArrayIndexOutOfBoundsException e) {break;}
              
            
            if (id == maxId) {return -1;}
            id = maxId;
            
            minPath++;
            
            list.add(id);
            
            if (id >= path.length-1) break;
        }
        
        System.out.print("0, ");
        for(int i=0;i<list.size();i++) {
            System.out.print(list.get(i) + ", ");
            
        }
        System.out.print("out");
        return 0;
    }

    public static void main(String[] args){
       
    
        List<Integer> list = new ArrayList<Integer>();
        int len;
        boolean launch=true;
  
        Scanner sc=new Scanner(System.in);
    
        try {    
            for(int j=0;j<Integer.MAX_VALUE;j++)
                list.add(sc.nextInt());
            len = list.size();
        } catch (NoSuchElementException e) {
            len = list.size();
        }
  
        int[] path = new int[len];
        
        for(int i=0;i<path.length;i++) {
            if(list.get(i) < 0) {
                launch = false;
                break;
            } else {
                    path[i]=list.get(i);
                }
          }
        
        if(launch) {
        MinPath mp = new MinPath();
        int a = mp.EvalPath(path);
        if(a==-1) { System.out.print("failure");}
        }
        else {
            System.out.print("failure");
        }
    }
}
