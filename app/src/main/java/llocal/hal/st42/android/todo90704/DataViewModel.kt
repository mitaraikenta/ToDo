package llocal.hal.st42.android.todo90704

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataViewModel: ViewModel() {
    private var _inputData = MutableLiveData(listOf<TodoItem>())
    var inputData: LiveData<List<TodoItem>> = _inputData

}