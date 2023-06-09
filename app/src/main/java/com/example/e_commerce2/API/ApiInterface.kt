package com.example.e_commerce2.API

import com.example.e_commerce2.Extra.Model
import com.example.e_commerce2.Extra.ModelOrder
import com.example.e_commerce2.Extra.ModelUser
import com.example.e_commerce2.Extra.ModelUserAddress
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @FormUrlEncoded
    @POST("insertuser.php")
    fun insertuser(
        @Field("userid") user_id: String,
        @Field("name") user_name:String,
        @Field("email") user_email:String,
        @Field("image") user_image:String,
        @Field("number") user_number:String,
    ): Call<Void>

    @FormUrlEncoded
    @POST("useraddressinsert.php")
    fun useraddressinsert(
        @Field("uid") user_id: String,
        @Field("street") street:String,
        @Field("city") city:String,
        @Field("state") state:String,
        @Field("zipcode") zipcode:String,
        @Field("country") country:String,
    ): Call<Void>

//    @GET("userview.php")
//    fun getuser(
//        @Query("email") user_email:String,
//        @Query("password") user_password:String,
//    ): Call<ModelUser>

    @GET("useridview.php")
    fun getiduser(
        @Query("userid") user_id:String,
    ): Call<ModelUser>

    @GET("useraddressidview.php")
    fun useraddressidview(
        @Query("uid") user_id:String,
    ): Call<List<ModelUserAddress>>



    @FormUrlEncoded
    @POST("userupdate.php")
    fun updatedata(
        @Field("uid") uid:Int,
        @Field("userid") user_id: String,
        @Field("name") user_name:String,
        @Field("email") user_email:String,
        @Field("image") user_image:String,
        @Field("number") user_number:String,
    ): Call<Void>

    @GET("dataview.php")
    fun getdata(): Call<List<Model>>

    @GET("dataidview.php")
    fun getiddata(
        @Query("pid") product_id:Int,
    ): Call<Model>

    @GET("favidview.php")
    fun getidfav(
        @Query("uid") user_id:String,
    ): Call<List<Model>>

    @FormUrlEncoded
    @POST("favinsert.php")
    fun insertfav(
        @Field("pid") product_id:Int,
        @Field("uid") user_id:String,
    ): Call<Void>

    @GET("checkfav.php")
    fun getcheckfav(
        @Query("pid") product_id:Int,
        @Query("uid") user_id:String,
    ): Call<Model>

    @GET("favdelete.php")
    fun getfavdelete(
        @Query("pid") product_id:Int,
        @Query("uid") user_id:String,
    ): Call<Void>

    @FormUrlEncoded
    @POST("cartinsert.php")
    fun cartinsert(
        @Field("pid") product_id:Int,
        @Field("uid") user_id:String,
        @Field("qty") product_quantity:Int,
    ): Call<ResponseBody>

    @GET("cartdelete.php")
    fun cartdelete(
        @Query("pid") product_id:Int,
        @Query("uid") user_id:String,
    ): Call<Void>

    @GET("cartidview.php")
    fun cartidview(
        @Query("uid") user_id:String,
    ): Call<List<Model>>

    @GET("cartcheck.php")
    fun cartcheck(
        @Query("pid") product_id:Int,
        @Query("uid") user_id:String,
    ): Call<Model>

    @FormUrlEncoded
    @POST("cartupdate.php")
    fun cartupdate(
        @Field("pid") product_id: Int,
        @Field("uid") user_id:String,
        @Field("qty") product_quantity: Int,
    ): Call<Void>

    @FormUrlEncoded
    @POST("primaryaddress.php")
    fun setprimary(
        @Field("uid") user_id:String,
        @Field("aid") address_id:Int,
    ): Call<ResponseBody>

    @GET("primaryaddressview.php")
    fun primaryaddressview(
        @Query("uid") user_id:String,
    ): Call<List<ModelUserAddress>>

    @FormUrlEncoded
    @POST("orderinsert.php")
    fun orderinsert(
        @Field("uid") user_id:String,
        @Field("pid") product_id:Int,
        @Field("qty") quantity:Int,
        @Field("aid") address_id:Int
    ): Call<Void>

    @GET("orderidview.php")
    fun orderidview(
        @Query("uid") user_id:String,
    ): Call<List<ModelOrder>>

}