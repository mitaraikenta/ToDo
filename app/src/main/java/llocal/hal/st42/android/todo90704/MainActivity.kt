package llocal.hal.st42.android.todo90704

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import llocal.hal.st42.android.todo90704.ui.theme.ToDo90704Theme
import llocal.hal.st42.android.todo90704.ui.theme.data.TodoViewModel

class MainActivity : ComponentActivity() {

    lateinit var navController:NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        val todoViewModel = ViewModelProvider(this).get(TodoViewModel::class.java)


        setContent{
            ToDo90704Theme{
                navController = rememberNavController()

                NavMain()
            }
            MaterialTheme {
                CustomerList(todoViewModel)
            }
        }
    }
}

@Composable
fun CustomerList(todoViewModel: TodoViewModel){
    val customerList = todoViewModel.fetchAllCustomer()

}


















