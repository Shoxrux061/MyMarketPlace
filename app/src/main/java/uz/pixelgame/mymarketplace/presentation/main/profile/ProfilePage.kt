package uz.pixelgame.mymarketplace.presentation.main.profile

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.pixelgame.mymarketplace.R
import uz.pixelgame.mymarketplace.databinding.PageProfileBinding
import uz.pixelgame.mymarketplace.presentation.base.BaseFragment

class ProfilePage : BaseFragment(R.layout.page_profile){

    private val binding by viewBinding(PageProfileBinding::bind)

    override fun onCreate(view: View, savedInstanceState: Bundle?) {

    }
}
