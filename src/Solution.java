import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    /*first put all the number, frequency into hashmap as the key and values. Then create a prirorty queue as this will help us sort by decending order
    * meaning the highest frequency will be at the top of the queue. Then we can poll the queue k number of times which will give us the value (the actual number)
    * and store it in an array
    * */

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();

        // if map contains dosent contain the number create a new pair with 1 as frequency
        // else just add one to the exisitng frequency
        for(int i=0; i < nums.length; i++){

            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }
            else{
                map.put(nums[i],map.get(nums[i]) +1);
            }
        }

        // will create a PQ with decreasing sorting based on values since the top of the queue will now have the highest frequencies
        PriorityQueue < Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());

        // putting all the pairs from map into queue
        for(Map.Entry entry : map.entrySet()){

            pq.add(entry);
        }

        int res[] = new int[k];

        // each time you poll the top pair gets kicked off
        for(int j=0; j <k; j++){
            res[j] = pq.poll().getKey();
        }

        return res;

    }
}
