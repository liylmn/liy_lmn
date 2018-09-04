package com.lmn.view.main.homefragment;

import io.reactivex.Observable;
import lmn.com.lmnlibrary.http.BaseApiService;
import okhttp3.ResponseBody;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @author：LiuXiaoDong on 2018/4/20 18:26.
 */

public interface HomeFragmentService extends BaseApiService {

    @FormUrlEncoded
    @POST("api/fault/train/all")
    Observable<ResponseBody> getall();

}
