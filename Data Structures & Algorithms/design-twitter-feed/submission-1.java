class Twitter {

    // A map of followee IDs to follower IDs
    Map<Integer, Set<Integer>> following = new HashMap<>();
    Map<Integer, Set<Tweet>> tweets = new HashMap<>();
    int time = 0;

    record Tweet(int time, int tweetId) {}

    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        // Make sure user ID is "following" themselves
        if (!following.containsKey(userId)) {
            following.put(userId, new HashSet<>());
        }
        following.get(userId).add(userId);

        // When a tweet comes in, add to tweets
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new HashSet<>());
        }

        Tweet tweet = new Tweet(time, tweetId);
        tweets.get(userId).add(tweet);
        
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        // Get a set of the user IDs this user is following
        if (!following.containsKey(userId)) {
            return new ArrayList<>();
        }
        Set<Integer> follow = following.get(userId);

        PriorityQueue<Tweet> feed = new PriorityQueue<>((t1, t2) -> Integer.compare(t1.time, t2.time));

        for (int id : following.get(userId)) {
            if (!tweets.containsKey(id)) {
                continue;
            }
            for (Tweet tweet : tweets.get(id)) {
                feed.add(tweet);
                if (feed.size() > 10) {
                    feed.remove();
                }
            }
        }

        List<Tweet> tweetList = new ArrayList<>(feed);
        tweetList.sort((t1, t2) -> Integer.compare(t2.time, t1.time));

        List<Integer> tweetIds = new ArrayList<>();
        for (Tweet tweet : tweetList) {
            tweetIds.add(tweet.tweetId);
        }

        return tweetIds;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }

        if (!following.containsKey(followerId)) {
            following.put(followerId, new HashSet<>());
        }
        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }

        // Remove entry from following
        if (!following.containsKey(followerId)) {
            return;
        }
        following.get(followerId).remove(followeeId);
    }
}
