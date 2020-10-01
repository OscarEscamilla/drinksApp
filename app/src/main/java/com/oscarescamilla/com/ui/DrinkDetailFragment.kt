package com.oscarescamilla.com.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oscarescamilla.com.R
import com.oscarescamilla.com.data.model.Drink


class DrinkDetailFragment : Fragment() {


    private lateinit var drink: Drink

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let {data ->
                drink = data.getParcelable<Drink>("drink")!!
            Log.i("drink", "$drink ")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drink_detail, container, false)
    }




}