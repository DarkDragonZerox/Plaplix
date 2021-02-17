package cl.darkdragonzerox.plaplix.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Products(@PrimaryKey val id: Int, val name:String, val price: Int, val image:String)
