package cl.darkdragonzerox.plaplix.data

import retrofit2.Response
import retrofit2.http.GET

interface ProductApi {
    @GET("/products")
    suspend fun getProducts(): Response<List<Products>>

    @GET("/details")
    suspend fun getDetails():Response<List<ProductsDetail>>

}