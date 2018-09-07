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
import com.lmn.Entity.DetailMessageEntity;
import com.lmn.Entity.HomeFragmentEntity;
import com.lmn.Entity.LeaveMessageEntity;
import com.lmn.Entity.LoginEntity;
import com.lmn.Entity.ModifyEntity;
import com.lmn.Entity.ResouceEntity;
import com.lmn.Entity.SearchEntity;

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

    @FormUrlEncoded
    @POST("api/fault/detail")
    Observable<DetailMessageEntity> getdetailmessage(@Field("id")String id);

    @FormUrlEncoded
    @POST("api/fault/resource")
    Observable<ResouceEntity> getresource(@Field("pageNum")String pageNum, @Field("pageSize")String pageSize);


    @FormUrlEncoded
    @POST("api/fault/message/add")
    Observable<LeaveMessageEntity> leavemessage(@Field("userId")String userId, @Field("content")String content);

    @FormUrlEncoded
    @POST("api/fault/update/pwd")
    Observable<ModifyEntity> modifypsw(@Field("studentNumber")String studentNumber, @Field("password")String password, @Field("newPassword")String newPassword);

    @FormUrlEncoded
    @POST("api/fault/search")
    Observable<SearchEntity> search(@Field("name")String name, @Field("resultType")String resultType);
}


