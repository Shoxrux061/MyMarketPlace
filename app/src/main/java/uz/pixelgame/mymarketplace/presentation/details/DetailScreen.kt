package uz.pixelgame.mymarketplace.presentation.details

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.pixelgame.mymarketplace.R
import uz.pixelgame.mymarketplace.databinding.ScreenDetailBinding
import uz.pixelgame.mymarketplace.presentation.base.BaseFragment

class DetailScreen : BaseFragment(R.layout.screen_detail){

    private val binding by viewBinding(ScreenDetailBinding::bind)

    override fun onCreate(view: View, savedInstanceState: Bundle?) {

    }
}
