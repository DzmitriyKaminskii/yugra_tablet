package com.vlr.dk.yugratablet.detail_screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.vlr.dk.yugratablet.R
import com.vlr.dk.yugratablet.databinding.LifeDetailFragmentBinding
import com.vlr.dk.yugratablet.utils.RES_ID

private val titleList = listOf(
    "Строительство",
    "Медицина",
    "Спорт",
    "Транспорт",
    "Обучение",
    "Дети"
)

private val contentResId = listOf(
    R.drawable.work_doc
)

private var resId: Int? = null

class LifeDetailFragment : Fragment() {

    private var _binding: LifeDetailFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            resId = it.getInt(RES_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LifeDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateUIWithAnimation()
        bindingAction()
    }

    private fun updateUIWithAnimation() {
        resId?.let {
            binding.navTitle.text = titleList[it]
            binding.mainImageBlock.setImageResource(contentResId[0])
        }
    }

    private fun bindingAction() {
        binding.backAction.setOnClickListener {
            it.findNavController().popBackStack()
        }
    }
}