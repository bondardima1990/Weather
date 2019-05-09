package com.dima.weather.services.rest;

import com.dima.weather.utils.Constants;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class RestClient {

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public static RestApi createApi(){
        Retrofit.Builder builder = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL);


        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        Request.Builder newBuilder = request.newBuilder();
                        //TODO add actions to request
                        Request  newRequest = newBuilder.build();

                        Response response = null;
                        String newStringBody = "";
                        try {
                            response = chain.proceed(newRequest);
                            ResponseBody body = response.body();
                            Timber.d("HTTP " + response.code() + " URL=" + response.request().url().toString());
                            String bodyString = body.string();
                            Timber.d(bodyString);
                            if (bodyString.startsWith("[")) {
                                newStringBody = "{\"data\":" + bodyString + "}";
                            }
                            else if (bodyString == null || bodyString.isEmpty()){
                                newStringBody = "{}";
                            }
                            else {
                                newStringBody = bodyString;
                            }
                            Timber.d(newStringBody);
                            final Response.Builder newResponse = response.newBuilder()
                                    .body(ResponseBody.create(JSON, newStringBody));
                            response = newResponse.build();
                        } catch (IOException e) {
                            e.printStackTrace();
                            //TODO do all staff with broken internet connection
                        }
                        //TODO add actions with response
                        return response;
                    }
                })
                .build();
        builder.client(client);
        return builder.build().create(RestApi.class);
    }
}
