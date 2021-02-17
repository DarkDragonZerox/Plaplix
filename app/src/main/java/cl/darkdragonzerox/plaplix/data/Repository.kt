package cl.darkdragonzerox.plaplix.data

import android.util.Log
import androidx.lifecycle.LiveData
import cl.darkdragonzerox.plaplix.data.ProductsApplication.Companion.productsDataBase

class Repository {
    private val productDatabase = ProductsApplication.productsDataBase!!
    val productList = productDatabase.productsDao().getProducts()
   // val detailList = productDatabase.productsDao().getProductDetail()

    suspend fun getProductsFromApi() {

        val response = RetrofitClient.retrofitCliente().getProducts()

        when (response.isSuccessful) {

            true -> {
                response.body()?.let {

                    productsDataBase?.productsDao()?.LoadAllProducts(it)

                }
            }

            false -> {
                Log.d("errores ","${response.code()}")
                Log.d("errores ","${response.headers()}")
                Log.d("errores ","${response.errorBody()}")
            }
        }




    }

    fun getProduct(idCode: Int): LiveData<Products> {
        return productDatabase.productsDao().getProductId(idCode)
    }

    fun loadProduct(): LiveData<List<Products>> {
        return productDatabase.productsDao().getProducts()
    }

    suspend fun getProductDetail(idCode: Int) {
        val responseDetail = RetrofitClient.retrofitCliente().getDetails(idCode)
        when (responseDetail.isSuccessful) {

            true -> {
                responseDetail.body()?.let {
                    Log.d("response","${responseDetail.body()}")
                   productDatabase.productsDao().LoadAllProductsDetail(idCode)

                }
            }

            false -> {
                Log.d("errores2 ","${responseDetail.code()}")
                Log.d("errores2 ","${responseDetail.headers()}")
                Log.d("errores2 ","${responseDetail.errorBody()}")
            }
        }


    }
    fun getById(idCode: Int):LiveData<ProductsDetail>{
        return productDatabase.productsDao().getProductDetail(idCode)
    }
}