package uz.pixelgame.mymarketplace.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.pixelgame.mymarketplace.data.model.ProductResponse
import uz.pixelgame.mymarketplace.domain.repository.Repository
import uz.pixelgame.mymarketplace.utill.ResultWrapper
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    private val successLiveData: MutableLiveData<ProductResponse?> = MutableLiveData<ProductResponse?>()
    val successResponseEvery: LiveData<ProductResponse?>
        get() = successLiveData

    private val errorLiveData: MutableLiveData<String?> = MutableLiveData<String?>()
    val errorResponseEvery: LiveData<String?>
        get() = errorLiveData

    fun getProducts(){
        viewModelScope.launch {

            when (val result = repository.getProducts()) {
                is ResultWrapper.Success -> {
                    successLiveData.postValue(result.data)
                }

                is ResultWrapper.Error -> {
                    errorLiveData.postValue(result.message.toString())
                }

                is ResultWrapper.NetworkError -> {
                    errorLiveData.postValue("No internet")
                }
            }
        }
    }

}