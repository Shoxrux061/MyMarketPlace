package uz.pixelgame.mymarketplace.presentation.main.promotion

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.pixelgame.mymarketplace.R
import uz.pixelgame.mymarketplace.databinding.PagePromotionBinding
import uz.pixelgame.mymarketplace.presentation.base.BaseFragment

class PromotionPage : BaseFragment(R.layout.page_promotion){
    private val binding by viewBinding(PagePromotionBinding::bind)
    override fun onCreate(view: View, savedInstanceState: Bundle?) {

    }
}

