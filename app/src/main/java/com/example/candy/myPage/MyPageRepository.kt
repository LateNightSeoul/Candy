package com.example.candy.myPage

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.candy.model.api.CandyApi
import com.example.candy.model.api.RetrofitClient
import com.example.candy.model.api.UserInfoApi
import com.example.candy.model.data.*
import com.example.candy.utils.API.BASE_URL
import com.example.candy.utils.CurrentUser
import com.example.candy.utils.RESPONSE_STATE
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyPageRepository(application: Application) {
    val TAG: String = "로d그"
    private val retrofit = RetrofitClient.getClient(BASE_URL)
    private val apiCandy = retrofit.create(CandyApi::class.java)
    private val apiUserInfo = retrofit.create(UserInfoApi::class.java)


    fun getUserInfo(): User {
        return CurrentUser.userInfo!!
    }

    fun getAPIUserInfo(apiKey: String): LiveData<UserInfo> {
        val data = MutableLiveData<UserInfo>()
        apiUserInfo.getUserInfo(apiKey).enqueue(object : Callback<UserInfoResponse> {
            override fun onResponse(
                call: Call<UserInfoResponse>,
                response: Response<UserInfoResponse>
            ) {
                if (response.code() == 200) {
                    var userInfo = response.body()?.response
                    userInfo?.birth!!.replace("-", "").also { userInfo.birth = it }
                    userInfo.phone.replace("-", "").also { userInfo.phone = it }
                    data.value = userInfo!!
                }
            }

            override fun onFailure(call: Call<UserInfoResponse>, t: Throwable) {
                Log.d(TAG, "MyPageRepository - onFailure() called")
            }
        })

        return data
    }

    fun updateAPIUserInfoChange(
        apiKey: String,
        data: HashMap<String, Any>,
        completion: (RESPONSE_STATE) -> Unit
    ) {
        apiUserInfo.updateUserInfo(apiKey, data).enqueue(object : Callback<UserInfoResponse> {
            override fun onResponse(
                call: Call<UserInfoResponse>,
                response: Response<UserInfoResponse>
            ) {
                if (response.code() == 200 && response.body()?.success!!) {
                    completion(RESPONSE_STATE.SUCCESS)
                } else
                    completion(RESPONSE_STATE.FAILURE)
            }

            override fun onFailure(call: Call<UserInfoResponse>, t: Throwable) {
                completion(RESPONSE_STATE.FAILURE)
            }
        })
    }

    fun getAPICandyStudent(apiKey: String) {
        apiCandy.getCandyStudent(apiKey).enqueue(object : Callback<CandyResponse> {
            override fun onResponse(call: Call<CandyResponse>, response: Response<CandyResponse>) {
                CurrentUser.studentCandy.value = response.body()!!.candy
            }

            override fun onFailure(call: Call<CandyResponse>, t: Throwable) {
                Log.d(TAG, "Repository - onFailure() called")
            }
        })
    }

    fun getAPICandyParent(apiKey: String) {
        apiCandy.getCandyParent(apiKey).enqueue(object : Callback<CandyResponse> {
            override fun onResponse(call: Call<CandyResponse>, response: Response<CandyResponse>) {
                CurrentUser.parentCandy.value = response.body()!!.candy
            }

            override fun onFailure(call: Call<CandyResponse>, t: Throwable) {
                Log.d(TAG, "Repository - onFailure() called")
            }
        })
    }

    fun getCandyStudent(): LiveData<Candy> {
        return CurrentUser.studentCandy
    }

    fun getCandyParent(): LiveData<Candy> {
        return CurrentUser.parentCandy
    }

    fun updateCandyParent(apiKey: String, chargeCandy: HashMap<String, Int>) {
        apiCandy.chargeCandy(apiKey, chargeCandy).enqueue(object : Callback<chargeCandyResponse> {
            override fun onResponse(
                call: Call<chargeCandyResponse>,
                response: Response<chargeCandyResponse>
            ) {
                if (response.code() == 200 && response.body()!!.success) {
                    CurrentUser.parentCandy.value = Candy(response.body()!!.response.candy)
                }
            }

            override fun onFailure(call: Call<chargeCandyResponse>, t: Throwable) {

            }
        })
    }

    fun changePw(apiKey: String, data: HashMap<String, Any>, completion: (RESPONSE_STATE) -> Unit) {
        apiUserInfo.changePw(apiKey, data).enqueue(object : Callback<UserChangePwResponse> {
            override fun onResponse(
                call: Call<UserChangePwResponse>,
                response: Response<UserChangePwResponse>
            ) {
                Log.d(TAG, "MyPageRepository - onResponse() + responseCode = ${response.code()}")
                if (response.code() == 200) {
                    completion(RESPONSE_STATE.SUCCESS)
                } else {
                    completion(RESPONSE_STATE.FAILURE)
                }
            }

            override fun onFailure(call: Call<UserChangePwResponse>, t: Throwable) {
                Log.d(TAG, "api 요청 실패")
                completion(RESPONSE_STATE.FAILURE)
            }


        })
    }
}