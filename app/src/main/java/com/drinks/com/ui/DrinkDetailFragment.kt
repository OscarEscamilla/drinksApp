package com.drinks.com.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.drinks.com.data.model.Drink
import com.drinks.com.databinding.FragmentDrinkDetailBinding
import kotlinx.android.synthetic.main.drink_row.view.*


class DrinkDetailFragment : Fragment() {


    private lateinit var drink: Drink

    private var _binding: FragmentDrinkDetailBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let {data ->
                drink = data.getParcelable<Drink>("drink")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDrinkDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       initView()
    }

    fun initView(){
        binding.drinkName.text = drink.nombre
        binding.drinkOverview.text = drink.descripcion
        Glide.with(requireActivity()).load(drink.image).centerCrop().into(binding.imgDrink)

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }




}