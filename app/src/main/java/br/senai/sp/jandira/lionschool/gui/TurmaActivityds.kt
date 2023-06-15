package br.senai.sp.jandira.lionschool.gui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lionschool.R
import br.senai.sp.jandira.lionschool.ui.theme.LionSchoolTheme

class TurmaActivityds : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LionSchoolTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),

                    ) {
                    Greeting3("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting3(name: String) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(176, 196, 222))


    ) {

        Column(
            modifier = Modifier
                .width(500.dp)
                .background(Color(0,0,0)),





            )

        { Row(
            modifier = Modifier
                .fillMaxWidth()
                .absolutePadding(200.dp)



        ) {
            Image(
                painter = painterResource(id = R.drawable.lionschol), contentDescription = null
            )

        }



            Button(
                onClick = { /*TODO*/ },

                ) {
                Image(
                    painter = painterResource(id = R.drawable.voltar),
                    contentDescription = null
                )
            }



        }



        Spacer(modifier = Modifier.height(35.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp)
        ) {


        }

        Spacer(modifier = Modifier.height(35.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 18.dp)
            , horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Card(
                modifier = Modifier
                    .height(25.dp)
                    .width(85.dp),
                shape = CircleShape,


                ) {
                Text(
                    text = "Todos",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color(0,0,0)

                )
            }

            Card(
                modifier = Modifier
                    .height(25.dp)
                    .width(85.dp),
                shape = CircleShape,
                backgroundColor = Color(229, 182, 87)
            ) {
                Text(
                    text = "Cursando",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center

                )
            }

            Card(
                modifier = Modifier
                    .height(25.dp)
                    .width(85.dp),
                shape = CircleShape,
                backgroundColor = Color(16,	130,	190)
            ) {
                Text(
                    text = "Finalizados",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center

                )
            }

        }

        Spacer(modifier = Modifier.height(55.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .padding(horizontal = 35.dp),
            shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp, bottomStart = 30.dp, bottomEnd = 30.dp),
            backgroundColor = Color(16, 130, 190),
            border = BorderStroke (3.dp, Color.Black)
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 30.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    shape = CircleShape,
                    backgroundColor = Color(16,130,190)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.aluno),
                        contentDescription = null,
                        modifier = Modifier.size(100.dp)

                    )
                }

                Column(
                    modifier = Modifier.fillMaxHeight().
                    fillMaxWidth()
                        .padding(vertical = 20.dp, horizontal = 20.dp),
                    verticalArrangement = Arrangement.SpaceBetween,

                    ) {

                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Luis Oliveira",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        textAlign = TextAlign.Center

                    )

                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Finalizado",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )


                }

            }


        }




    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview3() {
    LionSchoolTheme {
        Greeting3("Android")
    }
}