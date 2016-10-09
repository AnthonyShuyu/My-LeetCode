/**
 * 
 * 
 * 355. Design Twitter
 * 
 * 
 */


public class Twitter {

    class Tweet {
        int time;
        int tweetId;
        public Tweet(int time, int tweetId) {
            this.time = time;
            this.tweetId = tweetId;
        }
    }


    /** Initialize your data structure here. */
    
    Map<Integer, Set<Integer>> userMap; // key is userId, value is userId and his followees userId
    Map<Integer, List<Tweet>> tweetMap; // key is userId, value is his tweets
    int time = 0;
    
    public Twitter() {
        userMap = new HashMap<Integer, Set<Integer>>();
        tweetMap = new HashMap<Integer, List<Tweet>>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new HashSet<Integer>());
        }
        userMap.get(userId).add(userId);
        
        if (!tweetMap.containsKey(userId)) {
            tweetMap.put(userId, new ArrayList<Tweet>());
        }    
        tweetMap.get(userId).add(new Tweet(time, tweetId));  
        time++;
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        // corner case
        List<Integer> result = new ArrayList<Integer>();
        if (!userMap.containsKey(userId)) {
            return result;
        }

        Set<Integer> userSets = userMap.get(userId);
        
        Queue<Tweet> queue = new PriorityQueue<Tweet>(new Comparator<Tweet>() {
                @Override
                public int compare(Tweet t1, Tweet t2) {
                    return t1.time - t2.time;
                }
            });
        
        for (int num : userSets) {
            List<Tweet> tweets = tweetMap.get(num);
            for (int i = 0; i < tweets.size(); i++) {
                Tweet t = tweets.get(i);
                if (!queue.isEmpty() && queue.size() == 10) {
                    if (t.time > queue.peek().time) {
                        queue.poll();                        
                    }
                }
                queue.offer(t);                
            }
        }
        while (!queue.isEmpty()) {
            result.add(0, queue.poll().tweetId);
        }
        return result;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new HashSet<Integer>());
        }
        userMap.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (userMap.get(followerId).contains(followeeId)) {
            userMap.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */