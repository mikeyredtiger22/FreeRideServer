package FCM;

import com.google.common.base.Functions;
import com.google.common.collect.Ordering;

import java.util.*;

public class NewTaskReplyData {

    Map<String, Integer> replyData;

    public NewTaskReplyData() {
        replyData = new HashMap<>();//todo error?
    }

    public void addData(String userId, Integer userScore) {
        replyData.put(userId, userScore);
    }

    public Map<String, Integer> getData() {
        return replyData;
    }

    //Using Google Guava library to sort map by value and return first N values
    public List<String> getTopUsers(int amount) {
        if (replyData.size() <= amount) {
            return new ArrayList<>(replyData.keySet()); //todo error?
        }
        //Order on values
        Ordering<String> ordering = Ordering.natural().onResultOf(Functions.forMap(replyData));
        //Retrieve first N values, return as Set
        return ordering.greatestOf(replyData.keySet(), amount);
    }
}