// Find All People With Secret
// You are given an integer n indicating there are n people numbered from 0 to n - 1. You are also given a 0-indexed 2D integer array meetings where 
// meetings[i] = [xi, yi, timei] indicates that person xi and person yi have a meeting at timei. A person may attend multiple meetings at the same time. 
// Finally, you are given an integer firstPerson.
// Person 0 has a secret and initially shares the secret with a person firstPerson at time 0. This secret is then shared every time a meeting takes place 
// with a person that has the secret. More formally, for every meeting, if a person xi has the secret at timei, then they will share the secret with 
// person yi, and vice versa.
// The secrets are shared instantaneously. That is, a person may receive the secret and share it with people in other meetings within the same time frame.
// Return a list of all the people that have the secret after all the meetings have taken place. You may return the answer in any order.

import java.util.*;

public class FindAllPeopleWithSecret {
    @SuppressWarnings("unchecked")
    public static List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<int[]> graph[] = new ArrayList[n];
        for(int i=0; i<n; ++i) {
            graph[i] = new ArrayList<>();
        }

        for(int m[] : meetings) {
            int x = m[0], y = m[1], time = m[2];
            graph[x].add(new int[]{y, time});
            graph[y].add(new int[]{x, time});
        }

        int secretTime[] = new int[n];
        Arrays.fill(secretTime, Integer.MAX_VALUE);
        secretTime[0] = secretTime[firstPerson] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        q.add(new int[]{firstPerson, 0});
        while(!q.isEmpty()) {
            int curr[] = q.poll();
            int person = curr[0], time = curr[1];

            for(int nxtMeeting[] : graph[person]) {
                int nxtPerson = nxtMeeting[0], nxtTime = nxtMeeting[1];
                if(nxtTime >= time && secretTime[nxtPerson] > nxtTime) {
                    secretTime[nxtPerson] = nxtTime;
                    q.add(new int[]{nxtPerson, nxtTime});
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i=0; i<n; ++i) {
            if(secretTime[i] != Integer.MAX_VALUE) {
                res.add(i);
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        int n = 6;
        int meetings[][] = {{1, 2, 5}, {2, 3, 8}, {1, 5, 10}};
        int firstPerson = 1;
        System.out.println(findAllPeople(n, meetings, firstPerson));
    }
}
