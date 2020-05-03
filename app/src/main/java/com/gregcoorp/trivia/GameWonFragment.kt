package com.gregcoorp.trivia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.gregcoorp.trivia.databinding.FragmentGameWonBinding


class GameWonFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentGameWonBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_game_won, container, false)
        binding.nextMatchButton.setOnClickListener {
//            it.findNavController().navigate(R.id.action_gameWonFragment_to_gameFragment)
            it.findNavController().navigate(GameWonFragmentDirections.actionGameWonFragmentToGameFragment())
        }
        // Get the arguments from GameFragment
        val args = GameWonFragmentArgs.fromBundle(requireArguments())
        Toast.makeText(context, "numCorrect: ${args.numCorrect}, numQuestions: ${args.numQuestions}", Toast.LENGTH_LONG).show()

        return binding.root
    }
}
