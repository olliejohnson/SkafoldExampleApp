package com.example.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.app.data.AutonData
import com.example.app.data.EndData
import com.example.app.data.TeleopData
import com.example.app.pages.AutonPage
import com.example.app.pages.EndPage
import com.example.app.pages.TeleopPage
import com.example.app.ui.theme.SkafoldExampleAppTheme
import io.oliverj.skaffold.skafold

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SkafoldExampleAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    skafold(applicationContext, modifier = Modifier.padding(innerPadding)) {
                        builtin()

                        "auton" page AutonPage(nav go "teleop", nav go "home") data AutonData()
                        "teleop" page TeleopPage(nav go "end", nav go "auton") data TeleopData()
                        "end" page EndPage(nav go "home", nav go "teleop") data EndData()
                    }
                }
            }
        }
    }
}