package cl.darkdragonzerox.plaplix.data

import androidx.lifecycle.LiveData
import cl.darkdragonzerox.plaplix.data.ProductsApplication.Companion.productsDataBase

class Repository {
    private val productDatabase = ProductsApplication.productsDataBase!!
    val productList = productsDataBase?.productsDao()?.getProducts()
    val detailList = productsDataBase?.productsDao()?.getDetail()

    suspend fun getProductsFromApi() {

        val response = RetrofitClient.retrofitCliente().getProducts()
        val responseDetail = RetrofitClient.retrofitCliente().getDetails()
        when (response.isSuccessful) {

            true -> {
                response.body()?.let {

                    productsDataBase?.productsDao()?.LoadAllProducts(it)
                }
            }

            false -> {
            }
        }
        when (responseDetail.isSuccessful) {

            true -> {
                responseDetail.body()?.let {

                    productsDataBase?.productsDao()?.LoadAllProductsDetail(it)
                }
            }

            false -> {
            }
        }


    }

    fun getProduct(idCode: Int): LiveData<Products>? {
        return productsDataBase?.productsDao()?.getProductId(idCode)
    }

    fun loadProduct(): LiveData<List<Products>>? {
        return productsDataBase?.productsDao()?.getProducts()
    }

    fun getProductDetail(idCode: Int): LiveData<ProductsDetail>? {
        return productsDataBase?.productsDao()?.getProductDetail(idCode)
    }
}