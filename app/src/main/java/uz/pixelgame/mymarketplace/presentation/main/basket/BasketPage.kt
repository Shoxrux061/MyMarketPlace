package uz.pixelgame.mymarketplace.presentation.main.basket

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.pixelgame.mymarketplace.R
import uz.pixelgame.mymarketplace.databinding.PageBasketBinding
import uz.pixelgame.mymarketplace.presentation.base.BaseFragment

class BasketPage : BaseFragment(R.layout.page_basket){
    private val binding by viewBinding(PageBasketBinding::bind)
    override fun onCreate(view: View, savedInstanceState: Bundle?) {

    }
}
