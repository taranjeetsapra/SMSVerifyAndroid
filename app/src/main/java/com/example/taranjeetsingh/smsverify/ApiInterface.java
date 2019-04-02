package com.example.taranjeetsingh.smsverify;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;


/**
 * Created by Taranjeet Singh on 17-Sep-18.
 */
public interface ApiInterface {

    @GET
    Call<ResponseBody> callSMSGateWay(@Url String url, @Query("PhoneNumber") String phoneNumber,
                                      @Query("text") String textSMS,@Query("gateway") String gateway);



}
