package llocal.hal.st42.android.todo90704

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//入力フォーム設定関数
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TodoChangeText(
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

@Composable
fun changeInfo(){
    val checkedState = remember { mutableStateOf(true) }
    val (text, setText) = remember { mutableStateOf("") }
    val (apd, setApd) = remember { mutableStateOf("") }


    Text(text = "タスク情報更新",
        modifier = Modifier.padding(top = 60.dp))

    Column(Modifier.padding(top = 90.dp)) {
        Row(){
            Text(text = "タスク名:")

            TodoChangeText(
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



