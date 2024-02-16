package uz.pixelgame.mymarketplace.presentation.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import uz.pixelgame.mymarketplace.R
import uz.pixelgame.mymarketplace.data.cache.AppCache
import uz.pixelgame.mymarketplace.presentation.base.BaseFragment


@SuppressLint("CustomSplashScreen")
class SplashScreen : BaseFragment(R.layout.screen_splash){
    override fun onCreate(view: View, savedInstanceState: Bundle?) {

        if(!AppCache.getObject().getSigned()) {
            findNavController().navigate(SplashScreenDirections.actionSplashScreenToLoginScreen())
        }else{
            findNavController().navigate(SplashScreenDirections.actionSplashScreenToMainScreen())
        }
    }
}

