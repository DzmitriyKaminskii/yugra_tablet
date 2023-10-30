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
    R.drawable.cr1,
    R.drawable.med,
    R.drawable.sport,
    R.drawable.trans,
    R.drawable.cr2,
    R.drawable.cr3
)

private var resId: Int? = null
private var minId = 0
private val maxId = 5

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

        this.updateUI()
        bindingAction()
    }

    private fun updateUI() {
        resId?.let {
            binding.navTitle.text = titleList[it]
            binding.mainImageBlock.setImageResource(contentResId[it])
        }
    }

    private fun moveBack() {
        resId?.let {
            resId = if (it > minId) {
                it - 1
            } else {
                maxId
            }
            updateUI()
        }
    }

    private fun moveForward() {
        resId?.let {
            resId = if (it < maxId) {
                it + 1
            } else {
                minId
            }
            updateUI()
        }
    }

    private fun bindingAction() {
        binding.backAction.setOnClickListener {
            it.findNavController().popBackStack(R.id.navFragment, false)
        }

        binding.navActionBack.setOnClickListener { moveBack() }
        binding.navActionForward.setOnClickListener { moveForward() }
    }
}