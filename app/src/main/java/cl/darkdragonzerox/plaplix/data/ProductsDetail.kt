package cl.darkdragonzerox.plaplix.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products_detail")
data class ProductsDetail(@PrimaryKey val id: Int,
                          val name:String,
                          val price:Int,
                          val image:String,
                          val descripcion:String,
                          val lastPrice: Int,
                          val credit:Boolean
                          )