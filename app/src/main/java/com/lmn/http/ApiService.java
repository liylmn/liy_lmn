/*
 *    Copyright (C) 2016 Tamic
 *
 *    link :https://github.com/Tamicer/Novate
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.lmn.http;


import com.lmn.Entity.DetailEntity;
import com.lmn.Entity.HomeFragmentEntity;
import com.lmn.Entity.LoginEntity;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * ApiService
 * Created by Tamic on 2016-06-03.
 */
public interface ApiService {

    @POST("api/fault/train/all")
    Observable<HomeFragmentEntity> getall();

    @FormUrlEncoded
    @POST("api/fault/login")
    Observable<LoginEntity> login(@Field("studentNumber")String mobile, @Field("password")String code);

    @FormUrlEncoded
    @POST("api/fault/info")
    Observable<DetailEntity> getinfo(@Field("typeId")String typeId, @Field("pageNum")String pageNum, @Field("pageSize")String pageSize);
}


