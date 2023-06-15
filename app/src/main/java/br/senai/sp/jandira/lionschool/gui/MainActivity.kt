package br.senai.sp.jandira.lionschool.gui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lionschool.model.CoursesList
import br.senai.sp.jandira.lionschool.ui.theme.LionSchoolTheme
import br.senai.sp.jandira.lionschool.service.RetrofitFactory
import retrofit2.Response
import retrofit2.Callback
import retrofit2.Call

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LionSchoolTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    var curso by remember {
        mutableStateOf(listOf<br.senai.sp.jandira.lionschool.model.Course>())
    }
    val context = LocalContext.current




    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(255, 255, 255))
    ) {
        Column(
            modifier = Modifier
                .background(Color(0, 0, 0))
        ) {


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp),
                horizontalArrangement = Arrangement.Center

            ) {
                Text(
                    text = stringResource(id = br.senai.sp.jandira.lionschool.R.string.app_name),
                    fontSize = 50.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                )


            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp),
                horizontalArrangement = Arrangement.Center


            ) {
                Text(
                    text = "Escolha um curso para gerenciar",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,

                    )

            }


            Spacer(modifier = Modifier.height(height = 35.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = br.senai.sp.jandira.lionschool.R.drawable.lionschol),
                    contentDescription = null,
                    modifier = Modifier.size(170.dp)
                )
            }


        }

        // Chamada para a API

        val call = RetrofitFactory().getCourseService().getCourses()

        call.enqueue(object : Callback<CoursesList> {
            override fun onResponse(
                call: Call<CoursesList>, response: Response<CoursesList>

            ) {
                curso = response.body()!!.curso
            }

            override fun onFailure(call: Call<CoursesList>, t: Throwable) {
                Log.i("ds2m", "onFailure: ${t.message}")
            }


        })


        LazyRow(modifier = Modifier.fillMaxWidth()){
          items(curso){
              Log.i("Cursos", "${curso}: ")
              Row(
                  modifier = Modifier
                      .fillMaxWidth()
                      .fillMaxWidth()


              ) {
                  Card(modifier = Modifier
                      .fillMaxWidth()
                      .align(alignment = CenterVertically)
                      .size(100.dp)
                      .background(Color.Black)
                      .padding(start = 4.dp)
                      .clickable {
                          val intent = Intent(context, TurmaActivity::class.java)
                          intent.putExtra("siglaCurso", it.sigla)
                          intent.putExtra("nomeCurso", it.nome)
                          context.startActivity(intent)


                      }) {
                      Text(
                          modifier = Modifier
                              .fillMaxWidth()
                              .padding(top = 25.dp),
                          text = it.sigla,
                          color = Color.Black,
                          fontSize = 30.sp,
                          fontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif,
                          fontStyle = FontStyle.Normal,
                          textAlign = TextAlign.Center,
                      )


                  }

              }
          }

        }




        Spacer(modifier = Modifier.height(height = 35.dp))








    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    LionSchoolTheme {
        Greeting("Android")
    }
}