package uz.pixelgame.mymarketplace.presentation.main.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.pixelgame.mymarketplace.R
import uz.pixelgame.mymarketplace.databinding.PageHomeBinding
import uz.pixelgame.mymarketplace.presentation.MyViewModel
import uz.pixelgame.mymarketplace.presentation.base.BaseFragment

class HomePage : BaseFragment(R.layout.page_home){
    private val binding by viewBinding(PageHomeBinding::bind)
    override fun onCreate(view: View, savedInstanceState: Bundle?) {

    }
}
