package llocal.hal.st42.android.todo90704.ui.theme.data

import android.app.Application
import androidx.lifecycle.LiveData

class TodoRepository(application: Application) {
    private var todoDao : TodoDao

    init {
        val database = TodoDatabase.getDatabase(application)
        todoDao = database.TodoDao()
    }


    val readAllCustomer:LiveData<List<TodoDatabase>> = todoDao.fetchAllTodo()
    suspend fun insertUser(task: Tasks) {
        todoDao.insertTodo(task)
    }

    suspend fun deleteCustomerById(id: Int) {
        todoDao.deleteAllTodo()
    }

    suspend fun deleteAllCustomer() {
        todoDao.deleteAllTodo()
    }

    init {
        val database = TodoDatabase.getDatabase(application)
        todoDao = database.TodoDao()
    }
}