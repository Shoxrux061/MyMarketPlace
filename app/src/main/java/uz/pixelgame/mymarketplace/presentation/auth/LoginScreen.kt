package uz.pixelgame.mymarketplace.presentation.auth

import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.SpannableString
import android.text.TextWatcher
import android.text.style.UnderlineSpan
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.pixelgame.mymarketplace.R
import uz.pixelgame.mymarketplace.data.cache.AppCache
import uz.pixelgame.mymarketplace.databinding.ScreenLoginBinding
import uz.pixelgame.mymarketplace.presentation.base.BaseFragment

class LoginScreen : BaseFragment(R.layout.screen_login) {
    private val binding by viewBinding(ScreenLoginBinding::bind)
    override fun onCreate(view: View, savedInstanceState: Bundle?) {

        setUnderLinedText()
        setRussianTextFilter(binding.nameEdt)
        setRussianTextFilter(binding.surnameEdt)
        setDigitsOnlyFilter(binding.phoneEdt)
        setActions()
    }

    private fun setActions() {
        binding.enterBtn.setOnClickListener {
            if (checkLoginIsFull()) {
                AppCache.getObject().setSigned(true)
                AppCache.getObject().setName(binding.nameEdt.text.toString())
                AppCache.getObject().setSurname(binding.surnameEdt.text.toString())
                AppCache.getObject().setNumber(binding.phoneEdt.text.toString())
                findNavController().navigate(LoginScreenDirections.actionLoginScreenToMainScreen())
            } else {
                Toast.makeText(context, "Заполните полностью", Toast.LENGTH_SHORT).show()
            }
        }

        binding.surnameClear.setOnClickListener {
            binding.surnameEdt.text.clear()
        }
        binding.nameClear.setOnClickListener {
            binding.nameEdt.text.clear()
        }
        binding.phoneClear.setOnClickListener {
            binding.phoneEdt.text?.clear()
        }

        binding.nameEdt.addTextChangedListener {
            checkLoginIsFull()
        }
        binding.surnameEdt.addTextChangedListener {
            checkLoginIsFull()
        }
        binding.phoneEdt.addTextChangedListener {
            checkLoginIsFull()
        }
    }

    private fun checkLoginIsFull(): Boolean {

        if(binding.nameEdt.text.isNotEmpty() && binding.nameEdt.text.isNotBlank()){
            binding.nameClear.visibility = View.VISIBLE
        }else{
            binding.nameClear.visibility = View.GONE

        }
        if(binding.surnameEdt.text.isNotEmpty() && binding.surnameEdt.text.isNotBlank()){
            binding.surnameClear.visibility = View.VISIBLE
        }else{
            binding.surnameClear.visibility = View.GONE
        }

        if(binding.phoneEdt.text!!.isNotBlank() && binding.phoneEdt.text!!.isNotEmpty()){
            binding.phoneClear.visibility = View.VISIBLE
        }else{
            binding.phoneClear.visibility = View.GONE
        }

        return if (binding.nameEdt.text.isNotEmpty()
            && binding.nameEdt.text.isNotBlank()
            && binding.surnameEdt.text.isNotEmpty()
            && binding.surnameEdt.text.isNotBlank()
            && binding.phoneEdt.text?.length == binding.phoneEdt.mask?.length
            && binding.nameEdt.error == null
            && binding.surnameEdt.error == null
        ) {
            binding.enterBtn.setCardBackgroundColor(requireContext().getColor(R.color.activeButtonColor))
            true
        } else {
            binding.enterBtn.setCardBackgroundColor(requireContext().getColor(R.color.notActiveButtonColor))
            false
        }
    }

    private fun setUnderLinedText() {
        val text = "условия программы лояльности"
        val spannableString = SpannableString(text)
        spannableString.setSpan(UnderlineSpan(), 0, 28, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.underlineText.text = spannableString
    }

    private fun setDigitsOnlyFilter(editText: EditText) {
        val filter = InputFilter { source, start, end, _, _, _ ->
            val builder = StringBuilder()
            for (i in start until end) {
                val character = source?.get(i)
                if (character?.isDigit() == true) {
                    builder.append(character)
                }
            }
            builder.toString()
        }
        val filters = arrayOf(filter)
        editText.filters = filters
    }

    private fun setRussianTextFilter(editText: EditText) {
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val inputText = s.toString()
                val containsNonCyrillic = checkForNonCyrillic(inputText)
                if (containsNonCyrillic) {
                    editText.error = "Только кириллица разрешена"
                } else {
                    editText.error = null
                }
            }
        })
    }

    fun checkForNonCyrillic(text: String): Boolean {
        if (text.isBlank()) {
            return false
        }
        val cyrillicPattern = Regex("[а-яё]+", RegexOption.IGNORE_CASE)
        return !cyrillicPattern.matches(text.trim())
    }
}