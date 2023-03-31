package com.code.ds.striver.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class _11_DesignTwitter {

  /**
   * to maintain the tweet order as per latest timestamp
   */
  private static int timestamp;

  /**
   * all users
   */
  private Map<Integer, User> users;

  /**
   * OO design so User can follow, unfollow and post itself
   * 
   * @author sukh
   *
   */
  private class User {
    private int id;
    private Set<Integer> following;
    private Tweet tweetHead;

    User(int id) {
      this.id = id;
      this.following = new HashSet<>();
      /**
       * first follow itself
       */
      following.add(id);
    }

    Set<Integer> getFollowing() {
      return following;
    }

    Tweet getTweetHead() {
      return tweetHead;
    }

    void follow(int id) {
      following.add(id);
    }

    void unfollow(int id) {
      following.remove(id);
    }

    /**
     * everytime user post a new tweet, add it to the head of tweet list.
     * 
     * @param id
     */
    void post(int id) {
      Tweet tweet = new Tweet(id);
      tweet.next = tweetHead;
      tweetHead = tweet;
    }
  }

  /**
   * Tweet link to next Tweet so that we can save a lot of time when we execute
   * getNewsFeed(userId)
   * 
   * @author sukh
   *
   */
  private class Tweet {
    private int id;
    private Tweet next;
    private int time;

    Tweet(int id) {
      this.id = id;
      this.time = timestamp++;
    }
  }

  /**
   * Initialize your data structure here.
   */
  public _11_DesignTwitter() {
    this.users = new HashMap<>();
  }

  /**
   * Compose a new tweet.
   * 
   * @param userId
   * @param tweetId
   */
  public void postTweet(int userId, int tweetId) {
    User user = users.get(userId);
    if (user == null) {
      user = new User(userId);
      users.put(userId, user);
    }
    user.post(tweetId);
  }

  /**
   * first get all tweets lists from one user including itself and all people it
   * followed. <br>
   * Second add all heads into a max heap. <br>
   * Every time we poll a tweet with largest time stamp from the heap, then we add
   * its next tweet into the heap. <br>
   * So after adding all heads we only need to add 9 tweets at most into this heap
   * before we get the 10 most recent tweet.
   * 
   * @param userId
   * @return
   */
  public List<Integer> getNewsFeed(int userId) {
    User user = users.get(userId);
    List<Integer> tweets = new LinkedList<>();
    if (user == null) {
      return tweets;
    }
    Set<Integer> following = user.getFollowing();
    PriorityQueue<Tweet> queue = new PriorityQueue<>(following.size(),
        new Comparator<Tweet>() {
          public int compare(Tweet a, Tweet b) {
            return b.time - a.time;
          }
        });
    for (int id : following) {
      Tweet tweetHead = users.get(id).getTweetHead();
      /**
       * very important! If we add null to the head we are screwed.
       */
      if (tweetHead != null) {
        queue.offer(tweetHead);
      }
    }
    int i = 0;
    while (i < 10 && !queue.isEmpty()) {
      Tweet tweet = queue.poll();
      tweets.add(tweet.id);
      i++;
      if (tweet.next != null) {
        queue.offer(tweet.next);
      }
    }
    return tweets;
  }

  /**
   * Follower follows a followee. If the operation is invalid, it should be a
   * no-op.
   * 
   * @param followerId
   * @param followeeId
   */
  public void follow(int followerId, int followeeId) {
    User follower = users.get(followerId);
    if (follower == null) {
      follower = new User(followerId);
      users.put(followerId, follower);
    }
    User followee = users.get(followeeId);
    if (followee == null) {
      followee = new User(followeeId);
      users.put(followeeId, followee);
    }
    follower.follow(followeeId);
  }

  /**
   * Follower unfollows a followee. If the operation is invalid, it should be a
   * no-op.
   * 
   * @param followerId
   * @param followeeId
   */
  public void unfollow(int followerId, int followeeId) {
    User follower = users.get(followerId);
    User followee = users.get(followeeId);
    if (follower == null || followee == null || followeeId == followerId) {
      return;
    }
    follower.unfollow(followeeId);
  }
}

/**
 * Your Twitter object will be instantiated and called as such: Twitter obj =
 * new Twitter(); obj.postTweet(userId,tweetId); List<Integer> param_2 =
 * obj.getNewsFeed(userId); obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */