// Minimum Number of People to Teach

import java.util.*;

public class MinimumNumberOfPeopleToTeach {
    public static int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int f = friendships.length;
        Set<Integer> cannotTalkUsers = new HashSet<>();
        for(int i=0; i<f; ++i) {
            int a = friendships[i][0];
            int b = friendships[i][1];
            Set<Integer> set = new HashSet<>();
            for(int l : languages[a - 1]) {
                set.add(l);
            }
            boolean canTalk = false;
            for(int l : languages[b - 1]) {
                if(set.contains(l)) {
                    canTalk = true;
                    break;
                }
            }

            if(!canTalk) {
                cannotTalkUsers.add(a);
                cannotTalkUsers.add(b);
            }
        }

        int count[] = new int[n];
        int maxKnowLanguage = 0;
        for(int user : cannotTalkUsers) {
            for(int l : languages[user - 1]) {
                ++count[l - 1];
                maxKnowLanguage = Math.max(maxKnowLanguage, count[l - 1]);
            }
        }

        int minUsersToTeach = cannotTalkUsers.size() - maxKnowLanguage;

        return minUsersToTeach;
    }
}