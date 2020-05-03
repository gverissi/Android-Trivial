package com.gregcoorp.trivia

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.gregcoorp.trivia.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentTitleBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_title, container, false)

//        binding.playButton.setOnClickListener {
//            Navigation.findNavController(it).navigate(R.id.action_titleFragment_to_gameFragment)
//        }

//        binding.playButton.setOnClickListener {
//            it.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
//        }

        binding.playButton.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_gameFragment)
        )

        // Tell Android that our TitleFragment has a menu
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        // Inflate our new menu resource using the provided menu inflater and menu structure
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Connect the fragment_about to item about
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
    }

}
