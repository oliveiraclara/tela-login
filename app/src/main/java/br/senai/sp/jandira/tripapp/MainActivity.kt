package br.senai.sp.jandira.tripapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tripapp.ui.theme.TripAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TripAppTheme {
                TripAppScreen()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun TripAppScreen(){

    var emailUser by rememberSaveable {
        mutableStateOf("")
    }
    var passwordUser by rememberSaveable {
        mutableStateOf("")
    }

    
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            //Header
            Card(
                modifier = Modifier
                    .height(50.dp)
                    .width(120.dp),
                backgroundColor = Color(red = 207, green = 6, blue = 240),
            ) {
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp)
            ) {
                //Form
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = stringResource(id = R.string.title),
                        fontSize = 48.sp,
                        color = Color(red = 207, green = 6, blue = 240),
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = stringResource(id = R.string.please_sign_up),
                        color = Color(red = 160, green = 156, blue = 156)
                    )
                }
                Spacer(modifier = Modifier.height(87.dp))
                Column()
                {
                    OutlinedTextField(value = emailUser, onValueChange = { emailUser = it },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        label = { Text(text = stringResource(id = R.string.email)) }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    OutlinedTextField(value = passwordUser, onValueChange = { passwordUser = it },
                        modifier = Modifier.fillMaxWidth(),
                        //Image(painter = painterResource(id = R.drawable.email), contentDescription = "" ),
                        shape = RoundedCornerShape(16.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        label = { Text(text = stringResource(id = R.string.password)) }
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.End
                    ) {
                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .width(134.dp)
                                .height(48.dp),
                            shape = RoundedCornerShape(15.dp)
                        ) {
                            Text(
                                text = stringResource(id = R.string.sign_in),
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Spacer(modifier = Modifier.height(31.dp))
                        Row() {
                            Text(
                                text = stringResource(id = R.string.not_have_account),
                                color = Color(red = 160, green = 156, blue = 156),
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = stringResource(id = R.string.sign_up),
                                color = Color(red = 207, green = 6, blue = 240),
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
                //Footer

            }
        }
    }
    
}