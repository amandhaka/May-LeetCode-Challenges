/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 
Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
Constraints:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
1 <= numCourses <= 10^5
*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> [] g=new ArrayList[numCourses];
        for(int i=0;i<g.length;i++)
            g[i]=new ArrayList<>();
        
        for(int[] temp:prerequisites){
            g[temp[1]].add(temp[0]);
        }
        boolean[] vis=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!noCycle(g,i,vis)){
                return false;
            }
        }
        return true;
    }
    public static boolean noCycle(ArrayList<Integer>[] g,int current,boolean[] vis){
        if(vis[current]){
            return false;
        }
        vis[current]=true;
        for(int v:g[current]){
            if(!noCycle(g,v,vis)){
                return false;
            }
        }
        vis[current]=false;
        return true;
    }
}
