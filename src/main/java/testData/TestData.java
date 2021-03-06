package testData;

import java.util.HashMap;
import java.util.Map;

public class TestData {
    private static Map<String, Object> data = new HashMap<String, Object>();
    public static final String commits = "Commits";
    public static final String singleCommit = "Single Commit";
    public static final String commitWithVerification = "Commit With Verification";
    public static final String comparison = "Comparison";

    public static <T> void add(String key, T obj){
        try {
            data.put(key, obj);
        }catch (Exception e){
            data.remove(key);
        }finally {
            data.put(key, obj);
        }
    }

    public static <T> T get(String key){
        Object obj = data.get(key);
        return (T)obj;
    }
}
