package llocal.hal.st42.android.todo90704


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavMain(){
    
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "InputInfo"){
        composable("InputInfo"){ PreviewInfo(navController = navController)}
        composable("mainActivity"){}
    }
}