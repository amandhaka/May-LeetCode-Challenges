/*
Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
Each person may dislike some other people, and they should not go into the same group. 
Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
Return true if and only if it is possible to split everyone into two groups in this way.

Example 1:
Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4], group2 [2,3]

Example 2:
Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false

Example 3:
Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false

Note:
1 <= N <= 2000
0 <= dislikes.length <= 10000
1 <= dislikes[i][j] <= N
dislikes[i][0] < dislikes[i][1]
There does not exist i != j for which dislikes[i] == dislikes[j].
*/
//This is a dfs method and we can also do this using BFS by using queues to store the neighbour in queue and coloring them and if any conflict occur return false; 
class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        Map<Integer,Set<Integer>> graph=new HashMap<>();
        //Creating Graph
        for(int[] arr:dislikes){
            graph.putIfAbsent(arr[0],new HashSet<>());
            graph.putIfAbsent(arr[1],new HashSet<>());
            graph.get(arr[0]).add(arr[1]);
            graph.get(arr[1]).add(arr[0]);
        }
        int[] colors=new int[N+1]; //Color array
        for(int i=1;i<=N;i++){
            if(colors[i]==0 && !dfs(graph,colors,i,1)){
                return false; //If any conflict occur like two adjacent graph with same color
            }
        }
        return true; //no conflict
    }
    public static boolean dfs(Map<Integer,Set<Integer>> graph,int[] colors,int node,int color){
        if(colors[node]!=0){
            return colors[node]==color; //check if the node has color what we wanted it to be colored
        }
        colors[node]=color; //color the node
        if(graph.get(node)==null) return true;  //if the node is disconnected
        for(int next:graph.get(node)){ //color all its adjacent node
            if(!dfs(graph,colors,next,-color)) 
                return false;
        }
        return true;
    }
}
