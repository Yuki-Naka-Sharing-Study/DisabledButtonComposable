package com.example.disabledbutton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.ui.tooling.preview.Preview
import com.example.disabledbutton.ui.theme.DisabledButtonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DisabledButtonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ButtonWithEmptyTextCheck()
                }
            }
        }
    }
}

@Composable
fun ButtonWithEmptyTextCheck() {
    // テキストフィールドの状態を管理
    var inputText by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // テキスト入力フィールド
        TextField(
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text("テキストを入力") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        // ボタン
        Button(
            onClick = { /* ボタンが押されたときの処理 */ },
            enabled = inputText.isNotBlank(), // 空文字でなければボタンを有効化
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("送信")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonWithEmptyTextCheckPreview() {
    DisabledButtonTheme {
        ButtonWithEmptyTextCheck()
    }
}