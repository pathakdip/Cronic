package pathak.com.cronic;

import org.json.JSONArray;

/**
 * Created by Dip on 2/27/2017.
 */
public interface AsyncResponse {
    void onSuccess(String message, JSONArray jsonData);
    void onFailure(String message);
}
