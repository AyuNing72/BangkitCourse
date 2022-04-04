package com.example.github_user_navigationapi.api

import com.example.github_user_navigationapi.data.model.DetailUserResponse
import com.example.github_user_navigationapi.data.model.User
import com.example.github_user_navigationapi.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    @Headers("Authorization: token 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")
    fun getSearchUsers(
        @Query("q") query: String
    ): Call<UserResponse>

    @GET("users/{username}")
    @Headers("Authorization: token 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")
    fun getUserDetail(
        @Path("username") username: String
    ):Call<DetailUserResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: token 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")
    fun getFollowers(
        @Path("username") username: String
    ):Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token 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")
    fun getFollowing(
        @Path("username") username: String
    ):Call<ArrayList<User>>
}