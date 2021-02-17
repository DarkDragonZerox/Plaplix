package cl.darkdragonzerox.plaplix

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import cl.darkdragonzerox.plaplix.data.Products
import cl.darkdragonzerox.plaplix.databinding.ItemListProductBinding
import coil.load

class ProductAdapter(val listener:OnItemClickListener):RecyclerView.Adapter<ProductVH>() {
   private val productlist= mutableListOf<Products>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductVH {
        val binding =ItemListProductBinding.inflate(LayoutInflater.from(parent.context))
        return ProductVH(binding)
    }

    override fun onBindViewHolder(holder: ProductVH, position: Int) {
        val product=productlist[position]
        holder.itemView.setOnClickListener{
            listener.onClick(product.id)
        }
        holder.bind(product)
    }

    override fun getItemCount(): Int {
        return productlist.size
    }
    fun updateProduct(productList: List<Products>){
        productlist.clear()
        productlist.addAll(productList)
        notifyDataSetChanged()
        Log.d("update","$productList")
    }

}

class ProductVH(private val binding: ItemListProductBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(products:Products){

        binding.tvIdProducto.text=products.id.toString()
        binding.tvNombreEquipo.text=products.name
        binding.tvPrecioProducto.text=products.price.toString()
        binding.ivProduct.load(products.image)
    }

}
