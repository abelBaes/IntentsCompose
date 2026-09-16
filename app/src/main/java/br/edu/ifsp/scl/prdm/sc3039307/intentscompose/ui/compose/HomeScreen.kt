package br.edu.ifsp.scl.prdm.sc3039307.intentscompose.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    currentText: String,
    modifier: Modifier = Modifier,
    nextScreenClick: (String) -> Unit,
    resetWorldClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Tela Inicial",
            modifier = Modifier.padding(5.dp),
            fontSize = 30.sp
        )
        Text(
            text = "Texto concatenado",
            modifier = Modifier.padding(5.dp),
            fontSize = 20.sp
        )
        Text(
            text = currentText,
            modifier = Modifier.padding(15.dp),
            fontSize = 20.sp
        )
        Button(
            onClick = { nextScreenClick(currentText) },
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Text(
                text = "Adicionar palavra",
                fontSize = 15.sp
            )
        }
        Button(
            onClick = resetWorldClick
        ) {
            Text(
                text = "Reiniciar",
                fontSize = 15.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        currentText = "Texto Exemplo",
        modifier = Modifier,
        nextScreenClick = {},
        resetWorldClick = {}
    )
}