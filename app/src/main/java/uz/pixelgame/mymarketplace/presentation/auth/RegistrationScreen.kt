package uz.pixelgame.mymarketplace.presentation.auth

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.pixelgame.mymarketplace.R
import uz.pixelgame.mymarketplace.databinding.ScreenRegistrationBinding
import uz.pixelgame.mymarketplace.presentation.base.BaseFragment

class RegistrationScreen : BaseFragment(R.layout.screen_registration){
    private val binding by viewBinding(ScreenRegistrationBinding::bind)
    override fun onCreate(view: View, savedInstanceState: Bundle?) {

    }
}
