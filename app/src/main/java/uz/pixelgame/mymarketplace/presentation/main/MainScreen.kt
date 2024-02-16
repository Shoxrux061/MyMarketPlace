package uz.pixelgame.mymarketplace.presentation.main

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.pixelgame.mymarketplace.R
import uz.pixelgame.mymarketplace.databinding.ScreenMainBinding
import uz.pixelgame.mymarketplace.presentation.adapter.MainAdapter
import uz.pixelgame.mymarketplace.presentation.base.BaseFragment

class MainScreen : BaseFragment(R.layout.screen_main) {
    private val binding by viewBinding(ScreenMainBinding::bind)
    override fun onCreate(view: View, savedInstanceState: Bundle?) {
        setBottomNavBar()
        setAdapter()
    }

    private fun setBottomNavBar() {

        binding.viewPager.isUserInputEnabled = false

        binding.viewPager.post {
            binding.viewPager.currentItem = 1
            resetAllMenuIcons(binding.bottomNavBar.getChildAt(1))
            getItem(1).setImageResource(R.drawable.ic_catalog_selected)
            ((binding.bottomNavBar.getChildAt(1) as LinearLayout).getChildAt(1) as TextView).setTextColor(context?.getColor(R.color.pink)!!)

        }

        binding.bottomNavBar.getChildAt(0).setOnClickListener {
            binding.viewPager.currentItem = 0
            resetAllMenuIcons(binding.bottomNavBar.getChildAt(0))
            getItem(0).setImageResource(R.drawable.ic_home_selected)
            ((binding.bottomNavBar.getChildAt(0) as LinearLayout).getChildAt(1) as TextView).setTextColor(context?.getColor(R.color.pink)!!)
        }
        binding.bottomNavBar.getChildAt(1).setOnClickListener {
            binding.viewPager.currentItem = 1
            resetAllMenuIcons(binding.bottomNavBar.getChildAt(1))
            getItem(1).setImageResource(R.drawable.ic_catalog_selected)
            ((binding.bottomNavBar.getChildAt(1) as LinearLayout).getChildAt(1) as TextView).setTextColor(context?.getColor(R.color.pink)!!)
        }
        binding.bottomNavBar.getChildAt(2).setOnClickListener {
            binding.viewPager.currentItem = 2
            resetAllMenuIcons(binding.bottomNavBar.getChildAt(2))
            getItem(2).setImageResource(R.drawable.ic_bag_selected)
            ((binding.bottomNavBar.getChildAt(2) as LinearLayout).getChildAt(1) as TextView).setTextColor(context?.getColor(R.color.pink)!!)
        }
        binding.bottomNavBar.getChildAt(3).setOnClickListener {
            binding.viewPager.currentItem = 3
            resetAllMenuIcons(binding.bottomNavBar.getChildAt(3))
            getItem(3).setImageResource(R.drawable.ic_promotion_selected)
            ((binding.bottomNavBar.getChildAt(3) as LinearLayout).getChildAt(1) as TextView).setTextColor(context?.getColor(R.color.pink)!!)
        }
        binding.bottomNavBar.getChildAt(4).setOnClickListener {
            binding.viewPager.currentItem = 4
            resetAllMenuIcons(binding.bottomNavBar.getChildAt(4))
            getItem(4).setImageResource(R.drawable.ic_person_selected)
            ((binding.bottomNavBar.getChildAt(4) as LinearLayout).getChildAt(1) as TextView).setTextColor(context?.getColor(R.color.pink)!!)

        }
    }

    private fun resetAllMenuIcons(item: View) {
        for (i in 0..<binding.bottomNavBar.childCount) {
            if (item != binding.bottomNavBar.getChildAt(i)) {
                when (i) {
                    0 -> {
                        getItem(i).setImageResource(
                            R.drawable.ic_home
                        )
                        ((binding.bottomNavBar.getChildAt(0) as LinearLayout).getChildAt(1) as TextView).setTextColor(
                            context?.getColor(R.color.textColor)!!
                        )
                    }

                    1 -> {
                        getItem(i).setImageResource(
                            R.drawable.ic_catalog
                        )
                        ((binding.bottomNavBar.getChildAt(1) as LinearLayout).getChildAt(1) as TextView).setTextColor(
                            context?.getColor(R.color.textColor)!!
                        )

                    }

                    2 -> {
                        getItem(i).setImageResource(
                            R.drawable.ic_bag
                        )
                        ((binding.bottomNavBar.getChildAt(2) as LinearLayout).getChildAt(1) as TextView).setTextColor(
                            context?.getColor(R.color.textColor)!!
                        )
                    }

                    3 -> {
                        getItem(i).setImageResource(
                            R.drawable.ic_promotion
                        )
                        ((binding.bottomNavBar.getChildAt(3) as LinearLayout).getChildAt(1) as TextView).setTextColor(
                            context?.getColor(R.color.textColor)!!
                        )

                    }

                    4 -> {
                        getItem(i).setImageResource(
                            R.drawable.ic_person
                        )
                        ((binding.bottomNavBar.getChildAt(4) as LinearLayout).getChildAt(1) as TextView).setTextColor(
                            context?.getColor(R.color.textColor)!!
                        )
                    }
                }
            }
        }
    }

    private fun getItem(id: Int): ImageView {
        return ((binding.bottomNavBar.getChildAt(id) as LinearLayout).getChildAt(0) as ImageView)
    }

    private fun setAdapter() {
        val adapter = MainAdapter(childFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter
    }
}

