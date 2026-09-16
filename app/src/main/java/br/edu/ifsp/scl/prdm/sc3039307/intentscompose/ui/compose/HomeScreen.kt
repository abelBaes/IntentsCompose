package br.edu.ifsp.scl.prdm.sc3039307.intentscompose.ui.compose

import android.R.attr.textSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(currentText: String, modifier: Modifier, nextScreenClick: (String) -> Unit, resetWorldClick: () -> Unit) {
    val currentText by remember { mutableStateOf(currentText) }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Tela Inicial",
            Modifier.padding(5.dp),
            fontSize = 30.sp
        )
        Text(
            text = "Texto concatenado",
            Modifier.padding(5.dp),
            fontSize = 20.sp
        )
        Text(
            text = "",
            Modifier.padding(15.dp),
            fontSize = 20.sp
        )
        Button(
            onClick = {nextScreenClick(currentText)},
            Modifier.padding(top = 20.dp)) {
            Text(
                text = "Adicionar palavra",
                fontSize = 15.sp
            )
        }
        Button(
            onClick = resetWorldClick) {
            Text(
                text = "Reniciar",
                fontSize = 15.sp
            )
        }
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        "SomeText",
        Modifier,
        {},
        {}
    )
}