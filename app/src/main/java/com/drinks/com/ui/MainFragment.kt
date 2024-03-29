package com.drinks.com.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.drinks.com.R
import com.drinks.com.data.DataSource
import com.drinks.com.data.model.Drink
import com.drinks.com.domain.RepoImpl
import com.drinks.com.ui.Adapters.MainAdapter
import com.drinks.com.ui.viewmodel.MainViewModel
import com.drinks.com.ui.viewmodel.VMFactory
import com.drinks.com.vo.Resource
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment() : Fragment(), MainAdapter.OnDrickClickListener {

    // inyeccion de dependencia para pasar el repo al view model
    private val  viewModel by activityViewModels<MainViewModel> {
        VMFactory(
            RepoImpl(DataSource())
        )
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()


        viewModel.fetchTragosList.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                    progresBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    progresBar.visibility = View.GONE
                    // pasamos la data que llega del Success de la clase Result
                    rv_tragos.adapter = MainAdapter(requireContext(),result.data, this)
                }
                is Resource.Failure -> {
                    progresBar.visibility = View.GONE
                    Toast.makeText(requireContext(), "Fallo al cargar datos", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }


    private fun initRecycler(){
        rv_tragos.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rv_tragos.addItemDecoration(DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL))
    }


    override fun onDrinkClick(drink: Drink) {
        var bundle = Bundle()
        bundle.putParcelable("drink",drink)
        // lanzamos el detalle y enviamos por el bundle el objeto drink
        findNavController().navigate(R.id.drinkDetailFragment, bundle)
    }


}

