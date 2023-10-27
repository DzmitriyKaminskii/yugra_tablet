package com.vlr.dk.yugratablet

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.AbsoluteSizeSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vlr.dk.yugratablet.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {

    private var _binding: HomeFragmentBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val yugraString = resources.getString(R.string.home_screen_yugre)

        binding.lifeTextView.text = SpannableStringBuilder()
            .append(
                resources.getString(R.string.home_screen_life),
                AbsoluteSizeSpan(resources.getDimensionPixelSize(R.dimen.home_screen_title_size)),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            .append("\n")
            .append(
                yugraString,
                AbsoluteSizeSpan(resources.getDimensionPixelSize(R.dimen.home_screen_yugre_size)),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )

        binding.restTextView.text = SpannableStringBuilder()
            .append(
                resources.getString(R.string.home_screen_rest),
                AbsoluteSizeSpan(resources.getDimensionPixelSize(R.dimen.home_screen_title_size)),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            .append("\n")
            .append(
                yugraString,
                AbsoluteSizeSpan(resources.getDimensionPixelSize(R.dimen.home_screen_yugre_size)),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )

        binding.workTextView.text = SpannableStringBuilder()
            .append(
                resources.getString(R.string.home_screen_work),
                AbsoluteSizeSpan(resources.getDimensionPixelSize(R.dimen.home_screen_title_size)),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            .append("\n")
            .append(
                yugraString,
                AbsoluteSizeSpan(resources.getDimensionPixelSize(R.dimen.home_screen_yugre_size)),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )

    }

}