package cl.darkdragonzerox.plaplix

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import cl.darkdragonzerox.plaplix.databinding.ActivityMainBinding
import cl.darkdragonzerox.plaplix.databinding.FragmentListBinding

class ListFragment:Fragment(), OnItemClickListener {
    private lateinit var binding: FragmentListBinding
    private val viewModel:ProductViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentListBinding.inflate(layoutInflater)
        val adapter=ProductAdapter(this)
        val recycler=binding.rvProducts
        recycler.adapter=adapter
        recycler.layoutManager=GridLayoutManager(context,1)

        viewModel.productlist?.observe(viewLifecycleOwner, { productlist->productlist?.let{
            adapter.updateProduct(it)
        }})


        return binding.root
    }

    override fun onClick(id: Int) {
        Log.d("id por param", "$id")
        activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_container,DetailFragment(id))?.addToBackStack("back")?.commit()


    }
}