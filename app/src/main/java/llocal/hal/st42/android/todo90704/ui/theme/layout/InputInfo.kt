package llocal.hal.st42.android.todo90704

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

//入力フォーム設定関数
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TodoInputText(
    text: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    onImeAction: () -> Unit = {}
){
    val keyboardController = LocalSoftwareKeyboardController.current
    OutlinedTextField(
        value = text,
        onValueChange = onTextChange,
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
        maxLines = 1,
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = {
            onImeAction()
            keyboardController?.hide()
        }),
        modifier = modifier
    )
}



//入力フォームの画面
@Composable
fun InputInfo(navController: NavController) {
    val checkedState = remember { mutableStateOf(true) }
    val (text, setText) = remember { mutableStateOf("") }
    val (apd, setApd) = remember { mutableStateOf("") }


    //バーのボタン設定
    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text(text = "ToDo")},
                actions = {
                    IconButton(onClick = {
                        navController.navigate("MainActivity")
                    }) {
                        Icon(Icons.Filled.Add, contentDescription = "Edit text")
                    }
                },
            )
        }
    ) {
        Text(text = "タスク情報登録",
            modifier = Modifier.padding(top = 60.dp))

        Column(Modifier.padding(top = 90.dp)) {
            Row(){
                Text(text = "タスク名:")

                TodoInputText(
                    text = text,
                    onTextChange = setText,
                    modifier = Modifier
                        .padding(end = 8.dp)
                )
            }

            Row {
                Text(text = "期限:")

                showDatePiker()

                Text(text = "完了タスク:")
                Switch(
                    checked = checkedState.value,
                    onCheckedChange = { checkedState.value = it }
                )
            }

            Row(){
                Text(text = "詳細:")
            }

            DetailInfoText(text = apd, onTextChange = setApd,Modifier.fillMaxSize(1f))
        }
    }
}




@Composable
fun PreviewInfo(navController: NavController){
    Column() {
        InputInfo(navController = navController)
    }

}

