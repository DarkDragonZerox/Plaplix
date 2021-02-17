package cl.darkdragonzerox.plaplix

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.darkdragonzerox.plaplix.data.Products
import cl.darkdragonzerox.plaplix.data.ProductsDetail
import cl.darkdragonzerox.plaplix.data.Repository
import kotlinx.coroutines.launch

class ProductViewModel :ViewModel(){
    private val repository=Repository()
    val productlist=repository.productList
    val detailList=repository.detailList
    init{
        viewModelScope.launch { repository.getProductsFromApi() }
    }
    fun getProductVm(): LiveData<List<Products>>? {
        return repository.loadProduct()
    }

    fun getDetailId(idCode:Int): LiveData<ProductsDetail>? {
        return repository.getProduct(idCode)
    }

}