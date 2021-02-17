package cl.darkdragonzerox.plaplix.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApi {
    @GET("products")
    suspend fun getProducts(): Response<List<Products>>

    @GET("details/{id}")
    suspend fun getDetails(@Path("id")id:Int):Response<ProductsDetail>

}