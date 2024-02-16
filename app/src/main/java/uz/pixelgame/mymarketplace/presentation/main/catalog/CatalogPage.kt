package uz.pixelgame.mymarketplace.presentation.main.catalog

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.pixelgame.mymarketplace.R
import uz.pixelgame.mymarketplace.databinding.PageCatalogBinding
import uz.pixelgame.mymarketplace.presentation.MyViewModel
import uz.pixelgame.mymarketplace.presentation.adapter.CatalogAdapter
import uz.pixelgame.mymarketplace.presentation.base.BaseFragment
import uz.pixelgame.mymarketplace.utill.GridSpacingItemDecoration

class CatalogPage : BaseFragment(R.layout.page_catalog) {
    private val binding by viewBinding(PageCatalogBinding::bind)
    private val viewModel: MyViewModel by viewModels()
    private val adapter = CatalogAdapter()
    override fun onCreate(view: View, savedInstanceState: Bundle?) {
        setAdapter()
        viewModel.getProducts()
        observe()
        radioGroupState()

    }

    private fun radioGroupState() {
        setRadioButtonListener(binding.rdbtn1, false){ isChecked->
            if(isChecked){
                binding.rdbtn1.text = getString(R.string.lookAll).plus(" ✖")
                binding.rdbtn1.setTextColor(requireContext().getColor(R.color.checkedTextColor))
            }else{
                binding.rdbtn1.text = getString(R.string.lookAll)
                binding.rdbtn1.setTextColor(requireContext().getColor(R.color.notCheckedTextColor))
            }
        }
        setRadioButtonListener(binding.rdbtn2, false){ isChecked->
            if(isChecked){
                binding.rdbtn2.text = getString(R.string.face).plus(" ✖")
                binding.rdbtn2.setTextColor(requireContext().getColor(R.color.checkedTextColor))
            }else{
                binding.rdbtn2.text = getString(R.string.face)
                binding.rdbtn2.setTextColor(requireContext().getColor(R.color.notCheckedTextColor))
            }
        }
        setRadioButtonListener(binding.rdbtn3, false){ isChecked->
            if(isChecked){
                binding.rdbtn3.text = getString(R.string.body).plus(" ✖")
                binding.rdbtn3.setTextColor(requireContext().getColor(R.color.checkedTextColor))
            }else{
                binding.rdbtn3.text = getString(R.string.body)
                binding.rdbtn3.setTextColor(requireContext().getColor(R.color.notCheckedTextColor))
            }
        }
        setRadioButtonListener(binding.rdbtn4, false){ isChecked->
            if(isChecked){
                binding.rdbtn4.text = getString(R.string.zagar).plus(" ✖")
                binding.rdbtn4.setTextColor(requireContext().getColor(R.color.checkedTextColor))
            }else{
                binding.rdbtn4.text = getString(R.string.zagar)
                binding.rdbtn4.setTextColor(requireContext().getColor(R.color.notCheckedTextColor))
            }
        }
        setRadioButtonListener(binding.rdbtn5, false){ isChecked->
            if(isChecked){
                binding.rdbtn5.text = getString(R.string.mask).plus(" ✖")
                binding.rdbtn5.setTextColor(requireContext().getColor(R.color.checkedTextColor))
            }else{
                binding.rdbtn5.text = getString(R.string.mask)
                binding.rdbtn5.setTextColor(requireContext().getColor(R.color.notCheckedTextColor))
            }
        }

    }

    private fun setRadioButtonListener(radioButton: RadioButton, checked: Boolean, isChecked: (Boolean) -> Unit) {
        radioButton.isChecked = checked
        radioButton.setOnCheckedChangeListener { _, isChecked1 ->
            isChecked(isChecked1)
        }
    }

    private fun observe() {
        viewModel.successResponseEvery.observe(viewLifecycleOwner) {
            adapter.setData(it!!)
        }
    }

    private fun setAdapter() {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(context, 2)
        binding.recyclerView.addItemDecoration(GridSpacingItemDecoration(2, 20, true))
    }
}