package com.arekusalex.parcial1.ui.revista.recyclerview.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.arekusalex.parcial1.RevistaReviewerApplication
import com.arekusalex.parcial1.data.model.RevistaModel
import com.arekusalex.parcial1.repositories.RevistaRepository

class RevistaViewModel (private val repository: RevistaRepository) : ViewModel() {
    var name = MutableLiveData("")
    var subject = MutableLiveData("")
    var status = MutableLiveData("")

    fun getRevistas() = repository.getRevistas()

    fun addRevistas(revista: RevistaModel) = repository.addRevistas(revista)

    fun createRevista() {
        if (!validateData()) {
            status.value = WRONG_INFORMATION
            return
        }

        val revista = RevistaModel(
            name.value!!,
            subject.value!!,
        )

        addRevistas(revista)
        clearData()

        status.value = REVISTA_CREATED
    }

    private fun validateData(): Boolean{
        when{
            name.value.isNullOrEmpty() -> return false
            subject.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun clearData(){
        name.value = ""
        subject.value = ""
    }

    fun clearStatus(){
        status.value = INACTIVE
    }

    fun setSelectedRevista(revista: RevistaModel){
        name.value = revista.name
        subject.value = revista.subject
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as RevistaReviewerApplication
                RevistaViewModel(app.revistaRepository)
            }
        }

        const val REVISTA_CREATED = "Revista Created"
        const val WRONG_INFORMATION = "Wrong Information"
        const val INACTIVE = ""

    }

}