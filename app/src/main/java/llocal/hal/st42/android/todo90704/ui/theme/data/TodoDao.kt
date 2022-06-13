package llocal.hal.st42.android.todo90704.ui.theme.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TodoDao {
    @Query("SELECT * FROM Tasks")
    fun fetchAllTodo():LiveData<List<TodoDatabase>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(tasks: Tasks)

    @Query("DELETE FROM tasks where id = :id")
    suspend fun deleteTodoById(id: Int)

    @Query("DELETE FROM tasks")
    suspend fun deleteAllTodo()
}