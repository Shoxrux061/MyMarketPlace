package uz.pixelgame.mymarketplace.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import uz.pixelgame.mymarketplace.data.cache.AppCache


@HiltAndroidApp
class App : Application(){
    override fun onCreate() {
        super.onCreate()
        AppCache.init(this)
    }
}