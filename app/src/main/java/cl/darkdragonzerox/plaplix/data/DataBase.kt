package cl.darkdragonzerox.plaplix.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ProductDao{
    @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun LoadAllProducts(productList:List<Products>)

    @Query("SELECT * FROM products")
    fun getProducts(): LiveData<List<Products>>

    @Query("SELECT * FROM products WHERE id=:idCode")
    fun getCardDetail(idCode:Int): LiveData<Products>

    @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun LoadAllProductsDetail(detailList:List<ProductsDetail>)

    @Query("SELECT * FROM products_detail")
    fun getDetail(): LiveData<List<ProductsDetail>>

    @Query("SELECT * FROM products_detail WHERE id=:idCode")
    fun getProductDetail(idCode:Int): LiveData<ProductsDetail>

}

@Database(entities = [Products::class, ProductsDetail::class],version = 1)

abstract class ProductsDataBase : RoomDatabase(){
    abstract fun productsDao():ProductDao
}
class MagicApplication : Application(){
    companion object{
        var productsDataBase: ProductsDataBase? =null
    }

    override fun onCreate() {
        super.onCreate()
        productsDataBase= Room
            .databaseBuilder(this,ProductsDataBase::class.java,"db_MagicCards").build()
    }
}