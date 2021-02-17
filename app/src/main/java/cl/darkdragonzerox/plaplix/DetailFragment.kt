package cl.darkdragonzerox.plaplix

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import cl.darkdragonzerox.plaplix.databinding.FragmentDetailBinding
import cl.darkdragonzerox.plaplix.databinding.FragmentListBinding
import coil.load

class DetailFragment(id:Int): Fragment() {
    lateinit var binding: FragmentDetailBinding
    private val viewModel:ProductViewModel by viewModels()
    private val idcode=id
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentDetailBinding.inflate(layoutInflater)
            viewModel.getDetailId(idcode)
            viewModel.getById(idcode).observe(viewLifecycleOwner,{
            it?.let{
                binding.ivImageDetail.load(it.image)
                binding.tvModeloDetail.text=it.name
                binding.tvCodigoDetail.text=it.id.toString()
                binding.tvPrecioDetail.text=it.price.toString()
                binding.tvPrecioAnteriorDetail.text=it.lastPrice.toString()
                binding.tvDescripcionDetail.text=it.descripcion
            }
        })
        Log.d("verificacion", "${idcode} lol")
        return binding.root
    }

}