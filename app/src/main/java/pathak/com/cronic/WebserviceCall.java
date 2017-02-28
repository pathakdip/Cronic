package pathak.com.cronic;

import android.app.ProgressDialog;
import android.app.VoiceInteractor;
import android.content.Context;
import android.os.AsyncTask;
import android.support.test.espresso.core.deps.guava.net.MediaType;

import com.squareup.okhttp.OkHttpClient;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

/**
 * Created by Dip on 2/27/2017.
 */
public class WebserviceCall extends AsyncTask<Void,Void,String> {

    private final MediaType URLENCODE = MediaType.parse("application/json;charset=utf-8");
    AsyncResponse delegate;
    ProgressDialog dialog;
    Context context;
    String dialogMessage;
    boolean showDialog = true;
    String URL;
    String jsonBody;
    public WebserviceCall(Context context, String url, String jsonRequestBody, String dialogMessage, boolean showDialog, AsyncResponse delegate) {
        this.context = context;
        this.URL = URL;
        this.jsonBody = jsonRequestBody;
        this.dialogMessage = dialogMessage;
        this.showDialog = showDialog;
        this.delegate = delegate;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if(showDialog){
            dialog=new ProgressDialog(context);
            dialog.setMessage(dialogMessage);
            dialog.show();
        }
    }

    @Override
    protected String doInBackground(Void... params) {
        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(10L, TimeUnit.SECONDS);
        RequestBody body;
        if(jsonBody != null) {
            body = RequestBody.create(URLENCODE, jsonBody);
        }else{
            body = null;
        };

        VoiceInteractor.Request request = new VoiceInteractor.Request.Builder()
                .post(body)
                .url(URL)
                .build();


        try {
            Response response = client.newCall(request).execute();
            return response.body().string();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
