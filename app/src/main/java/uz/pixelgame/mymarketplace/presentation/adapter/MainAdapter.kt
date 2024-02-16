package uz.pixelgame.mymarketplace.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.pixelgame.mymarketplace.presentation.main.basket.BasketPage
import uz.pixelgame.mymarketplace.presentation.main.catalog.CatalogPage
import uz.pixelgame.mymarketplace.presentation.main.home.HomePage
import uz.pixelgame.mymarketplace.presentation.main.profile.ProfilePage
import uz.pixelgame.mymarketplace.presentation.main.promotion.PromotionPage

class MainAdapter(fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0-> HomePage()
            1-> CatalogPage()
            3-> BasketPage()
            4-> PromotionPage()
            else-> ProfilePage()
        }
    }
}