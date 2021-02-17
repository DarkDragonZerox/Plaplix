package cl.darkdragonzerox.plaplix

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import cl.darkdragonzerox.plaplix.databinding.FragmentDetailBinding
import cl.darkdragonzerox.plaplix.databinding.FragmentListBinding

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
        viewModel.

        return binding.root
    }

}