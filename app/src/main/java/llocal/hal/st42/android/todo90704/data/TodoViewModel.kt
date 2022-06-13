package llocal.hal.st42.android.todo90704.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TodoViewModel(appObj: Application) : AndroidViewModel(appObj) {
    private val todoRepository: TodoRepository = TodoRepository(appObj)
    fun fetchAllCustomer(): LiveData<List<TodoDatabase>> {
        return todoRepository.readAllCustomer
    }

    fun insertCustomer(task: Tasks) {
        viewModelScope.launch {
            todoRepository.insertUser(task = task)
        }

    }

    fun deleteCustomerById(id: Int) {
        viewModelScope.launch {
            todoRepository.deleteCustomerById(id)
        }

    }
}