package com.gregcoorp.trivia

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.core.app.ShareCompat
//import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.gregcoorp.trivia.databinding.FragmentGameWonBinding


class GameWonFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentGameWonBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_game_won, container, false)

        // Restart the quiz
        binding.nextMatchButton.setOnClickListener {
            it.findNavController().navigate(GameWonFragmentDirections.actionGameWonFragmentToGameFragment())
        }

        // Tell Android that our Fragment has a menu
        setHasOptionsMenu(true)

        return binding.root
    }

    // Where you inflate your menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.winner_menu, menu)
        // check if the activity resolves
        if (null == getShareIntent().resolveActivity(requireActivity().packageManager)) {
            // hide the menu item if it doesn't resolve
            menu.findItem(R.id.share).isVisible = false
        }
    }

    // Called when a menu item is selected
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }

    // Create our share Implicit intent
    private fun getShareIntent(): Intent {
        // Get the arguments from GameFragment
        val args = GameWonFragmentArgs.fromBundle(requireArguments())
        val str = getString(R.string.share_success_text, args.numCorrect, args.numQuestions)
//        // The intent (method 1)
//        val shareIntent = Intent(Intent.ACTION_SEND)
//        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, str)
//        return shareIntent
        // The intent (method 2)
        return ShareCompat.IntentBuilder.from(requireActivity())
            .setText(str)
            .setType("text/plain")
            .intent
    }

    private fun shareSuccess() {
        startActivity(getShareIntent())
    }
}
