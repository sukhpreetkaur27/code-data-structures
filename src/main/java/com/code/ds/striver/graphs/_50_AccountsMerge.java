package com.code.ds.striver.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails 
 * representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common email to both accounts. Note that even if two accounts 
have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, 
but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. 
The accounts themselves can be returned in any order.

 

Example 1:

Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
Explanation:
The first and second John's are the same person as they have the common email "johnsmith@mail.com".
The third John and Mary are different people as none of their email addresses are used by other accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
Example 2:

Input: accounts = [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],
["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
Output: [["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],
["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"]]
 

Constraints:

1 <= accounts.length <= 1000
2 <= accounts[i].length <= 10
1 <= accounts[i][j].length <= 30
accounts[i][0] consists of English letters.
accounts[i][j] (for j > 0) is a valid email.
 * 
 * @author sukh
 *
 */
public class _50_AccountsMerge {

  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    /**
     * DSU
     * 
     * Consider each account as a node, i.e., a single component
     * 
     * map email to node
     * 
     * if email exists, merge the node with the parent
     * 
     * create an array of list of emails of size n (components)
     * 
     * merge emails to the ultimate parent node
     * 
     * modify the result as per the requirement
     */
    int n = accounts.size();
    Map<String, Integer> emailParentMap = new HashMap<>();
    _0_DisjointSet_UnionFind obj = new _0_DisjointSet_UnionFind(n);
    /**
     * 0-based indexing --> n nodes
     */
    for (int i = 0; i < n; i++) {
      List<String> account = accounts.get(i);
      for (int j = 1; j < account.size(); j++) {
        String email = account.get(j);
        /**
         * if email exists --> get its node
         */
        int parent = emailParentMap.getOrDefault(email, -1);
        if (parent == -1) {
          /**
           * for new email --> add it to map with the current node
           */
          emailParentMap.put(email, i);
        } else {
          /**
           * for existing email --> union the current node with the existing node
           */
          obj.unionBySize(parent, i);
        }
      }
    }
    /**
     * Array of List of email per node
     */
    List<String>[] emails = new List[n];
    for (int i = 0; i < n; i++) {
      emails[i] = new ArrayList<String>();
    }
    /**
     * Merge emails to ultimate parent node
     */
    for (Map.Entry<String, Integer> entry : emailParentMap.entrySet()) {
      String email = entry.getKey();
      Integer parent = entry.getValue();
      int ultimateParent = obj.find(parent);
      emails[ultimateParent].add(email);
    }
    List<List<String>> result = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      List<String> email = emails[i];
      /**
       * for nodes with no email after merging
       */
      if (email.isEmpty()) {
        continue;
      }
      /**
       * sort emails
       */
      Collections.sort(email);
      List<String> account = new ArrayList<>();
      /**
       * add account name
       */
      account.add(accounts.get(i).get(0));
      account.addAll(email);
      result.add(account);
    }
    return result;
  }

  public static void main(String[] args) {
    _50_AccountsMerge obj = new _50_AccountsMerge();
    List<List<String>> accounts = new ArrayList<>();
    int n = 4;
    for (int i = 0; i < n; i++) {
      List<String> account1 = new ArrayList<>();
      account1.add("John");
      account1.add("johnsmith@mail.com");
      account1.add("john_newyork@mail.com");
      accounts.add(account1);
      List<String> account2 = new ArrayList<>();
      account1.add("John");
      account1.add("johnsmith@mail.com");
      account1.add("john00@mail.com");
      accounts.add(account2);
      List<String> account3 = new ArrayList<>();
      account1.add("Mary");
      account1.add("mary@mail.com");
      accounts.add(account3);
      List<String> account4 = new ArrayList<>();
      account1.add("John");
      account1.add("johnnybravo@mail.com");
      accounts.add(account4);
    }
    List<List<String>> result = obj.accountsMerge(accounts);
    for (List<String> i : result) {
      System.out.print(i.toString());
      System.out.println();
    }
  }

}
