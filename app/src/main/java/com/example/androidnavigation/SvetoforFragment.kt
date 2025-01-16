package com.example.androidnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.androidnavigation.databinding.FragmentSvetoforBinding


class SvetoforFragment : Fragment() {
    private var _binding:FragmentSvetoforBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentSvetoforBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar: Toolbar = binding.toolbar
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.title = "Светофор"
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.redBTN.setOnClickListener {
            val name = binding.redBTN.text.toString()
            val action = SvetoforFragmentDirections.actionSvetoforFragmentToRedFragment(name)
            val extras = FragmentNavigatorExtras(
                binding.redBTN to "redBTN"
            )
            findNavController().navigate(action)
        }
        binding.yellowBTN.setOnClickListener {
            val name2 = binding.yellowBTN.text.toString()
            val action2 = SvetoforFragmentDirections.actionSvetoforFragmentToYellowFragment(name2)
            val extras = FragmentNavigatorExtras(
                binding.yellowBTN to "yellowBTN"
            )
            findNavController().navigate(action2)
        }

        binding.greenBTN.setOnClickListener {
            val name3 = binding.greenBTN.text.toString()
            val action3 = SvetoforFragmentDirections.actionSvetoforFragmentToGreenFragment(name3)
            val extras = FragmentNavigatorExtras(
                binding.greenBTN to "greenBTN"
            )
            findNavController().navigate(action3)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.exit -> {
                activity?.finishAffinity()
                Toast.makeText(requireContext(), "Программа завершена", Toast.LENGTH_LONG).show()
                true
            }
        }
        return super.onOptionsItemSelected(item)
    }


}