package com.example.limonada

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.limonada.ui.theme.LimonadaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LimonadaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    applimonada()

                }
            }
        }
    }
}
@Preview
@Composable
fun applimonada() {
  var tela= 4

  when (tela) {
      1 -> Conteudoapp(
          R.string.limoeiro,
          R.drawable.limoeiro,
          onImageCick =  {
              tela= 1
          }
      )


      2 -> Conteudoapp(
          R.string.limao,
      R.drawable.espremelimao)
      3 -> Conteudoapp(
          R.string.copo_de_limonada,
          R.drawable.limonada)
      4 -> Conteudoapp(
          R.string.copo_vazio,
          R.drawable.reiniciar)
  }

}
@Composable
fun Conteudoapp(recursoTextoId:Int, recursoImagemId:Int, onImageCick:()->Unit){


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(recursoTextoId),
            modifier = Modifier.padding(bottom = 20.dp),
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            color = Color.Black

        )
        Image(
            painter = painterResource(id = recursoImagemId),
            contentDescription = null,
            Modifier
                .size(350.dp)
                .border(
                    BorderStroke(2.dp, Color.Cyan),
                    RoundedCornerShape(16.dp)

                )
                .clickable(onClick =onImageCick)
        )
    }
}



