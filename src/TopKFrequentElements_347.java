import java.util.*;

/**
 * Created by yjin on 7/13/16.
 */
public class TopKFrequentElements_347 {

    private class Node{
        int key;
        int count;

        public Node(int key,int count){
            this.key=key;
            this.count=count;
        }

    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        //two solutions here
        //this one is came from myself using pority heap
        List<Integer> list=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int key:nums){
            if(!map.containsKey(key))
                map.put(key,0);
            int val=map.get(key);
            map.put(key,++val);
        }
        PriorityQueue<Node> queue=new PriorityQueue<Node>(k,new Comparator<Node>() {//have to remember
            public int compare(Node n1, Node n2) {
                return Integer.compare(n1.count,n2.count);
            }
        });
        for(int key:map.keySet()){
            Node node=new Node(key,map.get(key));
            queue.add(node);
            if(queue.size()>k)
                queue.poll();
        }

        while(!queue.isEmpty()){
            list.add(queue.poll().key);
        }
        return list;

    }

    public List<Integer> topKFrequent1(int[] nums, int k) {
        //first map the frequence to key
        //then you have the frequence of each key, thus assign different key to each frequency
        //scan from then end
        List<Integer> list=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int key:nums){
            if(!map.containsKey(key))
                map.put(key,0);
            int val=map.get(key);
            map.put(key,++val);
        }
        List<Integer>[] bucket=new List[nums.length+1];
        for(int key:map.keySet()){
            int fre=map.get(key);
            if(bucket[fre]==null)
                bucket[fre]=new ArrayList<Integer>();
            bucket[fre].add(key);
        }
        for(int i=bucket.length-1;i>=0;i--){
            if(bucket[i]==null) continue;
            for(Integer val:bucket[i]){
                list.add(val);
                if(list.size()==k)
                    return list;
            }
        }
        return list;

    }

    public static void main(String[] args){
        TopKFrequentElements_347 sol=new TopKFrequentElements_347();
        int[] array={1,1,1,2,2,3};
        List<Integer> list=sol.topKFrequent1(array,2);
        for(int val:list)
            System.out.println(val);
    }
}
